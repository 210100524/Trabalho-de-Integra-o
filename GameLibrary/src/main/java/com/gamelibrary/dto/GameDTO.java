package com.gamelibrary.dto;


import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class GameDTO {
        private String idGame;
        private String imageUrl;
        private String gameName;
        private int rating;
        private int releaseYear;
        private List<String> dlc;
        private List<String> developers;
        private List<String> publishers;
        private List <String> genres;
}
