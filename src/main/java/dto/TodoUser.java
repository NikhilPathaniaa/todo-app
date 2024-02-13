package dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import helper.AES;
import lombok.Data;

@Entity
@Data
public class TodoUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	String password;
	Long mobile;
	LocalDate dob;
	String gender;
	
	public void setPassword(String password)
	{
		this.password=AES.encrypt(password, "123");
	}
	public String getPassword()
	{
		return AES.decrypt(password, "123");
	}
	
}
