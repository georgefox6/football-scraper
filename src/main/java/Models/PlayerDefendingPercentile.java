package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player_defending_percentile")
public class PlayerDefendingPercentile {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerId")
    private Player playerId;

    private int tacklesWonPercentile;
    private int blocksPercentile;
    private int interceptionsPercentile;
    private int pressuresPercentile;
    private int headersWonPercentile;

    private int tacklesWonPer90Percentile;
    private int blocksPer90Percentile;
    private int interceptionsPer90Percentile;
    private int pressuresPer90Percentile;
    private int headersWonPer90Percentile;

    private int tacklesWonPerPositionPercentile;
    private int blocksPerPositionPercentile;
    private int interceptionsPerPositionPercentile;
    private int pressuresPerPositionPercentile;
    private int headersWonPerPositionPercentile;

    private int tacklesWonPer90PerPositionPercentile;
    private int blocksPer90PerPositionPercentile;
    private int interceptionsPer90PerPositionPercentile;
    private int pressuresPer90PerPositionPercentile;
    private int headersWonPer90PerPositionPercentile;

    public PlayerDefendingPercentile(){

    }

    public PlayerDefendingPercentile(Player player, List<Player> playerList){
        this.playerId = player;

        long totalPlayers = playerList.size();
        long totalPlayersPerPosition = playerList.stream().filter(pl -> pl.getPlayerPosition().equals(player.getPlayerPosition())).count();


        //TacklesWon
        long playersWithLessTacklesWon = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getTacklesWon() < player.getTacklesWon()).count();
        this.tacklesWonPercentile = calculatePercentile((double) playersWithLessTacklesWon, (double) totalPlayers);

        long playersWithLessTacklesWonPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getTacklesWon() < player.getTacklesWon() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.tacklesWonPerPositionPercentile = calculatePercentile((double) playersWithLessTacklesWonPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessTacklesWonPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getTacklesWon()/(double)pl.getMinutesPlayed()) < ((double)player.getTacklesWon()/(double)player.getMinutesPlayed())).count();
            this.tacklesWonPer90Percentile = calculatePercentile((double) playersWithLessTacklesWonPer90, (double) totalPlayers);

            long playersWithLessTacklesWonPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getTacklesWon()/(double)pl.getMinutesPlayed()) < ((double)player.getTacklesWon()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.tacklesWonPer90PerPositionPercentile = calculatePercentile((double) playersWithLessTacklesWonPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.tacklesWonPer90Percentile = 0;
            this.tacklesWonPer90PerPositionPercentile = 0;
        }


        //Blocks
        long playersWithLessBlocks = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getBlocks() < player.getBlocks()).count();
        this.blocksPercentile = calculatePercentile((double) playersWithLessBlocks, (double) totalPlayers);

        long playersWithLessBlocksPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getBlocks() < player.getBlocks() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.blocksPerPositionPercentile = calculatePercentile((double) playersWithLessBlocksPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessBlocksPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getBlocks()/(double)pl.getMinutesPlayed()) < ((double)player.getBlocks()/(double)player.getMinutesPlayed())).count();
            this.blocksPer90Percentile = calculatePercentile((double) playersWithLessBlocksPer90, (double) totalPlayers);

            long playersWithLessBlocksPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getBlocks()/(double)pl.getMinutesPlayed()) < ((double)player.getBlocks()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.blocksPer90PerPositionPercentile = calculatePercentile((double) playersWithLessBlocksPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.blocksPer90Percentile = 0;
            this.blocksPer90PerPositionPercentile = 0;
        }


        //Interceptions
        long playersWithLessInterceptions = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getInterceptions() < player.getInterceptions()).count();
        this.interceptionsPercentile = calculatePercentile((double) playersWithLessInterceptions, (double) totalPlayers);

        long playersWithLessInterceptionsPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getInterceptions() < player.getInterceptions() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.interceptionsPerPositionPercentile = calculatePercentile((double) playersWithLessInterceptionsPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessInterceptionsPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getInterceptions()/(double)pl.getMinutesPlayed()) < ((double)player.getInterceptions()/(double)player.getMinutesPlayed())).count();
            this.interceptionsPer90Percentile = calculatePercentile((double) playersWithLessInterceptionsPer90, (double) totalPlayers);

            long playersWithLessInterceptionsPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getInterceptions()/(double)pl.getMinutesPlayed()) < ((double)player.getInterceptions()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.interceptionsPer90PerPositionPercentile = calculatePercentile((double) playersWithLessInterceptionsPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.interceptionsPer90Percentile = 0;
            this.interceptionsPer90PerPositionPercentile = 0;
        }


        //Pressures
        long playersWithLessPressures = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getPressuresWon() < player.getPressuresWon()).count();
        this.pressuresPercentile = calculatePercentile((double) playersWithLessPressures, (double) totalPlayers);

        long playersWithLessPressuresPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getPressuresWon() < player.getPressuresWon() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.pressuresPerPositionPercentile = calculatePercentile((double) playersWithLessPressuresPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessPressuresPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getPressuresWon()/(double)pl.getMinutesPlayed()) < ((double)player.getPressuresWon()/(double)player.getMinutesPlayed())).count();
            this.pressuresPer90Percentile = calculatePercentile((double) playersWithLessPressuresPer90, (double) totalPlayers);

            long playersWithLessPressuresPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getPressuresWon()/(double)pl.getMinutesPlayed()) < ((double)player.getPressuresWon()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.pressuresPer90PerPositionPercentile = calculatePercentile((double) playersWithLessPressuresPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.pressuresPer90Percentile = 0;
            this.pressuresPer90PerPositionPercentile = 0;
        }


        //HeadersWon
        long playersWithLessHeadersWon = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getHeadersWon() < player.getHeadersWon()).count();
        this.headersWonPercentile = calculatePercentile((double) playersWithLessHeadersWon, (double) totalPlayers);

        long playersWithLessHeadersWonPerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && pl.getHeadersWon() < player.getHeadersWon() && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
        this.headersWonPerPositionPercentile = calculatePercentile((double) playersWithLessHeadersWonPerPosition, (double) totalPlayersPerPosition);

        if(player.getMinutesPlayed() > 0){
            long playersWithLessHeadersWonPer90 = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getHeadersWon()/(double)pl.getMinutesPlayed()) < ((double)player.getHeadersWon()/(double)player.getMinutesPlayed())).count();
            this.headersWonPer90Percentile = calculatePercentile((double) playersWithLessHeadersWonPer90, (double) totalPlayers);

            long playersWithLessHeadersWonPer90PerPosition = playerList.stream().filter( pl -> pl.getMinutesPlayed() > 0 && ((double)pl.getHeadersWon()/(double)pl.getMinutesPlayed()) < ((double)player.getHeadersWon()/(double)player.getMinutesPlayed()) && pl.getPlayerPosition().equals(player.getPlayerPosition())).count();
            this.headersWonPer90PerPositionPercentile = calculatePercentile((double) playersWithLessHeadersWonPer90PerPosition, (double) totalPlayersPerPosition);
        } else {
            this.headersWonPer90Percentile = 0;
            this.headersWonPer90PerPositionPercentile = 0;
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

    public int getTacklesWonPercentile() {
        return tacklesWonPercentile;
    }

    public void setTacklesWonPercentile(int tacklesWonPercentile) {
        this.tacklesWonPercentile = tacklesWonPercentile;
    }

    public int getBlocksPercentile() {
        return blocksPercentile;
    }

    public void setBlocksPercentile(int blocksPercentile) {
        this.blocksPercentile = blocksPercentile;
    }

    public int getInterceptionsPercentile() {
        return interceptionsPercentile;
    }

    public void setInterceptionsPercentile(int interceptionsPercentile) {
        this.interceptionsPercentile = interceptionsPercentile;
    }

    public int getPressuresPercentile() {
        return pressuresPercentile;
    }

    public void setPressuresPercentile(int pressuresPercentile) {
        this.pressuresPercentile = pressuresPercentile;
    }

    public int getHeadersWonPercentile() {
        return headersWonPercentile;
    }

    public void setHeadersWonPercentile(int headersWonPercentile) {
        this.headersWonPercentile = headersWonPercentile;
    }

    public int getTacklesWonPer90Percentile() {
        return tacklesWonPer90Percentile;
    }

    public void setTacklesWonPer90Percentile(int tacklesWonPer90Percentile) {
        this.tacklesWonPer90Percentile = tacklesWonPer90Percentile;
    }

    public int getBlocksPer90Percentile() {
        return blocksPer90Percentile;
    }

    public void setBlocksPer90Percentile(int blocksPer90Percentile) {
        this.blocksPer90Percentile = blocksPer90Percentile;
    }

    public int getInterceptionsPer90Percentile() {
        return interceptionsPer90Percentile;
    }

    public void setInterceptionsPer90Percentile(int interceptionsPer90Percentile) {
        this.interceptionsPer90Percentile = interceptionsPer90Percentile;
    }

    public int getPressuresPer90Percentile() {
        return pressuresPer90Percentile;
    }

    public void setPressuresPer90Percentile(int pressuresPer90Percentile) {
        this.pressuresPer90Percentile = pressuresPer90Percentile;
    }

    public int getHeadersWonPer90Percentile() {
        return headersWonPer90Percentile;
    }

    public void setHeadersWonPer90Percentile(int headersWonPer90Percentile) {
        this.headersWonPer90Percentile = headersWonPer90Percentile;
    }

    public int getTacklesWonPerPositionPercentile() {
        return tacklesWonPerPositionPercentile;
    }

    public void setTacklesWonPerPositionPercentile(int tacklesWonPerPositionPercentile) {
        this.tacklesWonPerPositionPercentile = tacklesWonPerPositionPercentile;
    }

    public int getBlocksPerPositionPercentile() {
        return blocksPerPositionPercentile;
    }

    public void setBlocksPerPositionPercentile(int blocksPerPositionPercentile) {
        this.blocksPerPositionPercentile = blocksPerPositionPercentile;
    }

    public int getInterceptionsPerPositionPercentile() {
        return interceptionsPerPositionPercentile;
    }

    public void setInterceptionsPerPositionPercentile(int interceptionsPerPositionPercentile) {
        this.interceptionsPerPositionPercentile = interceptionsPerPositionPercentile;
    }

    public int getPressuresPerPositionPercentile() {
        return pressuresPerPositionPercentile;
    }

    public void setPressuresPerPositionPercentile(int pressuresPerPositionPercentile) {
        this.pressuresPerPositionPercentile = pressuresPerPositionPercentile;
    }

    public int getHeadersWonPerPositionPercentile() {
        return headersWonPerPositionPercentile;
    }

    public void setHeadersWonPerPositionPercentile(int headersWonPerPositionPercentile) {
        this.headersWonPerPositionPercentile = headersWonPerPositionPercentile;
    }

    public int getTacklesWonPer90PerPositionPercentile() {
        return tacklesWonPer90PerPositionPercentile;
    }

    public void setTacklesWonPer90PerPositionPercentile(int tacklesWonPer90PerPositionPercentile) {
        this.tacklesWonPer90PerPositionPercentile = tacklesWonPer90PerPositionPercentile;
    }

    public int getBlocksPer90PerPositionPercentile() {
        return blocksPer90PerPositionPercentile;
    }

    public void setBlocksPer90PerPositionPercentile(int blocksPer90PerPositionPercentile) {
        this.blocksPer90PerPositionPercentile = blocksPer90PerPositionPercentile;
    }

    public int getInterceptionsPer90PerPositionPercentile() {
        return interceptionsPer90PerPositionPercentile;
    }

    public void setInterceptionsPer90PerPositionPercentile(int interceptionsPer90PerPositionPercentile) {
        this.interceptionsPer90PerPositionPercentile = interceptionsPer90PerPositionPercentile;
    }

    public int getPressuresPer90PerPositionPercentile() {
        return pressuresPer90PerPositionPercentile;
    }

    public void setPressuresPer90PerPositionPercentile(int pressuresPer90PerPositionPercentile) {
        this.pressuresPer90PerPositionPercentile = pressuresPer90PerPositionPercentile;
    }

    public int getHeadersWonPer90PerPositionPercentile() {
        return headersWonPer90PerPositionPercentile;
    }

    public void setHeadersWonPer90PerPositionPercentile(int headersWonPer90PerPositionPercentile) {
        this.headersWonPer90PerPositionPercentile = headersWonPer90PerPositionPercentile;
    }
}