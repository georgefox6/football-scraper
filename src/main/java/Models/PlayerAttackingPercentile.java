package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player_attacking_percentile")
public class PlayerAttackingPercentile {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerId")
    private Player playerId;

    private int goalsPercentile;
    private int expectedGoalsPercentile;
    private int shotsPercentile;
    private int shotsOnTargetPercentile;
    private int penaltyGoalsPercentile;
    private int freeKickShotsPercentile;

    private int goalsPer90Percentile;
    private int expectedGoalsPer90Percentile;
    private int shotsPer90Percentile;
    private int shotsOnTargetPer90Percentile;
    private int penaltyGoalsPer90Percentile;
    private int freeKickShotsPer90Percentile;

    private int goalsPerPositionPercentile;
    private int expectedGoalsPerPositionPercentile;
    private int shotsPerPositionPercentile;
    private int shotsOnTargetPerPositionPercentile;
    private int penaltyGoalsPerPositionPercentile;
    private int freeKickShotsPerPositionPercentile;

    private int goalsPer90PerPositionPercentile;
    private int expectedGoalsPer90PerPositionPercentile;
    private int shotsPer90PerPositionPercentile;
    private int shotsOnTargetPer90PerPositionPercentile;
    private int penaltyGoalsPer90PerPositionPercentile;
    private int freeKickShotsPer90PerPositionPercentile;

    public PlayerAttackingPercentile(Player player, List<Player> playerList){
        this.playerId = player;

        long totalPlayers = playerList.size();
        long totalPlayersPerPosition = playerList.stream().filter(pl -> pl.getPlayerPosition().equals(player.getPlayerPosition())).count();

        //Goals
        long playersWithLessGoals = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getGoals() < player.getGoals()).count();
        this.goalsPercentile = calculatePercentile((double) playersWithLessGoals, (double) totalPlayers);

