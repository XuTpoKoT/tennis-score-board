package com.tsb.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Score {
    protected Map<PlayerNumber, Integer> playerPointsMap;
    public Score() {
        playerPointsMap = new HashMap<>();
        playerPointsMap.put(PlayerNumber.PLAYER_1, 0);
        playerPointsMap.put(PlayerNumber.PLAYER_2, 0);
    }
    protected boolean isWinning;

    public boolean isWinning() {
        return isWinning;
    }

    public abstract void aceWon(PlayerNumber playerNumber);

    protected void addPoint(PlayerNumber playerNumber) {
        Integer points = playerPointsMap.get(playerNumber);
        playerPointsMap.put(playerNumber, points + 1);
    }

    protected abstract boolean isWinning(int player1Points, int player2Points);
}
