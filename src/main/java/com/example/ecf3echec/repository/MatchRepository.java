package com.example.ecf3echec.repository;

import com.example.ecf3echec.entity.Matches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends CrudRepository<Matches, Long> {

    public Optional<Matches> findById(Long matchId);

    List<Matches> findByPlayer(String playerName);

    List<Matches> findUpcomingMatches();
}
