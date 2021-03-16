package com.mindtree.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.team.exception.NoIdException;
import com.mindtree.team.model.Player;
import com.mindtree.team.model.Team;
import com.mindtree.team.service.ServiceImpl;

@RestController
@RequestMapping(path = "/team")
public class MainController {
	@Autowired
	ServiceImpl service;

	@PostMapping("/addteam")
	public ResponseEntity<?> createTeam(@RequestBody Team team) {
		try {
			Team team1 = service.addTeam(team);
			return new ResponseEntity<>(team1, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>("Failed ", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addplayer/{id}")
	public ResponseEntity<?> createPlayer(@RequestBody Player player, @PathVariable("id") int id) {
		try {
			Player player1 = service.addPlayer(player, id);
			return new ResponseEntity<>(player1, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>("Failed ", HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlayer(@PathVariable("id") int id) {
		try {
			boolean result = service.deleteplayer(id);
			return new ResponseEntity<>("Deleted player", HttpStatus.ACCEPTED);

		} catch (NoIdException e) {
			return new ResponseEntity<>("No data found to delete", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/getdetails/{teamname}")
	public ResponseEntity<?> getPlayers(@PathVariable("teamname") String teamname) {
		try {
			List<Player> players = service.getPlayersinTeam(teamname);
			return new ResponseEntity<>(players, HttpStatus.ACCEPTED);

		} catch (NoIdException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updatelocation/{id}/{location}")
	public ResponseEntity<?> updateLocation(@PathVariable("id") int id, @PathVariable("location") String location) {
		try {
			Team team = service.updateTeamLocation(id, location);
			return new ResponseEntity<>(team, HttpStatus.ACCEPTED);

		} catch (NoIdException e) {
			return new ResponseEntity<>("No data found ", HttpStatus.BAD_REQUEST);
		}
	}
	
		@GetMapping("/")
	public String getMessage() {
		return "[GET] https//localhost:8888/api/v1/all ->  gives list of employees\n"
				+ "[GET] https://localhost:8888/api/v1/get/{id} -> gives employee details based on ID\n"
				+ "[POST] https://localhost:8888/api/v1/add - > add employee\n"
				+ "[PUT] https://localhost:8888/api/v1/update/{id} - > updates employee name based on ID\n"
				+ "[DELETE] https://localhost:8888/api/v1/delete/{id} -> delete employee based on ID";
	}


}
