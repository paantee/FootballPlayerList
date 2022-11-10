package com.example.FootballPlayerList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.FootballPlayerList.domain.Player;
import com.example.FootballPlayerList.domain.PlayerRepository;
import com.example.FootballPlayerList.domain.Position;
import com.example.FootballPlayerList.domain.PositionRepository;
import com.example.FootballPlayerList.domain.User;
import com.example.FootballPlayerList.domain.UserRepository;

@SpringBootApplication
public class FootballPlayerListApplication {
	private static final Logger log = LoggerFactory.getLogger(FootballPlayerListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FootballPlayerListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PlayerRepository repository, PositionRepository prepository, UserRepository urepository) {return (args) -> {
		
		prepository.save(new Position("Center Forward"));
		prepository.save(new Position("Left Wing"));
		prepository.save(new Position("Right Wing"));
		prepository.save(new Position("Center Midfield"));
		prepository.save(new Position("Center Defensive Midfield"));
		prepository.save(new Position("Center Attacking Midfield"));
		prepository.save(new Position("Left Back"));
		prepository.save(new Position("Right Back"));
		prepository.save(new Position("Center Back"));
		prepository.save(new Position("Goalkeeper"));
				
		repository.save(new Player("Lionel Messi", "Argentina", 35, prepository.findByName("Center Forward").get(0), "PSG"));


	User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
	User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
	urepository.save(user1);
	urepository.save(user2); 
		
	};
	}
}
