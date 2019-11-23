package com.dev.SpringBatchDatabaseToCsv;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.dev.SpringBatchDatabaseToCsv.model.User;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/batch?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean
	public JdbcCursorItemReader<User> reader() {
		JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<User>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT id,name FROM user");
		reader.setRowMapper(new UserRowMapper());

		return reader;
	}

	
	  @Bean public TaskExecutor taskExecutor() { SimpleAsyncTaskExecutor
	  taskExecutor = new SimpleAsyncTaskExecutor();
	  taskExecutor.setConcurrencyLimit(4); return taskExecutor; }
	  
	 

	@Bean
	public UserItemProcessor processor() {
		return new UserItemProcessor();
	}

	@Bean
	public FlatFileItemWriter<User> writer() {
		FlatFileItemWriter<User> writer = new FlatFileItemWriter<User>();
		writer.setResource(new ClassPathResource("users.csv"));
		writer.setLineAggregator(new DelimitedLineAggregator<User>() {
			{
				setDelimiter(",");
				setFieldExtractor(new BeanWrapperFieldExtractor<User>() {
					{
						setNames(new String[] { "id", "name" });
					}
				});
			}
		});

		return writer;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<User, User>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	@Bean
	public Job exportUserJob() {
		return jobBuilderFactory.get("exportUserJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

}
