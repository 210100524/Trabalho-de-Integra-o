package com.gamelibrary.mapper;

import com.gamelibrary.model.DLC;
import com.gamelibrary.model.Developer;
import com.gamelibrary.model.Game;
import com.gamelibrary.model.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import  com.gamelibrary.dto.GameDTO;

import java.util.List;
import java.util.function.Function;

@Component
public class GametoGameDtoMapper implements Function<Game,GameDTO> {

    @Override
    public GameDTO apply(Game game) {

        String id = null;
        if (game.getIdGame() != null) {
            id = game.getIdGame().toString();
        }

        final GameDTO gameDTO = GameDTO.builder()
                .idGame(id)
                .imageUrl(game.getImageUrl())
                .gameName(game.getGameName())
                .rating(game.getRating())
                .releaseYear(game.getReleaseYear())
                .build();


        if (!ObjectUtils.isEmpty(game.getGameDlcs())) {
            gameDTO.setDlc(
                    game.getGameDlcs().stream()
                            .map(DLC::getDlcName)
                            .toList()
            );
        }

        if (!ObjectUtils.isEmpty(game.getGameDevelopers())) {
            gameDTO.setDevelopers(

                    game.getGameDevelopers().stream()
                            .map(Developer::getDeveloperName)
                            .toList()
            );
        }

        if (!ObjectUtils.isEmpty(game.getGamePublishers())) {
            gameDTO.setPublishers(
                    game.getGamePublishers().stream()
                            .map(Publisher::getPublisher)
                            .toList()

            );
        }




        return gameDTO;
    }
}
