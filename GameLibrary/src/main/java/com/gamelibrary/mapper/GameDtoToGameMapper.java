package com.gamelibrary.mapper;

import com.gamelibrary.dto.GameDTO;
import com.gamelibrary.model.DLC;
import com.gamelibrary.model.Developer;
import com.gamelibrary.model.Game;
import com.gamelibrary.model.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.UUID;
import java.util.function.Function;




@Component
public class GameDtoToGameMapper implements Function<GameDTO,Game> {

    @Override
    public Game apply(GameDTO dto) {

        UUID uuid = dto.getIdGame() == null ? null : UUID.fromString(dto.getIdGame());

        final Game game = Game.builder()
                .idGame(uuid)
                .imageUrl(dto.getImageUrl())
                .gameName(dto.getGameName())
                .rating(dto.getRating())
                .releaseYear(dto.getReleaseYear())
                .build();

        if (!ObjectUtils.isEmpty(dto.getDlc())) {
            game.setGameDlcs(dto.getDlc().stream().map(
                    dlcName -> new DLC(null, dlcName, game)
            ).toList());
        }

        if (!ObjectUtils.isEmpty(dto.getPublishers())) {
            game.setGamePublishers(dto.getPublishers().stream().map(
                    publisherName -> new Publisher(null, publisherName, game)
            ).toList());
        }

        if (!ObjectUtils.isEmpty(dto.getDevelopers())) {
            game.setGameDevelopers(dto.getDevelopers().stream().map(
                    developerName -> new Developer(null, developerName, game)
            ).toList());
        }



        return game;
    }
}
