package com.bezkoder.springjwt.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {

	public LoginRequest (String username, String password) {
		System.out.println("username: "+username);
		this.username = username;
		this.password = password;
	}




	@NotBlank
  private String username;

	@NotBlank
	private String password;
}
