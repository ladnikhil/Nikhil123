package com.dev.csvtodatabse;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


import com.dev.csvtodatabse.model.User;

@Component
public class UserItemProcessor implements ItemProcessor<User, User>{

	@Override
	public User process(User user) throws Exception {
		
		return user;
	}

}
