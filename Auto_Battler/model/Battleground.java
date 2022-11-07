package model;

import java.util.LinkedList;

public class Battleground {
    private LinkedList<Battler> player1Battlers;
    private LinkedList<Battler> player2Battlers;

    Battleground(){
        player1Battlers = new LinkedList<Battler>();
        player2Battlers = new LinkedList<Battler>();
    }

    public void startFight(){

    }

    public void dealDamage(Player player, int damage){

    }

    private int calculateDamageAmount(){
        return 0;
    }

    public LinkedList<Battler> getPlayer1Battlers(){
        return player1Battlers;
    }
    
    public LinkedList<Battler> getPlayer2Battlers(){
        return player2Battlers;
    }

}
