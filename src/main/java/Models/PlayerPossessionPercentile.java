package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player_possession_percentile")
public class PlayerPossessionPercentile {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerId")
    private Player playerId;

    private int passesCompletedPercentile;
    private int progressivePassingDistancePercentile;
    private int crossesPercentile;
    private int dribblesPercentile;
    private int progressiveDribbleDistancePercentile;
    private int passesControlledPercentile;
    private int assistsPercentile;
    private int expectedAssistsPercentile;

    private int passesCompletedPer90Percentile;
    private int progressivePassingDistancePer90Percentile;
    private int crossesPer90Percentile;
    private int dribblesPer90Percentile;
    private int progressiveDribbleDistancePer90Percentile;
    private int passesControlledPer90Percentile;
    private int assistsPer90Percentile;
    private int expectedAssistsPer90Percentile;

    private int passesCompletedPerPositionPercentile;
    private int progressivePassingDistancePerPositionPercentile;
    private int crossesPerPositionPercentile;
    private int dribblesPerPositionPercentile;
    private int progressiveDribbleDistancePerPositionPercentile;
    private int passesControlledPerPositionPercentile;
    private int assistsPerPositionPercentile;
    private int expectedAssistsPerPositionPercentile;

    private int passesCompletedPer90PerPositionPercentile;
    private int progressivePassingDistancePer90PerPositionPercentile;
    private int crossesPer90PerPositionPercentile;
    private int dribblesPer90PerPositionPercentile;
    private int progressiveDribbleDistancePer90PerPositionPercentile;
    private int passesControlledPer90PerPositionPercentile;
    private int assistsPer90PerPositionPercentile;
    private int expectedAssistsPer90PerPositionPercentile;

    public PlayerPossessionPercentile(){

    }

    public PlayerPossessionPercentile(Player player, List<Player> playerList){
        this.playerId = player;

        long totalPlayers = playerList.size();
        long totalPlayersPerPosition = playerList.stream().filter(pl -> pl.getPlayerPosition().equals(player.getPlayerPosition())).count();


        //PassesCompleted
        long playersWithLessPassesCompleted = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getTotalPassesCompleted() <= player.getTotalPassesCompleted()).count();
        this.passesCompletedPercentile = calculatePercentile((double) playersWithLessPassesCompleted, (double) totalPlayers);

        long playersWithLessPassesCompletedPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getTotalPassesCompleted() <= player.getTotalPassesCompleted() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.passesCompletedPerPositionPercentile = calculatePercentile((double) playersWithLessPassesCompletedPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessPassesCompletedPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getTotalPassesCompleted()/(double)pl.getMinutesPlayed()) <= ((double)player.getTotalPassesCompleted()/(double)player.getMinutesPlayed())).count();
            this.passesCompletedPer90Percentile = calculatePercentile((double) playersWithLessPassesCompletedPer90, (double) totalPlayers);

            long playersWithLessPassesCompletedPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getTotalPassesCompleted()/(double)pl.getMinutesPlayed()) <= ((double)player.getTotalPassesCompleted()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.passesCompletedPer90PerPositionPercentile = calculatePercentile((double) playersWithLessPassesCompletedPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.passesCompletedPer90Percentile = 0;
            this.passesCompletedPer90PerPositionPercentile = 0;
        }


        //ProgressivePassingDistance
        long playersWithLessProgressivePassingDistance = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getProgressivePassingDistance() <= player.getProgressivePassingDistance()).count();
        this.progressivePassingDistancePercentile = calculatePercentile((double) playersWithLessProgressivePassingDistance, (double) totalPlayers);

        long playersWithLessProgressivePassingDistancePerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getProgressivePassingDistance() <= player.getProgressivePassingDistance() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.progressivePassingDistancePerPositionPercentile = calculatePercentile((double) playersWithLessProgressivePassingDistancePerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessProgressivePassingDistancePer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getProgressivePassingDistance()/(double)pl.getMinutesPlayed()) <= ((double)player.getProgressivePassingDistance()/(double)player.getMinutesPlayed())).count();
            this.progressivePassingDistancePer90Percentile = calculatePercentile((double) playersWithLessProgressivePassingDistancePer90, (double) totalPlayers);

            long playersWithLessProgressivePassingDistancePer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getProgressivePassingDistance()/(double)pl.getMinutesPlayed()) <= ((double)player.getProgressivePassingDistance()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.progressivePassingDistancePer90PerPositionPercentile = calculatePercentile((double) playersWithLessProgressivePassingDistancePer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.progressivePassingDistancePer90Percentile = 0;
            this.progressivePassingDistancePer90PerPositionPercentile = 0;
        }


        //Crosses
        long playersWithLessCrosses = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getCrosses() <= player.getCrosses()).count();
        this.crossesPercentile = calculatePercentile((double) playersWithLessCrosses, (double) totalPlayers);

        long playersWithLessCrossesPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getCrosses() <= player.getCrosses() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.crossesPerPositionPercentile = calculatePercentile((double) playersWithLessCrossesPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessCrossesPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getCrosses()/(double)pl.getMinutesPlayed()) <= ((double)player.getCrosses()/(double)player.getMinutesPlayed())).count();
            this.crossesPer90Percentile = calculatePercentile((double) playersWithLessCrossesPer90, (double) totalPlayers);

            long playersWithLessCrossesPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getCrosses()/(double)pl.getMinutesPlayed()) <= ((double)player.getCrosses()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.crossesPer90PerPositionPercentile = calculatePercentile((double) playersWithLessCrossesPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.crossesPer90Percentile = 0;
            this.crossesPer90PerPositionPercentile = 0;
        }


        //Dribbles
        long playersWithLessDribbles = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getDribblesCompleted() <= player.getDribblesCompleted()).count();
        this.dribblesPercentile = calculatePercentile((double) playersWithLessDribbles, (double) totalPlayers);

        long playersWithLessDribblesPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getDribblesCompleted() <= player.getDribblesCompleted() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.dribblesPerPositionPercentile = calculatePercentile((double) playersWithLessDribblesPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessDribblesPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getDribblesCompleted()/(double)pl.getMinutesPlayed()) <= ((double)player.getDribblesCompleted()/(double)player.getMinutesPlayed())).count();
            this.dribblesPer90Percentile = calculatePercentile((double) playersWithLessDribblesPer90, (double) totalPlayers);

            long playersWithLessDribblesPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getDribblesCompleted()/(double)pl.getMinutesPlayed()) <= ((double)player.getDribblesCompleted()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.dribblesPer90PerPositionPercentile = calculatePercentile((double) playersWithLessDribblesPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.dribblesPer90Percentile = 0;
            this.dribblesPer90PerPositionPercentile = 0;
        }


        //ProgressiveDribbleDistance
        long playersWithLessProgressiveDribbleDistance = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getDribblesProgressiveDistance() <= player.getDribblesProgressiveDistance()).count();
        this.progressiveDribbleDistancePercentile = calculatePercentile((double) playersWithLessProgressiveDribbleDistance, (double) totalPlayers);

        long playersWithLessProgressiveDribbleDistancePerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getDribblesProgressiveDistance() <= player.getDribblesProgressiveDistance() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.progressiveDribbleDistancePerPositionPercentile = calculatePercentile((double) playersWithLessProgressiveDribbleDistancePerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessProgressiveDribbleDistancePer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getDribblesProgressiveDistance()/(double)pl.getMinutesPlayed()) <= ((double)player.getDribblesProgressiveDistance()/(double)player.getMinutesPlayed())).count();
            this.progressiveDribbleDistancePer90Percentile = calculatePercentile((double) playersWithLessProgressiveDribbleDistancePer90, (double) totalPlayers);

            long playersWithLessProgressiveDribbleDistancePer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getDribblesProgressiveDistance()/(double)pl.getMinutesPlayed()) <= ((double)player.getDribblesProgressiveDistance()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.progressiveDribbleDistancePer90PerPositionPercentile = calculatePercentile((double) playersWithLessProgressiveDribbleDistancePer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.progressiveDribbleDistancePer90Percentile = 0;
            this.progressiveDribbleDistancePer90PerPositionPercentile = 0;
        }


        //PassesControlled
        long playersWithLessPassesControlled = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getPassesControlled() <= player.getPassesControlled()).count();
        this.passesControlledPercentile = calculatePercentile((double) playersWithLessPassesControlled, (double) totalPlayers);

        long playersWithLessPassesControlledPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getPassesControlled() <= player.getPassesControlled() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.passesControlledPerPositionPercentile = calculatePercentile((double) playersWithLessPassesControlledPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessPassesControlledPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getPassesControlled()/(double)pl.getMinutesPlayed()) <= ((double)player.getPassesControlled()/(double)player.getMinutesPlayed())).count();
            this.passesControlledPer90Percentile = calculatePercentile((double) playersWithLessPassesControlledPer90, (double) totalPlayers);

            long playersWithLessPassesControlledPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getPassesControlled()/(double)pl.getMinutesPlayed()) <= ((double)player.getPassesControlled()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.passesControlledPer90PerPositionPercentile = calculatePercentile((double) playersWithLessPassesControlledPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.passesControlledPer90Percentile = 0;
            this.passesControlledPer90PerPositionPercentile = 0;
        }


        //Assists
        long playersWithLessAssists = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getAssists() <= player.getAssists()).count();
        this.assistsPercentile = calculatePercentile((double) playersWithLessAssists, (double) totalPlayers);

        long playersWithLessAssistsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getAssists() <= player.getAssists() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.assistsPerPositionPercentile = calculatePercentile((double) playersWithLessAssistsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessAssistsPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getAssists()/(double)pl.getMinutesPlayed()) <= ((double)player.getAssists()/(double)player.getMinutesPlayed())).count();
            this.assistsPer90Percentile = calculatePercentile((double) playersWithLessAssistsPer90, (double) totalPlayers);

            long playersWithLessAssistsPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getAssists()/(double)pl.getMinutesPlayed()) <= ((double)player.getAssists()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.assistsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessAssistsPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.assistsPer90Percentile = 0;
            this.assistsPer90PerPositionPercentile = 0;
        }


        //ExpectedAssists
        long playersWithLessExpectedAssists = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getExpectedAssists() <= player.getExpectedAssists()).count();
        this.expectedAssistsPercentile = calculatePercentile((double) playersWithLessExpectedAssists, (double) totalPlayers);

        long playersWithLessExpectedAssistsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getExpectedAssists() <= player.getExpectedAssists() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.expectedAssistsPerPositionPercentile = calculatePercentile((double) playersWithLessExpectedAssistsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessExpectedAssistsPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getExpectedAssists()/(double)pl.getMinutesPlayed()) <= ((double)player.getExpectedAssists()/(double)player.getMinutesPlayed())).count();
            this.expectedAssistsPer90Percentile = calculatePercentile((double) playersWithLessExpectedAssistsPer90, (double) totalPlayers);

            long playersWithLessExpectedAssistsPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getExpectedAssists()/(double)pl.getMinutesPlayed()) <= ((double)player.getExpectedAssists()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.expectedAssistsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessExpectedAssistsPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.expectedAssistsPer90Percentile = 0;
            this.expectedAssistsPer90PerPositionPercentile = 0;
        }
    }

    private int calculatePercentile(double playersWithLessGoals, double totalPlayers) {
        return (int) Math.floor((playersWithLessGoals / totalPlayers) * 100);
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

    public int getPassesCompletedPercentile() {
        return passesCompletedPercentile;
    }

    public void setPassesCompletedPercentile(int passesCompletedPercentile) {
        this.passesCompletedPercentile = passesCompletedPercentile;
    }

    public int getProgressivePassingDistancePercentile() {
        return progressivePassingDistancePercentile;
    }

    public void setProgressivePassingDistancePercentile(int progressivePassingDistancePercentile) {
        this.progressivePassingDistancePercentile = progressivePassingDistancePercentile;
    }

    public int getCrossesPercentile() {
        return crossesPercentile;
    }

    public void setCrossesPercentile(int crossesPercentile) {
        this.crossesPercentile = crossesPercentile;
    }

    public int getDribblesPercentile() {
        return dribblesPercentile;
    }

    public void setDribblesPercentile(int dribblesPercentile) {
        this.dribblesPercentile = dribblesPercentile;
    }

    public int getProgressiveDribbleDistancePercentile() {
        return progressiveDribbleDistancePercentile;
    }

    public void setProgressiveDribbleDistancePercentile(int progressiveDribbleDistancePercentile) {
        this.progressiveDribbleDistancePercentile = progressiveDribbleDistancePercentile;
    }

    public int getPassesControlledPercentile() {
        return passesControlledPercentile;
    }

    public void setPassesControlledPercentile(int passesControlledPercentile) {
        this.passesControlledPercentile = passesControlledPercentile;
    }

    public int getAssistsPercentile() {
        return assistsPercentile;
    }

    public void setAssistsPercentile(int assistsPercentile) {
        this.assistsPercentile = assistsPercentile;
    }

    public int getExpectedAssistsPercentile() {
        return expectedAssistsPercentile;
    }

    public void setExpectedAssistsPercentile(int expectedAssistsPercentile) {
        this.expectedAssistsPercentile = expectedAssistsPercentile;
    }

    public int getPassesCompletedPer90Percentile() {
        return passesCompletedPer90Percentile;
    }

    public void setPassesCompletedPer90Percentile(int passesCompletedPer90Percentile) {
        this.passesCompletedPer90Percentile = passesCompletedPer90Percentile;
    }

    public int getProgressivePassingDistancePer90Percentile() {
        return progressivePassingDistancePer90Percentile;
    }

    public void setProgressivePassingDistancePer90Percentile(int progressivePassingDistancePer90Percentile) {
        this.progressivePassingDistancePer90Percentile = progressivePassingDistancePer90Percentile;
    }

    public int getCrossesPer90Percentile() {
        return crossesPer90Percentile;
    }

    public void setCrossesPer90Percentile(int crossesPer90Percentile) {
        this.crossesPer90Percentile = crossesPer90Percentile;
    }

    public int getDribblesPer90Percentile() {
        return dribblesPer90Percentile;
    }

    public void setDribblesPer90Percentile(int dribblesPer90Percentile) {
        this.dribblesPer90Percentile = dribblesPer90Percentile;
    }

    public int getProgressiveDribbleDistancePer90Percentile() {
        return progressiveDribbleDistancePer90Percentile;
    }

    public void setProgressiveDribbleDistancePer90Percentile(int progressiveDribbleDistancePer90Percentile) {
        this.progressiveDribbleDistancePer90Percentile = progressiveDribbleDistancePer90Percentile;
    }

    public int getPassesControlledPer90Percentile() {
        return passesControlledPer90Percentile;
    }

    public void setPassesControlledPer90Percentile(int passesControlledPer90Percentile) {
        this.passesControlledPer90Percentile = passesControlledPer90Percentile;
    }

    public int getAssistsPer90Percentile() {
        return assistsPer90Percentile;
    }

    public void setAssistsPer90Percentile(int assistsPer90Percentile) {
        this.assistsPer90Percentile = assistsPer90Percentile;
    }

    public int getExpectedAssistsPer90Percentile() {
        return expectedAssistsPer90Percentile;
    }

    public void setExpectedAssistsPer90Percentile(int expectedAssistsPer90Percentile) {
        this.expectedAssistsPer90Percentile = expectedAssistsPer90Percentile;
    }

    public int getPassesCompletedPerPositionPercentile() {
        return passesCompletedPerPositionPercentile;
    }

    public void setPassesCompletedPerPositionPercentile(int passesCompletedPerPositionPercentile) {
        this.passesCompletedPerPositionPercentile = passesCompletedPerPositionPercentile;
    }

    public int getProgressivePassingDistancePerPositionPercentile() {
        return progressivePassingDistancePerPositionPercentile;
    }

    public void setProgressivePassingDistancePerPositionPercentile(int progressivePassingDistancePerPositionPercentile) {
        this.progressivePassingDistancePerPositionPercentile = progressivePassingDistancePerPositionPercentile;
    }

    public int getCrossesPerPositionPercentile() {
        return crossesPerPositionPercentile;
    }

    public void setCrossesPerPositionPercentile(int crossesPerPositionPercentile) {
        this.crossesPerPositionPercentile = crossesPerPositionPercentile;
    }

    public int getDribblesPerPositionPercentile() {
        return dribblesPerPositionPercentile;
    }

    public void setDribblesPerPositionPercentile(int dribblesPerPositionPercentile) {
        this.dribblesPerPositionPercentile = dribblesPerPositionPercentile;
    }

    public int getProgressiveDribbleDistancePerPositionPercentile() {
        return progressiveDribbleDistancePerPositionPercentile;
    }

    public void setProgressiveDribbleDistancePerPositionPercentile(int progressiveDribbleDistancePerPositionPercentile) {
        this.progressiveDribbleDistancePerPositionPercentile = progressiveDribbleDistancePerPositionPercentile;
    }

    public int getPassesControlledPerPositionPercentile() {
        return passesControlledPerPositionPercentile;
    }

    public void setPassesControlledPerPositionPercentile(int passesControlledPerPositionPercentile) {
        this.passesControlledPerPositionPercentile = passesControlledPerPositionPercentile;
    }

    public int getAssistsPerPositionPercentile() {
        return assistsPerPositionPercentile;
    }

    public void setAssistsPerPositionPercentile(int assistsPerPositionPercentile) {
        this.assistsPerPositionPercentile = assistsPerPositionPercentile;
    }

    public int getExpectedAssistsPerPositionPercentile() {
        return expectedAssistsPerPositionPercentile;
    }

    public void setExpectedAssistsPerPositionPercentile(int expectedAssistsPerPositionPercentile) {
        this.expectedAssistsPerPositionPercentile = expectedAssistsPerPositionPercentile;
    }

    public int getPassesCompletedPer90PerPositionPercentile() {
        return passesCompletedPer90PerPositionPercentile;
    }

    public void setPassesCompletedPer90PerPositionPercentile(int passesCompletedPer90PerPositionPercentile) {
        this.passesCompletedPer90PerPositionPercentile = passesCompletedPer90PerPositionPercentile;
    }

    public int getProgressivePassingDistancePer90PerPositionPercentile() {
        return progressivePassingDistancePer90PerPositionPercentile;
    }

    public void setProgressivePassingDistancePer90PerPositionPercentile(int progressivePassingDistancePer90PerPositionPercentile) {
        this.progressivePassingDistancePer90PerPositionPercentile = progressivePassingDistancePer90PerPositionPercentile;
    }

    public int getCrossesPer90PerPositionPercentile() {
        return crossesPer90PerPositionPercentile;
    }

    public void setCrossesPer90PerPositionPercentile(int crossesPer90PerPositionPercentile) {
        this.crossesPer90PerPositionPercentile = crossesPer90PerPositionPercentile;
    }

    public int getDribblesPer90PerPositionPercentile() {
        return dribblesPer90PerPositionPercentile;
    }

    public void setDribblesPer90PerPositionPercentile(int dribblesPer90PerPositionPercentile) {
        this.dribblesPer90PerPositionPercentile = dribblesPer90PerPositionPercentile;
    }

    public int getProgressiveDribbleDistancePer90PerPositionPercentile() {
        return progressiveDribbleDistancePer90PerPositionPercentile;
    }

    public void setProgressiveDribbleDistancePer90PerPositionPercentile(int progressiveDribbleDistancePer90PerPositionPercentile) {
        this.progressiveDribbleDistancePer90PerPositionPercentile = progressiveDribbleDistancePer90PerPositionPercentile;
    }

    public int getPassesControlledPer90PerPositionPercentile() {
        return passesControlledPer90PerPositionPercentile;
    }

    public void setPassesControlledPer90PerPositionPercentile(int passesControlledPer90PerPositionPercentile) {
        this.passesControlledPer90PerPositionPercentile = passesControlledPer90PerPositionPercentile;
    }

    public int getAssistsPer90PerPositionPercentile() {
        return assistsPer90PerPositionPercentile;
    }

    public void setAssistsPer90PerPositionPercentile(int assistsPer90PerPositionPercentile) {
        this.assistsPer90PerPositionPercentile = assistsPer90PerPositionPercentile;
    }

    public int getExpectedAssistsPer90PerPositionPercentile() {
        return expectedAssistsPer90PerPositionPercentile;
    }

    public void setExpectedAssistsPer90PerPositionPercentile(int expectedAssistsPer90PerPositionPercentile) {
        this.expectedAssistsPer90PerPositionPercentile = expectedAssistsPer90PerPositionPercentile;
    }
}