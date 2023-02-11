package com.hs.ipldashboard.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String teamName;
	private Long totalMatches;
	private Long totalWins;
	
	@Transient//indicates JPA don't use as column, developer will use for some logic
	private List<Match> matches;
	
	public Team(String teamName, Long totalMatches) {
		this.teamName = teamName;
		this.totalMatches = totalMatches;
	}
	
	
	
}
