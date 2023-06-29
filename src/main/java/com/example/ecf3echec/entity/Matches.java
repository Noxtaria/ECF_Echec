package com.example.ecf3echec.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player1")
    private String player1;

    @Column(name = "player2")
    private String player2;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @OneToMany(mappedBy = "matches")
    private List<Game> previousMatches;


    private String result;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Matches() {
    }

    public Matches(String player1, String player2, String result) {
        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
    }

    public Matches(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
