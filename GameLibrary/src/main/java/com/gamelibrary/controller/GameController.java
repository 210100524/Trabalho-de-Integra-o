package com.gamelibrary.controller;

import com.gamelibrary.dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gamelibrary.service.GameService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/game")
public class GameController {


    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> listGames() {
        return ResponseEntity.ok(gameService.findGames());
    }

    @GetMapping("/search")
    public ResponseEntity<List<GameDTO>> search(@RequestParam(required = true) String gameName ) {
        return ResponseEntity.ok(gameService.searchByName(gameName));
    }


    @PostMapping
    public ResponseEntity<GameDTO> addGame(@RequestBody GameDTO gameDTO) {
        return ResponseEntity.ok(
                gameService.insertGame(gameDTO)
        );
    }


/*    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<GameDTO>> findByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(GameService.findByGenre(genre));
    }*/

}
