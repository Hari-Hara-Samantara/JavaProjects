package com.hs.ipldashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hs.ipldashboard.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	Team findByTeamName(String teamName);
}
