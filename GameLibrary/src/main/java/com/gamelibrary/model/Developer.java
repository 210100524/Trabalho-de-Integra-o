package com.gamelibrary.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "developer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_Developer")
    private Integer idDeveloper;

    @Column(name = "Developer_Name")
    private String developerName;

    @ManyToOne (fetch = FetchType.LAZY)
    private Game game;


}
