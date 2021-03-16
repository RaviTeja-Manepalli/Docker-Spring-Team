package com.mindtree.team.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.team.exception.NoIdException;
import com.mindtree.team.model.Player;
import com.mindtree.team.model.Team;
import com.mindtree.team.repository.PlayerRepository;
import com.mindtree.team.repository.TeamRepository;

@Service
public class ServiceImpl {
	@Autowired
	TeamRepository teamRepo;
	@Autowired
	PlayerRepository playerRepo;

	public Player addPlayer(Player player, int id) throws ServiceException {
		// TODO Auto-generated method stub
		Team team = null;
		try {
			team = teamRepo.findById(id).get();
			player.setTeam(team);
			playerRepo.save(player);
			List<Player> players = team.getPlayers();
			System.out.println(player + " " + team.getTeamid());
			players.add(player);
			team.setPlayers(players);
			teamRepo.save(team);
			return player;

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());

		}

	}

	public Team addTeam(Team team) throws ServiceException {
		// TODO Auto-generated method stub
			try {
				teamRepo.save(team);
			} catch (Exception e) {
				throw new ServiceException("Invalid");

			}

		return team;

	}

	public boolean deleteplayer(int id) throws NoIdException {
		// TODO Auto-generated method stub
		try {
			playerRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new NoIdException(e);

		}

	}

	public List<Player> getPlayersinTeam(String teamname) throws NoIdException {
		// TODO Auto-generated method stub
		try {
			Team team = teamRepo.getTeamByTeamName(teamname);
			List<Player> playerList = team.getPlayers();
			return playerList;
		} catch (Exception e) {
			throw new NoIdException(e);

		}
	}

	public Team updateTeamLocation(int id, String location) throws NoIdException {
		// TODO Auto-generated method stub
		try {
			Team team = teamRepo.findById(id).get();
			team.setLocation(location);
			teamRepo.save(team);
			return team;
		} catch (Exception e) {
			throw new NoIdException(e);
		}
	}

}
