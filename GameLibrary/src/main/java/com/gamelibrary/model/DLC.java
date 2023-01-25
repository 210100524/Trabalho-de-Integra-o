package com.gamelibrary.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "dlc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DLC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DlC")
    private Integer idDLC;

    @Column(name = "DLC_Name")
    private String dlcName;

    @ManyToOne
    private Game game;

}
