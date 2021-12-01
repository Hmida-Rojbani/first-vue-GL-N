package de.tekup.vue.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private LocalDate dateOfBirth;
	
	private String email;
	
	public void setDate(String date) {
		this.dateOfBirth = LocalDate.parse(date);
	}
	
	public String getDate() {
		return this.dateOfBirth.format(DateTimeFormatter.ISO_DATE);
	}

}
