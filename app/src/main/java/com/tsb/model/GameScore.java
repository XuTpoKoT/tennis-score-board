package com.tsb.model;

import com.tsb.exception.MatchIntervalIsFinishedException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.tsb.model.PlayerNumber.PLAYER_1;
import static com.tsb.model.PlayerNumber.PLAYER_2;

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

    public List<String> getDisplayName() {
        Integer player1Points = playerPointsMap.get(PLAYER_1);
        Integer player2Points = playerPointsMap.get(PLAYER_2);
        if (pointsToWin != DEFAULT_POINTS_TO_WIN) {
            return List.of(player1Points.toString(), player2Points.toString());
        }
        if (player1Points >= 3 && player2Points >= 3) {
            String player1PointsDisplayName = "40";
            String player2PointsDisplayName = "40";
            if (player1Points > player2Points) {
                player1PointsDisplayName = "ADV";
            } else if (player2Points > player1Points) {
                player2PointsDisplayName = "ADV";
            }
            return List.of(player1PointsDisplayName, player2PointsDisplayName);
        }
        return List.of(getStandardDisplayNameByPoints(player1Points), getStandardDisplayNameByPoints(player2Points));
    }

    private String getStandardDisplayNameByPoints(int points) {
        if (points == 0) {
            return "0";
        } else if (points == 1) {
            return "15";
        } else if (points == 2) {
            return "30";
        }
        return "40";
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
