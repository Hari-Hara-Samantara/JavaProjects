package com.hs.ipldashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hs.ipldashboard.model.Team;
import com.hs.ipldashboard.repository.MatchRepository;
import com.hs.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private MatchRepository matchRepository;

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		
		Team team = this.teamRepository.findByTeamName(teamName);
		team.setMatches(matchRepository.findLastestMatchesbyTeam(teamName, 4));
		return team;
	}
}
