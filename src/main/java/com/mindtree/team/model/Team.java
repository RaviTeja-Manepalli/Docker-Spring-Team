package com.mindtree.team.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {
	@Id
	private int teamid;
	private String teamName;
	private String location;
	@OneToMany(mappedBy = "team")
	@JsonIgnore
	private List<Player> players = new ArrayList<Player>();

	public Team() {
		super();
	}

	public Team(int teamid, String teamName, String location) {
		super();
		this.teamid = teamid;
		this.teamName = teamName;
		this.location = location;
	}

	public Team(int teamid, String teamName, String location, List<Player> players) {
		super();
		this.teamid = teamid;
		this.teamName = teamName;
		this.location = location;
		this.players = players;
	}

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
