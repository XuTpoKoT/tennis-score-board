package com.tsb.model;

import com.tsb.entity.Player;
import lombok.Getter;

@Getter
public class OngoingMatch {

    private final Player player1;

    private final Player player2;
    private final MatchScore score;

    public OngoingMatch(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.score = new MatchScore();
    }

    public void aceWon(PlayerNumber playerNumber) {
        score.aceWon(playerNumber);
    }

    public boolean isFinished() {
        return score.isWinning();
    }

//    public Player getWinner() {
//        return switch (score.getWinner()) {
//            case PLAYER_1 -> player1;
//            case PLAYER_2 -> player2;
//        };
//    }
}
