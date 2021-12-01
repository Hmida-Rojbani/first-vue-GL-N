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
	
	public static void remove(int id) {
		users.removeIf(user-> user.getId()==id);
	}
	
	public static void add(User user) {
		if(user.getId() == 0)
			user.setId(users.size()+1);
		else
			remove(user.getId());
		users.add(user);
	}

	public static User get(int id) {
		
		return users.stream()
					.filter(user -> user.getId() == id)
					.findFirst().get();
	}

}
