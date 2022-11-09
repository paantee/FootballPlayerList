package com.example.FootballPlayerList.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.FootballPlayerList.domain.Player;
import com.example.FootballPlayerList.domain.PlayerRepository;
import com.example.FootballPlayerList.domain.PositionRepository;


@Controller
public class PlayerController {
	@Autowired
	private PlayerRepository repository;
	@Autowired
	private PositionRepository prepository;
	
    @RequestMapping(value="login")
    public String login() {	
        return "login";
    }
	
	// Shows the player list
@RequestMapping(value = {"/", "/playerlist"}, method = RequestMethod.GET)
public String PlayerList(Model model) {
	model.addAttribute("players", repository.findAll());
	return "playerlist";
}

	// Rest way of showing the player list
@RequestMapping(value="/players", method = RequestMethod.GET)
public @ResponseBody List<Player> playerListRest() {
	return (List<Player>) repository.findAll();
}

	// Rest way of finding a player by id
@RequestMapping(value="/player/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long playerId) {	
	return repository.findById(playerId);
} 

	// Adds a player to the list
@RequestMapping(value = "/add")
public String addPlayer(Model model){
	model.addAttribute("player", new Player());
	model.addAttribute("positions", prepository.findAll());
    return "addplayer";
} 

	// Saves a player to the list
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Player player){
    repository.save(player);
    return "redirect:playerlist";
} 

	// Deletes player
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
	repository.deleteById(playerId);
    return "redirect:../playerlist";
}

	// Edits player
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public String editPlayer(@PathVariable("id") Long playerId, Model model) {
	model.addAttribute("player", repository.findById(playerId));
	model.addAttribute("positions", prepository.findAll());
	return "editplayer";
}

}

