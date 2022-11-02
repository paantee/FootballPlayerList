package com.example.FootballPlayerList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long positionid;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "position")
	private List<Player> players;
	
	public Position() {
		
	}

	public Position(String name) {
		super();
		this.name = name;
	}

	public Long getPositionid() {
		return positionid;
	}

	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
