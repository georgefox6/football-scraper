package Models;

import javax.persistence.*;

@Entity
@Table(name = "similar_players")
public class SimilarPlayers {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerId")
    private Player playerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player1")
    private Player player1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player2")
    private Player player2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player3")
    private Player player3;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player4")
    private Player player4;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player5")
    private Player player5;

    public SimilarPlayers(){

    }

    public SimilarPlayers(Player playerId, Player player1, Player player2, Player player3, Player player4, Player player5){
        this.playerId = playerId;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
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

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public Player getPlayer4() {
        return player4;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }

    public Player getPlayer5() {
        return player5;
    }

    public void setPlayer5(Player player5) {
        this.player5 = player5;
    }
}