package Models;

import javax.persistence.*;

@Entity
@Table(name = "PLAYERS")
public class Player {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    //General
    private String playerName;
    private String playerNation;
    private String playerPosition;
    private String playerAge;
    private String playerTeam;

    //Playing time
    private int matchesPlayed;
    private int matchesStarted;
    private int minutesPlayed;

    //Performance
    private int goals;
    private int assists;

    //Expected performance
    private double expectedGoals;
    private double expectedAssists;

    //Shooting
    private int shots;
    private int shotsOnTarget;
    private double shotDistance;
    private int freeKickShots;
    private int penaltyScored;
    private int penaltyShots;

    //Passing
    private int totalPassesAttempted;
    private int totalPassesCompleted;
    private int shortPassesAttempted;
    private int shortPassesCompleted;
    private int mediumPassesAttempted;
    private int mediumPassesCompleted;
    private int LongPassesAttempted;
    private int LongPassesCompleted;
    private int progressivePassingDistance;
    private int crosses;

    //Defensive
    private int tacklesAttempted;
    private int tacklesWon;
    private int tacklesDefensiveThird;
    private int tacklesMiddleThird;
    private int tacklesAttackingThird;
    private int interceptions;
    private int pressuresAttempted;
    private int pressuresWon;
    private int pressuresDefensiveThird;
    private int pressuresMiddleThird;
    private int pressuresAttackingThird;
    private int blocks;
    private int fouls;

    //Dribbling
    private int dribblesAttempted;
    private int dribblesCompleted;
    private int dribblesProgressiveDistance;
    private int progressiveDribbles;
    private int passesReceived;
    private int passesControlled;

    //Misc
    private int yellowCards;
    private int RedCards;
    private int headersWon;
    private int headersLost;

    //General transfer
    private int height;
    private String preferredFoot;
    private String contractEndDate;
    private int marketValue;
    private int wage;


