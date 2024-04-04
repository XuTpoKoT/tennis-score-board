package com.tsb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Player {
    @Id @GeneratedValue
    @Getter
    private Integer id;

    public Player(String name) {
        this.name = name;
    }

    @Getter
    private String name;
}
