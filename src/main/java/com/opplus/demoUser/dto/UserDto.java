package com.opplus.demoUser.dto;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto  implements Serializable{
	 
	private static final long serialVersionUID = 4635758281185857792L;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
}
