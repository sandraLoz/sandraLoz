package com.opplus.demoUser.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuarios")
public class UserEntity  implements Serializable{
	private static final long serialVersionUID = 2078417115793871299L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "id_user")
	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
}
