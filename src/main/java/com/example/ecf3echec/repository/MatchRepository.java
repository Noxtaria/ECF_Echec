package com.example.ecf3echec.repository;

import com.example.ecf3echec.entity.Matches;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;


@Repository
public interface MatchRepository extends CrudRepository<Matches, Long> {

    Optional<Matches> findById(Long matchId);

    List<Matches> findByPlayer1(String player);

    List<Matches> findByPlayer2(String player);

    List<Matches> findByStartDateAfter(LocalDateTime startDate);

    @Query("SELECT m FROM Matches m WHERE m.previousMatches IS NOT EMPTY")
    List<Matches> findPreviousMatches();

}


