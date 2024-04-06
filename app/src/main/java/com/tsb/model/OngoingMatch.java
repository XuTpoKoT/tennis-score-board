package com.tsb.model;

import com.tsb.entity.Player;
import lombok.Getter;


@Getter
public class OngoingMatch {

    private Player player1;

    private Player player2;
    private MatchScore score;

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

//    public Integer getWinner() {
//        if (!this.isFinished()) {
//            throw new MatchIsNotFinishedException("Match is not finished!");
//        }
//        switch (score.getWinner()) {
//            PLAYER_1:
//
//        }
//    }
}
