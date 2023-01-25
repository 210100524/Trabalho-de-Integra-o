package com.gamelibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "jogo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_Game")
    private UUID idGame;

    @Column(name = "Image", nullable = false)
    private String imageUrl;

    @Column(name = "Game_Name")
    private String gameName;

    @Column(name="Rating")
    private int rating;

    @Column(name = "Release_Year")
    private int releaseYear;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
    private List<DLC> gameDlcs;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
    private List<Developer> gameDevelopers ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
    private List<Genre> gameGenres;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
    private List<Publisher> gamePublishers ;

}