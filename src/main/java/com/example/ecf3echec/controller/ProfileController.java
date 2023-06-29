package com.example.ecf3echec.controller;

import com.example.ecf3echec.entity.Player;
import com.example.ecf3echec.exception.PlayerNotFoundException;
import com.example.ecf3echec.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final PlayerService playerService;
    @Autowired
    public ProfileController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public String viewProfile(@PathVariable("id") Long playerId, Model model) {
        try {
            Player player = playerService.getPlayerById(playerId);
            model.addAttribute("player", player);
            return "profile";
        } catch (PlayerNotFoundException e) {
            return "redirect:/";
        }
    }

    @PostMapping("/{id}")
    public String updateProfile(@PathVariable("id") Long playerId, @ModelAttribute("player") Player updatedPlayer) {
        try {
            updatedPlayer.setId(playerId);
            playerService.updatePlayer(updatedPlayer);
            return "redirect:/profile/" + playerId;
        } catch (PlayerNotFoundException e) {

            return "redirect:/";
        }
    }


}

