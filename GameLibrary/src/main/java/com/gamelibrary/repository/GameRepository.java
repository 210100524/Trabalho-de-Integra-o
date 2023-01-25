package com.gamelibrary.repository;


import com.gamelibrary.dto.GameDTO;
import com.gamelibrary.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game,UUID> {

    List<Game> findByGameNameContainingIgnoreCase(String expression);
    //List<GameDTO> findByGenre(String genre);
}

