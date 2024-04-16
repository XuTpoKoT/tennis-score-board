package com.tsb.model;

import com.tsb.exception.MatchIsNotFinishedException;

import java.util.List;

import static com.tsb.model.PlayerNumber.PLAYER_1;
import static com.tsb.model.PlayerNumber.PLAYER_2;

public class MatchScore extends Score {
    public final static int DEFAULT_SETS_TO_WIN = 2;
    private SetScore curSetScore = new SetScore();

    @Override
    public void aceWon(PlayerNumber playerNumber) {
        curSetScore.aceWon(playerNumber);
        if (curSetScore.isWinning()) {
            addPoint(playerNumber);
            int player1Points = playerPointsMap.get(PLAYER_1);
            int player2Points = playerPointsMap.get(PLAYER_2);
            if (isWinning(player1Points, player2Points)) {
                isWinning = true;
            } else  {
                curSetScore = new SetScore();
            }
        }
    }

    public List<String> getMatchScoreDisplayName() {
        return List.of(playerPointsMap.get(PLAYER_1).toString(), playerPointsMap.get(PLAYER_2).toString());
    }

    public List<String> getSetScoreDisplayName() {
        return curSetScore.getDisplayName();
    }

    public List<String> getGameScoreDisplayName() {
        return curSetScore.getGameScoreDisplayName();
    }
//    public PlayerNumber getWinner() {
//        if (!isWinning) {
//            throw new MatchIsNotFinishedException("Match is not finished!");
//        }
//        if (playerPointsMap.get(PLAYER_1) > playerPointsMap.get(PLAYER_2)) {
//            return PLAYER_1;
//        }
//        return PLAYER_2;
//    }

    @Override
    protected boolean isWinning(int player1Points, int player2Points) {
        return Math.max(player1Points, player2Points) >= DEFAULT_SETS_TO_WIN;
    }
}
