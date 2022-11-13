package com.example.FootballPlayerList;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.FootballPlayerList.domain.Player;
import com.example.FootballPlayerList.domain.PlayerRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class PlayerRepositoryTest {
	@Autowired
	private PlayerRepository repository;

	@Test // testing findByName-method from ClothRepository
	public void findByNameShouldReturnProductName() {
		List<Player> players = repository.findByName("Lionel Messi");

		assertThat(players).hasSize(1);
		assertThat(players.get(0).getPosition()).isEqualTo("Center Forward");
}
}
