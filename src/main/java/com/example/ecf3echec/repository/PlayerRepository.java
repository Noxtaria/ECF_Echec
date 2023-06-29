package com.example.ecf3echec.repository;

import com.example.ecf3echec.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    public Player findAll(String name);

    public Optional<Player> findById(long id);

}
