package com.example.ecf3echec.service;

import com.example.ecf3echec.entity.Matches;
import com.example.ecf3echec.exception.MatchNotFoundException;
import com.example.ecf3echec.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Matches createMatch(String player1, String player2) {
        Matches matches = new Matches(player1, player2);
        return matchRepository.save(matches);
    }

    public List<Matches> getUpcomingMatches() {
        LocalDateTime now = LocalDateTime.now();
        return matchRepository.findByStartDateAfter(now);
    }

    public void updateMatchResult(Long matchId, String result) {
        Matches matches = matchRepository.findById(matchId)
                .orElseThrow(() -> new MatchNotFoundException("Match non trouvé avec l'ID : " + matchId));
        matches.setResult(result);
        matchRepository.save(matches);
    }

    public List<Matches> getPreviousMatches() {

        List<Matches> previousMatches = matchRepository.findPreviousMatches();

        return previousMatches;
    }

}
