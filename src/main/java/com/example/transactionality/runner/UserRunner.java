package com.example.transactionality.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.transactionality.model.User;
import com.example.transactionality.service.UserService;

@Component
public class UserRunner implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		try {
			User user1 = new User("Ankur", "SFDC", 10000L);
			User user2 = new User("Sumit", "Teacher", 20000L);
			User user3 = new User("Chayan Dutta", "Font End", 100000L);

			List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3));

			userService.insert(userList);

		} catch (RuntimeException e) {
			System.out.println("Exception" + e.getMessage());
		}

		System.out.println("Get User Details :" + userService.getUsers());

	}

}
