package com.example.ecf3echec.controller;

import com.example.ecf3echec.entity.Matches;
import com.example.ecf3echec.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MatchService matchService;

    @Autowired
    public HomeController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Matches> upcomingMatches = matchService.getUpcomingMatches();
        model.addAttribute("upcomingMatches", upcomingMatches);
        return "home";
    }
}