    public Player(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerNation(String playerNation) {
        this.playerNation = playerNation;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void setPlayerAge(String playerAge) {
        this.playerAge = playerAge;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setMatchesStarted(int matchesStarted) {
        this.matchesStarted = matchesStarted;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setExpectedGoals(double expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public void setExpectedAssists(double expectedAssists) {
        this.expectedAssists = expectedAssists;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public void setShotsOnTarget(int shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public void setShotDistance(double shotDistance) {
        this.shotDistance = shotDistance;
    }

    public void setFreeKickShots(int freeKickShots) {
        this.freeKickShots = freeKickShots;
    }

    public void setPenaltyScored(int penaltyScored) {
        this.penaltyScored = penaltyScored;
    }

    public void setPenaltyShots(int penaltyShots) {
        this.penaltyShots = penaltyShots;
    }

    public void setTotalPassesAttempted(int totalPassesAttempted) {
        this.totalPassesAttempted = totalPassesAttempted;
    }

    public void setTotalPassesCompleted(int totalPassesCompleted) {
        this.totalPassesCompleted = totalPassesCompleted;
    }

    public void setShortPassesAttempted(int shortPassesAttempted) {
        this.shortPassesAttempted = shortPassesAttempted;
    }

    public void setShortPassesCompleted(int shortPassesCompleted) {
        this.shortPassesCompleted = shortPassesCompleted;
    }

    public void setMediumPassesAttempted(int mediumPassesAttempted) {
        this.mediumPassesAttempted = mediumPassesAttempted;
    }

    public void setMediumPassesCompleted(int mediumPassesCompleted) {
        this.mediumPassesCompleted = mediumPassesCompleted;
    }

    public void setLongPassesAttempted(int longPassesAttempted) {
        LongPassesAttempted = longPassesAttempted;
    }

    public void setLongPassesCompleted(int longPassesCompleted) {
        LongPassesCompleted = longPassesCompleted;
    }

    public void setProgressivePassingDistance(int progressivePassingDistance) {
        this.progressivePassingDistance = progressivePassingDistance;
    }

    public void setCrosses(int crosses) {
        this.crosses = crosses;
    }

    public void setTacklesAttempted(int tacklesAttempted) {
        this.tacklesAttempted = tacklesAttempted;
    }

    public void setTacklesWon(int tacklesWon) {
        this.tacklesWon = tacklesWon;
    }

    public void setTacklesDefensiveThird(int tacklesDefensiveThird) {
        this.tacklesDefensiveThird = tacklesDefensiveThird;
    }

    public void setTacklesMiddleThird(int tacklesMiddleThird) {
        this.tacklesMiddleThird = tacklesMiddleThird;
    }

    public void setTacklesAttackingThird(int tacklesAttackingThird) {
        this.tacklesAttackingThird = tacklesAttackingThird;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public void setPressuresAttempted(int pressuresAttempted) {
        this.pressuresAttempted = pressuresAttempted;
    }

    public void setPressuresWon(int pressuresWon) {
        this.pressuresWon = pressuresWon;
    }

    public void setPressuresDefensiveThird(int pressuresDefensiveThird) {
        this.pressuresDefensiveThird = pressuresDefensiveThird;
    }

    public void setPressuresMiddleThird(int pressuresMiddleThird) {
        this.pressuresMiddleThird = pressuresMiddleThird;
    }

    public void setPressuresAttackingThird(int pressuresAttackingThird) {
        this.pressuresAttackingThird = pressuresAttackingThird;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public void setDribblesAttempted(int dribblesAttempted) {
        this.dribblesAttempted = dribblesAttempted;
    }

    public void setDribblesCompleted(int dribblesCompleted) {
        this.dribblesCompleted = dribblesCompleted;
    }

    public void setDribblesProgressiveDistance(int dribblesProgressiveDistance) {
        this.dribblesProgressiveDistance = dribblesProgressiveDistance;
    }

    public void setProgressiveDribbles(int progressiveDribbles) {
        this.progressiveDribbles = progressiveDribbles;
    }

    public void setPassesReceived(int passesReceived) {
        this.passesReceived = passesReceived;
    }

    public void setPassesControlled(int passesControlled) {
        this.passesControlled = passesControlled;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public void setRedCards(int redCards) {
        RedCards = redCards;
    }

    public void setHeadersWon(int headersWon) {
        this.headersWon = headersWon;
    }

    public void setHeadersLost(int headersLost) {
        this.headersLost = headersLost;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerNation() {
        return playerNation;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getMatchesStarted() {
        return matchesStarted;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public double getExpectedGoals() {
        return expectedGoals;
    }

    public double getExpectedAssists() {
        return expectedAssists;
    }

    public int getShots() {
        return shots;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public double getShotDistance() {
        return shotDistance;
    }

    public int getFreeKickShots() {
        return freeKickShots;
    }

    public int getPenaltyScored() {
        return penaltyScored;
    }

    public int getPenaltyShots() {
        return penaltyShots;
    }

    public int getTotalPassesAttempted() {
        return totalPassesAttempted;
    }

    public int getTotalPassesCompleted() {
        return totalPassesCompleted;
    }

    public int getShortPassesAttempted() {
        return shortPassesAttempted;
    }

    public int getShortPassesCompleted() {
        return shortPassesCompleted;
    }

    public int getMediumPassesAttempted() {
        return mediumPassesAttempted;
    }

    public int getMediumPassesCompleted() {
        return mediumPassesCompleted;
    }

    public int getLongPassesAttempted() {
        return LongPassesAttempted;
    }

    public int getLongPassesCompleted() {
        return LongPassesCompleted;
    }

    public int getProgressivePassingDistance() {
        return progressivePassingDistance;
    }

    public int getCrosses() {
        return crosses;
    }

    public int getTacklesAttempted() {
        return tacklesAttempted;
    }

    public int getTacklesWon() {
        return tacklesWon;
    }

    public int getTacklesDefensiveThird() {
        return tacklesDefensiveThird;
    }

    public int getTacklesMiddleThird() {
        return tacklesMiddleThird;
    }

    public int getTacklesAttackingThird() {
        return tacklesAttackingThird;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public int getPressuresAttempted() {
        return pressuresAttempted;
    }

    public int getPressuresWon() {
        return pressuresWon;
    }

    public int getPressuresDefensiveThird() {
        return pressuresDefensiveThird;
    }

    public int getPressuresMiddleThird() {
        return pressuresMiddleThird;
    }

    public int getPressuresAttackingThird() {
        return pressuresAttackingThird;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getFouls() {
        return fouls;
    }

    public int getDribblesAttempted() {
        return dribblesAttempted;
    }

    public int getDribblesCompleted() {
        return dribblesCompleted;
    }

    public int getDribblesProgressiveDistance() {
        return dribblesProgressiveDistance;
    }

    public int getProgressiveDribbles() {
        return progressiveDribbles;
    }

    public int getPassesReceived() {
        return passesReceived;
    }

    public int getPassesControlled() {
        return passesControlled;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRedCards() {
        return RedCards;
    }

    public int getHeadersWon() {
        return headersWon;
    }

    public int getHeadersLost() {
        return headersLost;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPreferredFoot() {
        return preferredFoot;
    }

    public void setPreferredFoot(String preferredFoot) {
        this.preferredFoot = preferredFoot;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

//    public String toString(){
//        return
//    }
}
