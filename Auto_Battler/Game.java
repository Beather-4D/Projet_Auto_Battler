
import java.util.ArrayList;

import model.*;

public class Game {
    private int nbTurn;
    private ArrayList<Player> players;
    private Deck deck;
    private Battleground battleground;
    
    public Game(String name1, String name2){
        this.nbTurn = 0;
        this.deck = new Deck();        
        this.battleground = new Battleground();
        
        players = new ArrayList<Player>();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        this.players.add(player1);
        this.players.add(player2);
        
    }
    
    public void nextTurn(){
        
    }
    
    public void gameLoop(){
        //ajout des golds
        for(Player p : players){
            p.addGolds(3+nbTurn);
        }
        //refresh des shops
        for(Player p : players){
            ArrayList<Battler> nv = Deck.refreshShop(p.getShop());
            p.getShop().changeBattlers(nv);
        }
        //affichage des shops
        for(Player player : players){
            System.out.println("\nShop de " + player.getName());
            for(Battler battler : player.getShop().getShopBattlers()){
                System.out.println(battler.getName());
            }
        }
        //choix dans le shop
        //placement sur le battleground
        //bataille
        //retrait des HPs du joueur perdant
        
        //détection si les hp d'un joueur sont à 0 (fin du jeu)
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
