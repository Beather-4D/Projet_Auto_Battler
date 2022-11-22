package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Battleground {
    private LinkedList<Battler> player1Battlers;
    private LinkedList<Battler> player2Battlers;

    public Battleground(){
        player1Battlers = new LinkedList<Battler>();
        player2Battlers = new LinkedList<Battler>();
    }

    public void startFight(){
        
    }

    public void dealDamage(Player player, int damage){
        //inflige les dégâts de la défaite au joueur perdant
        player.reduceHealthPoints(damage);
    }

    private int calculateDamageAmount(){
        LinkedList<Battler> survivors;
        if(player1Battlers.size()==0){
            survivors = player2Battlers;
        } else {
            survivors = player1Battlers;
        }
        int sum = 0;
        for(Battler b : survivors){
            sum+=b.getRank();
        }
        return sum;
    }

    public LinkedList<Battler> getPlayer1Battlers(){
        return player1Battlers;
    }
    
    public LinkedList<Battler> getPlayer2Battlers(){
        return player2Battlers;
    }

}
