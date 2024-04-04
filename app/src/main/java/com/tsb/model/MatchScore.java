package com.tsb.model;

public class MatchScore extends Score {
    public final static int DEFAULT_SETS_TO_WIN = 2;
    private SetScore curSetScore = new SetScore();

    @Override
    public void aceWon(PlayerNumber playerNumber) {
        curSetScore.aceWon(playerNumber);
        if (curSetScore.isWinning()) {
            addPoint(playerNumber);
            int player1Points = playerPointsMap.get(PlayerNumber.PLAYER_1);
            int player2Points = playerPointsMap.get(PlayerNumber.PLAYER_2);
            if (isWinning(player1Points, player2Points)) {
                isWinning = true;
            } else  {
                curSetScore = new SetScore();
            }
        }
    }

    @Override
    protected boolean isWinning(int player1Points, int player2Points) {
        return Math.max(player1Points, player2Points) >= DEFAULT_SETS_TO_WIN;
    }
}
