package com.mindtree.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.team.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
	
	public Team getTeamByTeamName(String teamname);

}