        long playersWithLessGoalsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getGoals() < player.getGoals() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.goalsPerPositionPercentile = calculatePercentile((double) playersWithLessGoalsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessGoalsPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getGoals()/(double)pl.getMinutesPlayed()) < ((double)player.getGoals()/(double)player.getMinutesPlayed())).count();
            this.goalsPer90Percentile = calculatePercentile((double) playersWithLessGoalsPer90, (double) totalPlayers);

            long playersWithLessGoalsPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getGoals()/(double)pl.getMinutesPlayed()) < ((double)player.getGoals()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.goalsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessGoalsPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.goalsPer90Percentile = 0;
            this.goalsPer90PerPositionPercentile = 0;
        }



        //Expected goals
        long playersWithLessExpectedGoals = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getExpectedGoals() < player.getExpectedGoals()).count();
        this.expectedGoalsPercentile = calculatePercentile((double) playersWithLessExpectedGoals, (double) totalPlayers);

        long playersWithLessExpectedGoalsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getExpectedGoals() < player.getExpectedGoals() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.expectedGoalsPerPositionPercentile = calculatePercentile((double) playersWithLessExpectedGoalsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0) {
            long playersWithLessExpectedGoalsPer90 = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getExpectedGoals() / (double)pl.getMinutesPlayed()) < ((double)player.getExpectedGoals() / (double)player.getMinutesPlayed())).count();
            this.expectedGoalsPer90Percentile = calculatePercentile((double) playersWithLessExpectedGoalsPer90, (double) totalPlayers);

            long playersWithLessExpectedGoalsPer90PerPosition = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getExpectedGoals() / (double)pl.getMinutesPlayed()) < ((double)player.getExpectedGoals() / (double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.expectedGoalsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessExpectedGoalsPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.expectedGoalsPer90Percentile = 0;
            this.expectedGoalsPer90PerPositionPercentile = 0;
        }

        //Shots
        long playersWithLessShots = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getShots() < player.getShots()).count();
        this.shotsPercentile = calculatePercentile((double) playersWithLessShots, (double) totalPlayers);

        long playersWithLessShotsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getShots() < player.getShots() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.shotsPerPositionPercentile = calculatePercentile((double) playersWithLessShotsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0) {
            long playersWithLessShotsPer90 = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getShots() / (double)pl.getMinutesPlayed()) < ((double)player.getShots() / (double)player.getMinutesPlayed())).count();
            this.shotsPer90Percentile = calculatePercentile((double) playersWithLessShotsPer90, (double) totalPlayers);

            long playersWithLessShotsPer90PerPosition = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getShots() / (double)pl.getMinutesPlayed()) < ((double)player.getShots() / (double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.shotsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessShotsPer90PerPosition, (double) totalPlayersPerPosition);

        } else {
            this.shotsPer90Percentile = 0;
            this.shotsPer90PerPositionPercentile = 0;
        }

        //ShotsOnTarget
        long playersWithLessShotsOnTarget = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getShotsOnTarget() < player.getShotsOnTarget()).count();
        this.shotsOnTargetPercentile = calculatePercentile((double) playersWithLessShotsOnTarget, (double) totalPlayers);

        long playersWithLessShotsOnTargetPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getShotsOnTarget() < player.getShotsOnTarget() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.shotsOnTargetPerPositionPercentile = calculatePercentile((double) playersWithLessShotsOnTargetPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0) {
            long playersWithLessShotsOnTargetPer90 = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getShotsOnTarget() / (double)pl.getMinutesPlayed()) < ((double)player.getShotsOnTarget() / (double)player.getMinutesPlayed())).count();
            this.shotsOnTargetPer90Percentile = calculatePercentile((double) playersWithLessShotsOnTargetPer90, (double) totalPlayers);

            long playersWithLessShotsOnTargetPer90PerPosition = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getShotsOnTarget() / (double)pl.getMinutesPlayed()) < ((double)player.getShotsOnTarget() / (double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.shotsOnTargetPer90PerPositionPercentile = calculatePercentile((double) playersWithLessShotsOnTargetPer90PerPosition, (double) totalPlayersPerPosition);

        } else {
            this.shotsOnTargetPer90Percentile = 0;
            this.shotsOnTargetPer90PerPositionPercentile = 0;
        }

        //PenaltyGoals
        long playersWithLessPenaltyGoals = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getPenaltyScored() < player.getPenaltyScored()).count();
        this.penaltyGoalsPercentile = calculatePercentile((double) playersWithLessPenaltyGoals, (double) totalPlayers);

        long playersWithLessPenaltyGoalsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getPenaltyScored() < player.getPenaltyScored() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.penaltyGoalsPerPositionPercentile = calculatePercentile((double) playersWithLessPenaltyGoalsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0) {
            long playersWithLessPenaltyGoalsPer90 = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getPenaltyScored() / (double)pl.getMinutesPlayed()) < ((double)player.getPenaltyScored() / (double)player.getMinutesPlayed())).count();
            this.penaltyGoalsPer90Percentile = calculatePercentile((double) playersWithLessPenaltyGoalsPer90, (double) totalPlayers);

            long playersWithLessPenaltyGoalsPer90PerPosition = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getPenaltyScored() / (double)pl.getMinutesPlayed()) < ((double)player.getPenaltyScored() / (double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.penaltyGoalsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessPenaltyGoalsPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.penaltyGoalsPer90Percentile = 0;
            this.penaltyGoalsPer90PerPositionPercentile = 0;
        }

        //FreeKickShots
        long playersWithLessFreeKickShots = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getFreeKickShots() < player.getFreeKickShots()).count();
        this.freeKickShotsPercentile = calculatePercentile((double) playersWithLessFreeKickShots, (double) totalPlayers);

        long playersWithLessFreeKickShotsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getFreeKickShots() < player.getFreeKickShots() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.freeKickShotsPerPositionPercentile = calculatePercentile((double) playersWithLessFreeKickShotsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0) {
            long playersWithLessFreeKickShotsPer90 = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getFreeKickShots() / (double)pl.getMinutesPlayed()) < ((double)player.getFreeKickShots() / (double)player.getMinutesPlayed())).count();
            this.freeKickShotsPer90Percentile = calculatePercentile((double) playersWithLessFreeKickShotsPer90, (double) totalPlayers);

            long playersWithLessFreeKickShotsPer90PerPosition = playerList.stream().filter(pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getFreeKickShots() / (double)pl.getMinutesPlayed()) < ((double)player.getFreeKickShots() / (double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.freeKickShotsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessFreeKickShotsPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.freeKickShotsPer90Percentile = 0;
            this.freeKickShotsPer90PerPositionPercentile = 0;
        }
    }

    private int calculatePercentile(double playersWithLessGoals, double totalPlayers) {
        return (int) Math.floor((playersWithLessGoals / totalPlayers) * 100);
    }

    public PlayerAttackingPercentile(Player playerId, int goalsPercentile, int expectedGoalsPercentile, int shotsPercentile, int shotsOnTargetPercentile, int penaltyGoalsPercentile, int freeKickShotsPercentile, int goalsPer90Percentile, int expectedGoalsPer90Percentile, int shotsPer90Percentile, int shotsOnTargetPer90Percentile, int penaltyGoalsPer90Percentile, int freeKickShotsPer90Percentile, int goalsPerPositionPercentile, int expectedGoalsPerPositionPercentile, int shotsPerPositionPercentile, int shotsOnTargetPerPositionPercentile, int penaltyGoalsPerPositionPercentile, int freeKickShotsPerPositionPercentile, int goalsPer90PerPositionPercentile, int expectedGoalsPer90PerPositionPercentile, int shotsPer90PerPositionPercentile, int shotsOnTargetPer90PerPositionPercentile, int penaltyGoalsPer90PerPositionPercentile, int freeKickShotsPer90PerPositionPercentile) {
        this.playerId = playerId;
        this.goalsPercentile = goalsPercentile;
        this.expectedGoalsPercentile = expectedGoalsPercentile;
        this.shotsPercentile = shotsPercentile;
        this.shotsOnTargetPercentile = shotsOnTargetPercentile;
        this.penaltyGoalsPercentile = penaltyGoalsPercentile;
        this.freeKickShotsPercentile = freeKickShotsPercentile;
        this.goalsPer90Percentile = goalsPer90Percentile;
        this.expectedGoalsPer90Percentile = expectedGoalsPer90Percentile;
        this.shotsPer90Percentile = shotsPer90Percentile;
        this.shotsOnTargetPer90Percentile = shotsOnTargetPer90Percentile;
        this.penaltyGoalsPer90Percentile = penaltyGoalsPer90Percentile;
        this.freeKickShotsPer90Percentile = freeKickShotsPer90Percentile;
        this.goalsPerPositionPercentile = goalsPerPositionPercentile;
        this.expectedGoalsPerPositionPercentile = expectedGoalsPerPositionPercentile;
        this.shotsPerPositionPercentile = shotsPerPositionPercentile;
        this.shotsOnTargetPerPositionPercentile = shotsOnTargetPerPositionPercentile;
        this.penaltyGoalsPerPositionPercentile = penaltyGoalsPerPositionPercentile;
        this.freeKickShotsPerPositionPercentile = freeKickShotsPerPositionPercentile;
        this.goalsPer90PerPositionPercentile = goalsPer90PerPositionPercentile;
        this.expectedGoalsPer90PerPositionPercentile = expectedGoalsPer90PerPositionPercentile;
        this.shotsPer90PerPositionPercentile = shotsPer90PerPositionPercentile;
        this.shotsOnTargetPer90PerPositionPercentile = shotsOnTargetPer90PerPositionPercentile;
        this.penaltyGoalsPer90PerPositionPercentile = penaltyGoalsPer90PerPositionPercentile;
        this.freeKickShotsPer90PerPositionPercentile = freeKickShotsPer90PerPositionPercentile;
    }

    public PlayerAttackingPercentile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public int getGoalsPercentile() {
        return goalsPercentile;
    }

    public void setGoalsPercentile(int goalsPercentile) {
        this.goalsPercentile = goalsPercentile;
    }

    public int getExpectedGoalsPercentile() {
        return expectedGoalsPercentile;
    }

    public void setExpectedGoalsPercentile(int expectedGoalsPercentile) {
        this.expectedGoalsPercentile = expectedGoalsPercentile;
    }

    public int getShotsPercentile() {
        return shotsPercentile;
    }

    public void setShotsPercentile(int shotsPercentile) {
        this.shotsPercentile = shotsPercentile;
    }

    public int getShotsOnTargetPercentile() {
        return shotsOnTargetPercentile;
    }

    public void setShotsOnTargetPercentile(int shotsOnTargetPercentile) {
        this.shotsOnTargetPercentile = shotsOnTargetPercentile;
    }

    public int getPenaltyGoalsPercentile() {
        return penaltyGoalsPercentile;
    }

    public void setPenaltyGoalsPercentile(int penaltyGoalsPercentile) {
        this.penaltyGoalsPercentile = penaltyGoalsPercentile;
    }

    public int getFreeKickShotsPercentile() {
        return freeKickShotsPercentile;
    }

    public void setFreeKickShotsPercentile(int freeKickShotsPercentile) {
        this.freeKickShotsPercentile = freeKickShotsPercentile;
    }

    public int getGoalsPer90Percentile() {
        return goalsPer90Percentile;
    }

    public void setGoalsPer90Percentile(int goalsPer90Percentile) {
        this.goalsPer90Percentile = goalsPer90Percentile;
    }

    public int getExpectedGoalsPer90Percentile() {
        return expectedGoalsPer90Percentile;
    }

    public void setExpectedGoalsPer90Percentile(int expectedGoalsPer90Percentile) {
        this.expectedGoalsPer90Percentile = expectedGoalsPer90Percentile;
    }

    public int getShotsPer90Percentile() {
        return shotsPer90Percentile;
    }

    public void setShotsPer90Percentile(int shotsPer90Percentile) {
        this.shotsPer90Percentile = shotsPer90Percentile;
    }

    public int getShotsOnTargetPer90Percentile() {
        return shotsOnTargetPer90Percentile;
    }

    public void setShotsOnTargetPer90Percentile(int shotsOnTargetPer90Percentile) {
        this.shotsOnTargetPer90Percentile = shotsOnTargetPer90Percentile;
    }

    public int getPenaltyGoalsPer90Percentile() {
        return penaltyGoalsPer90Percentile;
    }

    public void setPenaltyGoalsPer90Percentile(int penaltyGoalsPer90Percentile) {
        this.penaltyGoalsPer90Percentile = penaltyGoalsPer90Percentile;
    }

    public int getFreeKickShotsPer90Percentile() {
        return freeKickShotsPer90Percentile;
    }

    public void setFreeKickShotsPer90Percentile(int freeKickShotsPer90Percentile) {
        this.freeKickShotsPer90Percentile = freeKickShotsPer90Percentile;
    }

    public int getGoalsPerPositionPercentile() {
        return goalsPerPositionPercentile;
    }

    public void setGoalsPerPositionPercentile(int goalsPerPositionPercentile) {
        this.goalsPerPositionPercentile = goalsPerPositionPercentile;
    }

    public int getExpectedGoalsPerPositionPercentile() {
        return expectedGoalsPerPositionPercentile;
    }

    public void setExpectedGoalsPerPositionPercentile(int expectedGoalsPerPositionPercentile) {
        this.expectedGoalsPerPositionPercentile = expectedGoalsPerPositionPercentile;
    }

    public int getShotsPerPositionPercentile() {
        return shotsPerPositionPercentile;
    }

    public void setShotsPerPositionPercentile(int shotsPerPositionPercentile) {
        this.shotsPerPositionPercentile = shotsPerPositionPercentile;
    }

    public int getShotsOnTargetPerPositionPercentile() {
        return shotsOnTargetPerPositionPercentile;
    }

    public void setShotsOnTargetPerPositionPercentile(int shotsOnTargetPerPositionPercentile) {
        this.shotsOnTargetPerPositionPercentile = shotsOnTargetPerPositionPercentile;
    }

    public int getPenaltyGoalsPerPositionPercentile() {
        return penaltyGoalsPerPositionPercentile;
    }

    public void setPenaltyGoalsPerPositionPercentile(int penaltyGoalsPerPositionPercentile) {
        this.penaltyGoalsPerPositionPercentile = penaltyGoalsPerPositionPercentile;
    }

    public int getFreeKickShotsPerPositionPercentile() {
        return freeKickShotsPerPositionPercentile;
    }

    public void setFreeKickShotsPerPositionPercentile(int freeKickShotsPerPositionPercentile) {
        this.freeKickShotsPerPositionPercentile = freeKickShotsPerPositionPercentile;
    }

    public int getGoalsPer90PerPositionPercentile() {
        return goalsPer90PerPositionPercentile;
    }

    public void setGoalsPer90PerPositionPercentile(int goalsPer90PerPositionPercentile) {
        this.goalsPer90PerPositionPercentile = goalsPer90PerPositionPercentile;
    }

    public int getExpectedGoalsPer90PerPositionPercentile() {
        return expectedGoalsPer90PerPositionPercentile;
    }

    public void setExpectedGoalsPer90PerPositionPercentile(int expectedGoalsPer90PerPositionPercentile) {
        this.expectedGoalsPer90PerPositionPercentile = expectedGoalsPer90PerPositionPercentile;
    }

    public int getShotsPer90PerPositionPercentile() {
        return shotsPer90PerPositionPercentile;
    }

    public void setShotsPer90PerPositionPercentile(int shotsPer90PerPositionPercentile) {
        this.shotsPer90PerPositionPercentile = shotsPer90PerPositionPercentile;
    }

    public int getShotsOnTargetPer90PerPositionPercentile() {
        return shotsOnTargetPer90PerPositionPercentile;
    }

    public void setShotsOnTargetPer90PerPositionPercentile(int shotsOnTargetPer90PerPositionPercentile) {
        this.shotsOnTargetPer90PerPositionPercentile = shotsOnTargetPer90PerPositionPercentile;
    }

    public int getPenaltyGoalsPer90PerPositionPercentile() {
        return penaltyGoalsPer90PerPositionPercentile;
    }

    public void setPenaltyGoalsPer90PerPositionPercentile(int penaltyGoalsPer90PerPositionPercentile) {
        this.penaltyGoalsPer90PerPositionPercentile = penaltyGoalsPer90PerPositionPercentile;
    }

    public int getFreeKickShotsPer90PerPositionPercentile() {
        return freeKickShotsPer90PerPositionPercentile;
    }

    public void setFreeKickShotsPer90PerPositionPercentile(int freeKickShotsPer90PerPositionPercentile) {
        this.freeKickShotsPer90PerPositionPercentile = freeKickShotsPer90PerPositionPercentile;
    }
}