package com.mindtree.team.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Player {

	@Id
	private int id;
	private String name;
	private String role;
	private int age;
	@ManyToOne
	private Team team;

	public Player() {
		super();
	}

	public Player(int id, String name, String role, int age) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.age = age;
	}

	public Player(int id, String name, String role, int age, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.age = age;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
