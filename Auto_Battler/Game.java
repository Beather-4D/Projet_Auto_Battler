package model;

public class Game {
    private int nbTurn;

    private ArrayList<Player> players;

    private Deck deck;

    private Battleground battleground;

    public Game(String name1, String name2){
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        this.players.add(player1);
        this.players.add(player2);

        this.deck = new Deck;
        this.nbTurn = 0;
        this.battleground = new Battleground;
    }

    public void nextTurn(){

    }

    public void gameLoop(){

    }

    public int getNbTurn(){
        return nbTurn;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public Battleground getBattleground() {
        return battleground;
    }
}