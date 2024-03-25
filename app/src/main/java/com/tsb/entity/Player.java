package com.tsb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
public class Player {
    @Id
    @Getter
    private String name;

    public Player(String name) {
        this.name = name;
    }
}
