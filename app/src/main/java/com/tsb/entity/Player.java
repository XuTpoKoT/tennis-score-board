package com.tsb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
public class Player {
    @Id @GeneratedValue(strategy=IDENTITY)
    @Getter
    @Setter
    private Long id;

    public Player(Long id) {
        this.id = id;
    }
}
