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

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private LoginService loginService;

    public boolean signUp(String name, String email, String password) throws PlayerFoundException {
        try {
            playerRepository.findByEmail(email);
            throw new PlayerFoundException("Le joueur existe déjà dans le tournoi.");
        }
        catch (Exception ex) {
            Player player = Player.builder().name(name).email(email).password(password).build();
            playerRepository.save(player);
            return player.getId() > 0;
        }
    }

    public boolean signIn(String email, String password) throws PlayerNotFoundException {
        try {
            Player player = playerRepository.findByEmailAndPassword(email, password);
            if (player.isActive()) {
                return loginService.login(player);
            }
            throw new PlayerNotActiveException("Le joueur n'est pas actif dans le tournoi.");
        } catch (PlayerNotActiveException ex) {
            throw new PlayerNotFoundException("Joueur introuvable.");
        } catch (Exception ex) {
            return false;
        }
    }


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

