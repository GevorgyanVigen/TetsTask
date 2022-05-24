package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clan")
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clan_name")
    private String name;
    @Column(name = "gold")
    private int gold;

}
