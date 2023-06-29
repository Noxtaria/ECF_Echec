package com.example.ecf3echec.service;

import com.example.ecf3echec.entity.Player;
import com.example.ecf3echec.exception.PlayerNotFoundException;
import com.example.ecf3echec.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(String name) {
        Player player = new Player(name);
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Joueur non trouvé avec l'ID : " + id));
    }



}

