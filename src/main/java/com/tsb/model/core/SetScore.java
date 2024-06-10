package com.tsb.model.core;

import java.util.List;

import static com.tsb.model.core.PlayerNumber.PLAYER_1;
import static com.tsb.model.core.PlayerNumber.PLAYER_2;

public class SetScore extends Score {
    public final static int DEFAULT_GAMES_TO_WIN = 6;
    public final static int POINTS_TO_WIN_TIME_BREAK_GAME = 7;
    private GameScore curGameScore = new GameScore();
    private boolean isTimebreak = false;

    /*
        Предполагается выигрыш не менее 6-ти геймов с перевесом, по крайней мере, в 2 гейма.
        Если счёт в сете 6-5, то разыгрывается еще один гейм.
        Если счёт становится 7-5, сет заканчивается.
        Если счёт становится 6-6, то разыгрывается тай-брейк.

        Первый, кто наберет 7 очков с разницей в 2 очка, считается выигравшим тай-брейк.
    */
    @Override
    public void aceWon(PlayerNumber playerNumber) {
        curGameScore.aceWon(playerNumber);
        if (curGameScore.isWinning()) {
            addPoint(playerNumber);
            int player1Points = playerPointsMap.get(PlayerNumber.PLAYER_1);
            int player2Points = playerPointsMap.get(PlayerNumber.PLAYER_2);
            if (isWinning(player1Points, player2Points)) {
                isWinning = true;
            } else if (isTimeBreak(player1Points, player2Points)) {
                isTimebreak = true;
                curGameScore = new GameScore(POINTS_TO_WIN_TIME_BREAK_GAME);
            } else {
                curGameScore = new GameScore();
            }
        }
    }

    public List<String> getDisplayName() {
        return List.of(playerPointsMap.get(PLAYER_1).toString(), playerPointsMap.get(PLAYER_2).toString());
    }

    public List<String> getGameScoreDisplayName() {
        return curGameScore.getDisplayName();
    }

    @Override
    protected boolean isWinning(int player1Points, int player2Points) {
        if (isTimebreak) {
            return Math.abs(player1Points - player2Points) >= 1;
        }
        return Math.abs(player1Points - player2Points) >= 2 &&
                Math.max(player1Points, player2Points) >= DEFAULT_GAMES_TO_WIN;

    }

    private boolean isTimeBreak(int player1Points, int player2Points) {
        return player1Points == player2Points && player1Points == DEFAULT_GAMES_TO_WIN;
    }
}
