package com.tsb.model;

import com.tsb.exception.MatchIntervalIsFinishedException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GameScore extends Score {
    public final static int DEFAULT_POINTS_TO_WIN = 4;
    private int pointsToWin = DEFAULT_POINTS_TO_WIN;
    @Override
    public void aceWon(PlayerNumber playerNumber) {
        if (this.isWinning()) {
            throw new MatchIntervalIsFinishedException("Match interval is finished!");
        }
        addPoint(playerNumber);
        updateScoreStatus();
    }

    @Override
    protected boolean isWinning(int player1Points, int player2Points) {
        return Math.abs(player1Points - player2Points) >= 2 &&
                Math.max(player1Points, player2Points) >= pointsToWin;
    }

    private void updateScoreStatus() {
        int player1Points = playerPointsMap.get(PlayerNumber.PLAYER_1);
        int player2Points = playerPointsMap.get(PlayerNumber.PLAYER_2);
        if (isWinning(player1Points, player2Points)) {
            isWinning = true;
        }
    }


}
