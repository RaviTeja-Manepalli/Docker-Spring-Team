package com.mindtree.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.team.model.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
