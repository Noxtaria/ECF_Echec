package com.example.ecf3echec.repository;

import com.example.ecf3echec.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    public List<Player> findAll();

    public Optional<Player> findById(long id);

    public Player findByEmail(String email);

    public Player findByEmailAndPassword(String email, String password);
}
