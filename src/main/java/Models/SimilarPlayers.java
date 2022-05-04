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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player6")
    private Player player6;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player7")
    private Player player7;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player8")
    private Player player8;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player9")
    private Player player9;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player10")
    private Player player10;

    public SimilarPlayers(){

    }

    public SimilarPlayers(Player playerId, Player player1, Player player2, Player player3, Player player4, Player player5, Player player6, Player player7, Player player8, Player player9, Player player10){
        this.playerId = playerId;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.player6 = player6;
        this.player7 = player7;
        this.player8 = player8;
        this.player9 = player9;
        this.player10 = player10;
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

    public Player getPlayer6() {
        return player6;
    }

    public void setPlayer6(Player player6) {
        this.player6 = player6;
    }

    public Player getPlayer7() {
        return player7;
    }

    public void setPlayer7(Player player7) {
        this.player7 = player7;
    }

    public Player getPlayer8() {
        return player8;
    }

    public void setPlayer8(Player player8) {
        this.player8 = player8;
    }

    public Player getPlayer9() {
        return player9;
    }

    public void setPlayer9(Player player9) {
        this.player9 = player9;
    }

    public Player getPlayer10() {
        return player10;
    }

    public void setPlayer10(Player player10) {
        this.player10 = player10;
    }
}