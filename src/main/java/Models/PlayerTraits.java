package Models;

import javax.persistence.*;

@Entity
@Table(name = "player_traits")
public class PlayerTraits {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerId")
    private Player playerId;

    private boolean longShotTaker;
    private boolean sneakyFouler;
    private boolean pressingForward;
    private boolean prolificDribbler;
    private boolean goodInTheAir;
    private boolean dirtyPlayer;
    private boolean safeOnTheBall;
    private boolean stamina;
    private boolean clinicalFinisher;

    public PlayerTraits(){

    }

    public PlayerTraits(Player player){
        if(player.getMinutesPlayed() > 270) {
            this.longShotTaker = player.getShots() > 20 && player.getShotDistance() > 20;
            this.sneakyFouler = player.getYellowCards() > 2 && ((double)player.getFouls() / (double)player.getYellowCards()) > 9.5;
            this.pressingForward = ((double)player.getPressuresWon() / (double)player.getMinutesPlayed() * 90) > 5.5 && isForward(player.getPlayerPosition());
            this.prolificDribbler = ((double)player.getDribblesAttempted() / (double)player.getMinutesPlayed()*90) > 2.75 && ((double)player.getDribblesCompleted() / (double)player.getDribblesAttempted()) > 0.55;
            this.goodInTheAir = ((double)player.getHeadersWon() / ((double)player.getHeadersWon() + (double)player.getHeadersLost())) > 0.7 && player.getHeadersWon() > 10;
            this.dirtyPlayer = (((player.getYellowCards() * 5) + (double)player.getFouls()) / (double)player.getMinutesPlayed())*90 > 3.5 &&  player.getFouls() > 15;
            this.safeOnTheBall = ((double)player.getDribblesCompleted() / (double)player.getDribblesAttempted()) + ((double)player.getPassesControlled() / (double)player.getPassesReceived()) + ((double)player.getTotalPassesCompleted() / (double)player.getTotalPassesAttempted()) > 2.4 && player.getDribblesAttempted() > 20;
            this.stamina = (player.getMinutesPlayed() > (player.getMatchesPlayed() * 85)) && !player.getPlayerPosition().equals("Goalkeeper") && player.getMatchesPlayed() > 30;
            this.clinicalFinisher = player.getShots() > 20 && ((double)player.getGoals() / (double)player.getShots()) > 0.175;
        } else {
            this.longShotTaker = false;
            this.sneakyFouler = false;
            this.pressingForward = false;
            this.prolificDribbler = false;
            this.goodInTheAir = false;
            this.dirtyPlayer = false;
            this.safeOnTheBall = false;
            this.stamina = false;
            this.clinicalFinisher = false;
        }
        this.playerId = player;
    }

    public PlayerTraits(int id, Player playerId, boolean longShotTaker, boolean sneakyFouler, boolean pressingForward, boolean prolificDribbler, boolean goodInTheAir, boolean dirtyPlayer, boolean safeOnTheBall, boolean stamina, boolean clinicalFinisher) {
        this.id = id;
        this.playerId = playerId;
        this.longShotTaker = longShotTaker;
        this.sneakyFouler = sneakyFouler;
        this.pressingForward = pressingForward;
        this.prolificDribbler = prolificDribbler;
        this.goodInTheAir = goodInTheAir;
        this.dirtyPlayer = dirtyPlayer;
        this.safeOnTheBall = safeOnTheBall;
        this.stamina = stamina;
        this.clinicalFinisher = clinicalFinisher;
    }

    public boolean isForward(String playerPosition){
        return playerPosition.equals("Centre-Forward") || playerPosition.equals("Right Winger") || playerPosition.equals("Left Winger");
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

    public boolean isLongShotTaker() {
        return longShotTaker;
    }

    public void setLongShotTaker(boolean longShotTaker) {
        this.longShotTaker = longShotTaker;
    }

    public boolean isSneakyFouler() {
        return sneakyFouler;
    }

    public void setSneakyFouler(boolean sneakyFouler) {
        this.sneakyFouler = sneakyFouler;
    }

    public boolean isPressingForward() {
        return pressingForward;
    }

    public void setPressingForward(boolean pressingForward) {
        this.pressingForward = pressingForward;
    }

    public boolean isProlificDribbler() {
        return prolificDribbler;
    }

    public void setProlificDribbler(boolean prolificDribbler) {
        this.prolificDribbler = prolificDribbler;
    }

    public boolean isGoodInTheAir() {
        return goodInTheAir;
    }

    public void setGoodInTheAir(boolean goodInTheAir) {
        this.goodInTheAir = goodInTheAir;
    }

    public boolean isDirtyPlayer() {
        return dirtyPlayer;
    }

    public void setDirtyPlayer(boolean dirtyPlayer) {
        this.dirtyPlayer = dirtyPlayer;
    }

    public boolean isSafeOnTheBall() {
        return safeOnTheBall;
    }

    public void setSafeOnTheBall(boolean safeOnTheBall) {
        this.safeOnTheBall = safeOnTheBall;
    }

    public boolean isStamina() {
        return stamina;
    }

    public void setStamina(boolean stamina) {
        this.stamina = stamina;
    }

    public boolean isClinicalFinisher() {
        return clinicalFinisher;
    }

    public void setClinicalFinisher(boolean clinicalFinisher) {
        this.clinicalFinisher = clinicalFinisher;
    }
}