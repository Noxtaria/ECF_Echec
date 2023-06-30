package com.example.ecf3echec.service;

import com.example.ecf3echec.entity.Player;
import com.example.ecf3echec.exception.PlayerFoundException;
import com.example.ecf3echec.exception.PlayerNotActiveException;
import com.example.ecf3echec.exception.PlayerNotFoundException;
import com.example.ecf3echec.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private LoginService loginService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, LoginService loginService) {
        this.playerRepository = playerRepository;
        this.loginService = loginService;
    }

    public boolean signUp(String name, String email, String password) throws PlayerFoundException {
        Player existingPlayer = playerRepository.findByEmail(email);
        if (existingPlayer != null) {
            throw new PlayerFoundException("Le joueur existe déjà dans le tournoi.");
        }

        Player player = Player.builder().name(name).email(email).password(password).build();
        playerRepository.save(player);
        return player.getId() > 0;
    }

    public boolean signIn(String email, String password) throws PlayerNotFoundException, PlayerNotActiveException {
        Player player = playerRepository.findByEmailAndPassword(email, password);
        if (player == null) {
            throw new PlayerNotFoundException("Joueur introuvable.");
        }
        if (!player.isActive()) {
            throw new PlayerNotActiveException("Le joueur n'est pas actif dans le tournoi.");
        }
        return loginService.login(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) throws PlayerNotFoundException {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Joueur non trouvé avec l'ID : " + id));
    }

    public void updatePlayer(Player updatedPlayer) throws PlayerNotFoundException {
        Player existingPlayer = playerRepository.findById(updatedPlayer.getId())
                .orElseThrow(() -> new PlayerNotFoundException("Joueur introuvable."));
        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setEmail(updatedPlayer.getEmail());
        playerRepository.save(existingPlayer);
    }
}
