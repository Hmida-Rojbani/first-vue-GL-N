package de.tekup.vue.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class UserDB {
	
	@Getter private static List<User> users;
	
	static {
		users= new ArrayList<>();
		users.add(new User(1,"John Doe", "1234", LocalDate.of(2001, 9, 11), "john@gmail.com"));
		users.add(new User(2,"Jane Doe", "1234", LocalDate.of(2003, 11, 9), "jane@gmail.com"));
	}
	
	

}
