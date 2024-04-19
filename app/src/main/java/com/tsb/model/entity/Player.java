package com.tsb.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "Player", schema = "public")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    public Player(String name) {
        this.name = name;
    }

    @Getter
    private String name;
}
