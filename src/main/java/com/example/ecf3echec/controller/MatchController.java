package com.example.ecf3echec.controller;

import com.example.ecf3echec.entity.Matches;
import com.example.ecf3echec.exception.MatchNotFoundException;
import com.example.ecf3echec.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/upcoming")
    public String getUpcomingMatches(Model model) {
        List<Matches> upcomingMatches = matchService.getUpcomingMatches();
        model.addAttribute("matches", upcomingMatches);
        return "match";
    }

    @PostMapping("/{id}/result")
    public String submitMatchResult(@PathVariable("id") Long matchId, @RequestParam("result") String result) {
        matchService.updateMatchResult(matchId, result);
        return "redirect:/matches";
    }

}
