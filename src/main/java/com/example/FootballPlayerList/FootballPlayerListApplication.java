package com.example.FootballPlayerList;

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

	public static void main(String[] args) {
		SpringApplication.run(FootballPlayerListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PlayerRepository repository, PositionRepository prepository) {return (args) -> {
		
		prepository.save(new Position("Center Forward"));
		prepository.save(new Position("Left Wing"));
		prepository.save(new Position("Right Wing"));
				
		repository.save(new Player("Lionel Messi", "Argentina", 35, prepository.findByName("Center Forward").get(0)));



		
	};
	}
}
