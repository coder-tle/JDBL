package com.digiLib.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="roles")
public class Role {
	@Id
	@GeneratedValue
	private int id;
	private String name;
}
