package com.example.ecf3echec.controller;

import com.example.ecf3echec.entity.Player;
import com.example.ecf3echec.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class ClassementController {

    private final PlayerService playerService;

    @Autowired
    public ClassementController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/classement")
    public String viewClassement(Model model) {
        List<Player> players = playerService.getAllPlayers();
        Collections.sort(players, Comparator.comparingInt(Player::getScore).reversed());
        model.addAttribute("players", players);
        return "classement";
    }
}
