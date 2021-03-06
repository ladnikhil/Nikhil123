package com.dev.SpringBatchDatabaseToCsv;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.dev.SpringBatchDatabaseToCsv.model.User;

@Component
public class UserItemProcessor implements ItemProcessor<User, User> {

	@Override
	public User process(User user) throws Exception {
		
		return user;
	}

}
