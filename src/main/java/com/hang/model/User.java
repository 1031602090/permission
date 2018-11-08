package com.hang.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class User {

	@NotEmpty
	private String username;

	@NotNull
	private Integer id;
}
