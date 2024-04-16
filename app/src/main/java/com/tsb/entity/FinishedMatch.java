package com.tsb.entity;

import com.tsb.model.OngoingMatch;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class FinishedMatch {
    @Id
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "player_1", nullable = false)
    private Player player1;

    @ManyToOne()
    @JoinColumn(name = "player_2", nullable = false)
    private Player player2;

    @ManyToOne()
    @JoinColumn(name = "winner", nullable = false)
    private Player winner;

    public FinishedMatch(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

//    public static FinishedMatch fromOngoingMatch(OngoingMatch ongoingMatch) {
//        return new FinishedMatch(ongoingMatch.getPlayer1(), ongoingMatch.getPlayer2(), ongoingMatch.getWinner());
//    }
}
