package com.gamelibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Publisher")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_Publisher")
    private Integer idPublisher;

    @Column(name = "Publisher_Name")
        private String publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;
}

