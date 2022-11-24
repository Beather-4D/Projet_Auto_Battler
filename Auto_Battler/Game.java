
import java.util.ArrayList;

import model.*;

public class Game {
    private int nbTurn;
    private ArrayList<Player> players;
    private Deck deck;
    private Battleground battleground;

    public Game(String name1, String name2){
        this.nbTurn = 0;
        players = new ArrayList<Player>();

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        this.players.add(player1);
        this.players.add(player2);

        this.deck = new Deck();        
        this.battleground = new Battleground();

    }

    public void nextTurn(){

    }

    public void gameLoop(){
        //ajout des golds
        for(Player p : players){
            p.addGolds(3+nbTurn);
        }
        //refresh des shops
        deck.refreshAllShops(players);
        //affichage des shops
        //choix dans le shop
        //placement sur le battleground
        //bataille
        //retrait des HPs du joueur perdant

        //détection si les hp d'un jouer sont à 0 (fin du jeu)
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
