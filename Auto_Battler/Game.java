
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in); 
        //ajout des golds
        for(Player p : players){
            p.addGolds(3+nbTurn);
        }
        //réduction cout amélioration du shop
        for(Player p : players){
            p.decreaseUpgradeCost();
        }
        //refresh des shops
        for(Player p : players){
            ArrayList<Battler> nv = Deck.refreshShop(p.getShop(), p.getShop().getTier());
            p.getShop().changeBattlers(nv);
        }
        //Player player = players.get(1);
        /* System.out.println("\nShop de " + player.getName());
        for(Battler battler : player.getShop().getShopBattlers()){
            System.out.println(battler.getName());
        } */
        //choix d'actions (up / buy(0,1,2) / sell (X) / see / refresh / freeze / done / help)
        for(Player player : this.players){       
            boolean aRefresh = false;               
            String cmd = "";
            while(!cmd.contains("done")){
                System.out.println("Que souhaitez-vous faire "+ player.getName() +" ? (help pour l'aide)");
                System.out.println("Vous avez " + player.getGolds() + " gold(s)");
                System.out.println(player.getShop().toString());
                System.out.println(player.handToString());
                cmd = sc.nextLine();
                if(cmd.contains("help")){ //affiche des commandes
                    System.out.println("\nhelp donne la liste des commandes\n"+
                    "up permet d'améliorer le tier de votre shop contre " + player.getShop().getUpgradeCost() + " gold(s)\n"+
                    "buy(0/1/2) permet d'acheter le battler 0, 1 ou 2\n"+
                    "sell(x) permet de vendre le battler x\n"+
                    "see permet de voir le deck et le shop\n"+
                    "refresh permet de rafraîchir le shop (une fois par tour)\n"+
                    "freeze permet de garder le même shop au prochain tour\n" +
                    "done permet de finir votre préparation\n");
                } else if(cmd.contains("up")){ //upgrade du shop
                    player.upgradeShop();                
                } else if (cmd.contains("freeze")){
                    //code pour freeze                
                } else if(cmd.contains("refresh")){ //refresh du shop
                    if(aRefresh){
                        System.out.println("Vous avez déjà rafraîchi votre shop !\n");
                    }
                    player.refreshShop();
                    aRefresh = true;
                } else if(cmd.contains("see")){ //affichage shop et main
                    System.out.println(player.getShop().toString());
                    System.out.println("\n");
                    System.out.println(player.handToString());
                    System.out.println("\n");
                } else if(cmd.contains("sell")){//vente d'un battler
                    int pos = Character.getNumericValue(cmd.charAt(5));
                    player.sell(pos);
                } else if(cmd.contains("buy")){ //achat d'un battler
                    int pos = Character.getNumericValue(cmd.charAt(4));
                    player.buy(pos);        
                } else if(cmd.contains("done")){
                    break;
                } else {
                    System.out.println("Commande Inconnue !\n"+
                    "(Utilisez la commande help si besoin !\n");
                }
                clearConsole(); 
            }
            clearConsole();
        }
        //placement sur le battleground   
        String cmd = "";
        for(Player player : this.players){
            LinkedList<Battler> field;
            int indPlayer = 0;
            if(player == this.players.get(0)){
                field = this.battleground.getPlayer1Battlers();
                indPlayer = 1;
            } else {
                field = this.battleground.getPlayer2Battlers();
                indPlayer = 2;
            }
            System.out.println("Place à la bataille "+ player.getName()+ " ! (écrivez done pour terminer)");
            System.out.println(player.handToString() +"\n");
            while(field.size() < 4){
                System.out.println("Il reste " + (4-field.size()) + " combattant(s) à sélectionner (0-9)");
                System.out.println(player.handToString() +"\n");
                System.out.println(this.battleground.toString() + "\n");
                cmd = sc.nextLine();
                if(cmd.contains("done")){
                    break;
                }
                int pos = Integer.parseInt(cmd);
                Battler choisi = player.getHand().get(pos);
                player.getHand().remove(pos);
                this.battleground.addBattler(choisi, indPlayer);
                clearConsole();
            }
            clearConsole();
        }
        clearConsole();
        //bataille
        Random rd = new Random(System.currentTimeMillis());
        Boolean auJoueur = rd.nextBoolean();
        while(this.battleground.getPlayer1Battlers().size()>0 && this.battleground.getPlayer2Battlers().size()>0){
            if(auJoueur){
                int indAtt = rd.nextInt(this.battleground.getPlayer2Battlers().size());
                int indDef = rd.nextInt(this.battleground.getPlayer1Battlers().size());
                int attaque = this.battleground.getPlayer2Battlers().get(indAtt).getAttack();
                this.battleground.getPlayer1Battlers().get(indDef).changeHealthPoints(-attaque);
            } else {
                int indAtt = rd.nextInt(this.battleground.getPlayer1Battlers().size());
                int indDef = rd.nextInt(this.battleground.getPlayer2Battlers().size());
                int attaque = this.battleground.getPlayer1Battlers().get(indAtt).getAttack();
                this.battleground.getPlayer2Battlers().get(indDef).changeHealthPoints(-attaque);
            }
            auJoueur = !auJoueur;
        }
        //retrait des HPs du joueur perdant
        //détection si les hp d'un joueur sont à 0 (fin du jeu)
        sc.close();
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

    private void clearConsole(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /* public  ArrayList<String> getNames(){
        ArrayList<String> rep = new ArrayList<>();
        for(Player p : players)
        rep.add(null)
    } */

}