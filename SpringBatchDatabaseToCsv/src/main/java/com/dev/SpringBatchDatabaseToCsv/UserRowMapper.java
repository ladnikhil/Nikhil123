package com.dev.SpringBatchDatabaseToCsv;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dev.SpringBatchDatabaseToCsv.model.User;


public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
		   user.setId(rs.getInt("id"));
		   user.setName(rs.getString("name"));
		   
		   return user;
	}

}
