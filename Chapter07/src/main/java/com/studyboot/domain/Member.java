package com.studyboot.domain;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {
	@Id
	private String id;
	private String name;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	
}
