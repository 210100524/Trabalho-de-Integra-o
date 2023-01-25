package com.gamelibrary.service;

import com.gamelibrary.dto.GameDTO;
import com.gamelibrary.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gamelibrary.repository.GameRepository;
import com.gamelibrary.mapper.GametoGameDtoMapper;
import com.gamelibrary.mapper.GameDtoToGameMapper;

import java.util.List;
import java.util.stream.Stream;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GametoGameDtoMapper gametoGameDtoMapper;

    private final GameDtoToGameMapper gameDtoToGameMapper;

    @Autowired
    public GameService(GameRepository gameRepository,
                       GametoGameDtoMapper gametoGameDtoMapper,
                       GameDtoToGameMapper gameDtoToGameMapper) {

        this.gameRepository = gameRepository;
        this.gametoGameDtoMapper = gametoGameDtoMapper;
        this.gameDtoToGameMapper = gameDtoToGameMapper ;

    }

    public List<GameDTO> findGames() {
        return gameRepository.findAll()
                .stream().map(gametoGameDtoMapper)
                .toList();
    }


    public List<GameDTO> searchByName(String gameName) {
        return gameRepository.findByGameNameContainingIgnoreCase(gameName)
                .stream().map(gametoGameDtoMapper)
                .toList();
    }


    public GameDTO insertGame(GameDTO gameDTO) {
        final Game game = gameDtoToGameMapper.apply(gameDTO);

        final Game savedGame = gameRepository.save(game);

        return gametoGameDtoMapper.apply(savedGame);
    }

/*    public  List<GameDTO> findByGenre(String genre) {

       Stream<GameDTO> gameStream = gameRepository.findByGenre(genre).stream()
                .map(gametoGameDtoMapper);

        return Stream.concat(gameStream)
                .toList();
    }*/
}
