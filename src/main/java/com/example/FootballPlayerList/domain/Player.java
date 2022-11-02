package com.example.FootballPlayerList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name, country;
	private int age;

	@ManyToOne
	@JoinColumn(name="categoryid")
	private Position position;
	
	public Player() {
		
	}
	
	public Player(String name, String country, int age) {
		super();
		this.name = name;
		this.country = country;
		this.age = age;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
