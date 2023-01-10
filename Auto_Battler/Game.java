
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
        this.nbTurn = 1;
        this.deck = new Deck();        
        this.battleground = new Battleground();        
        players = new ArrayList<Player>();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        this.players.add(player1);
        this.players.add(player2);        
    }
    
    public boolean isGameOver(){
        for(Player p : players){
            if(p.getHealthPoints()<=0){
                return true;
            }
        }
        return false;
    }
    
    public void gameLoop(){
        Scanner sc = new Scanner(System.in);
        System.out.println("~~~~~~\nTOUR " +(nbTurn)+"\n~~~~~~");
        while(!isGameOver()){
            //ajout des golds
            for(Player p : players){
                p.addGolds(3+(nbTurn-1));
            }
            //réduction cout amélioration du shop
            for(Player p : players){
                p.decreaseUpgradeCost();
            }
            //refresh des shops
            for(Player p : players){
                if(p.afreeze()){
                    p.deFreeze();
                    continue;
                }
                ArrayList<Battler> nv = Deck.refreshShop(p.getShop(), p.getShop().getTier());
                p.getShop().changeBattlers(nv);
            }
            //choix d'actions (up / buy(0,1,2) / sell (X) / refresh / freeze / done / help)
            for(Player player : this.players){       
                boolean aRefresh = false;             
                String cmd = "";
                while(!cmd.contains("done")){
                    System.out.println("Que souhaitez-vous faire "+ player.getName() +" ? (help pour l'aide)");
                    System.out.println("Vous avez " + player.getGolds() + " gold(s)");
                    System.out.println(player.getShop().toString());
                    System.out.println(player.handToString());
                    cmd = sc.nextLine();
                    clearConsole();
                    if(cmd.contains("help")){ //affichage des commandes
                        System.out.println("\nhelp donne la liste des commandes\n"+
                        "up permet d'améliorer le tier de votre shop contre " + player.getShop().getUpgradeCost() + " gold(s)\n"+
                        "buy(0/1/2) permet d'acheter le battler 0, 1 ou 2\n"+
                        "sell(x) permet de vendre le battler x\n"+
                        "refresh permet de rafraîchir le shop (une fois par tour)\n"+
                        "freeze permet de garder le même shop au prochain tour\n" +
                        "done permet de finir votre préparation\n");
                    } else if(cmd.contains("up")){ //upgrade du shop
                        player.upgradeShop();                
                    } else if (cmd.contains("freeze")){
                        player.freezeShop();               
                    } else if(cmd.contains("refresh")){ //refresh du shop
                        if(aRefresh){
                            System.out.println("Vous avez déjà rafraîchi votre shop !\n");
                            continue;
                        }
                        player.refreshShop();
                        aRefresh = true;
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
                while(field.size() < 4 && player.getHand().size() > 0){
                    System.out.println("Il reste " + (4-field.size()) + " combattant(s) à sélectionner (0-9)");
                    System.out.println(player.handToString() +"\n");
                    System.out.println(this.battleground.toString(this.players) + "\n");
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
            System.out.println("LA BATAILLE COMMENCE !\n");
            System.out.println(this.battleground.toString(players));
            Random rd = new Random(System.currentTimeMillis());
            Boolean auJoueur2 = rd.nextBoolean();
            if(auJoueur2){
                System.out.println(players.get(1).getName() + " commence cette bataille\n");
            } else {
                System.out.println(players.get(0).getName() + " commence cette bataille\n");
            }
            while(this.battleground.getPlayer1Battlers().size()>0 && this.battleground.getPlayer2Battlers().size()>0){
                /* int test = rd.nextInt(this.battleground.getPlayer2Battlers().size());
                System.out.println(test + "\n\n"); */
                if(auJoueur2){
                    int indAtt = rd.nextInt(this.battleground.getPlayer2Battlers().size());
                    int indDef = rd.nextInt(this.battleground.getPlayer1Battlers().size());
                    Battler attaquant = this.battleground.getPlayer2Battlers().get(indAtt);
                    Battler defenseur = this.battleground.getPlayer1Battlers().get(indDef);
                    System.out.println(attaquant.toString() + " attaque " + defenseur.toString());
                    int attAtt = attaquant.getAttack();
                    defenseur.changeHealthPoints(-attAtt);
                    int attDef = defenseur.getAttack();
                    attaquant.changeHealthPoints(-attDef);
                    if(defenseur.getHealthPoints()<= 0){
                        Battler mort = this.battleground.getPlayer1Battlers().remove(indDef);
                        System.out.println(mort.toString() + " a succombé !\n");
                    }
                    if(attaquant.getHealthPoints()<= 0){
                        Battler mort = this.battleground.getPlayer2Battlers().remove(indAtt);
                        System.out.println(mort.toString() + " a succombé !\n");
                    }
                } else {
                    int indAtt = rd.nextInt(this.battleground.getPlayer1Battlers().size());
                    int indDef = rd.nextInt(this.battleground.getPlayer2Battlers().size());
                    Battler attaquant = this.battleground.getPlayer1Battlers().get(indAtt);
                    Battler defenseur = this.battleground.getPlayer2Battlers().get(indDef);
                    System.out.println(attaquant.toString() + " attaque " + defenseur.toString());
                    int attAtt = attaquant.getAttack();
                    defenseur.changeHealthPoints(-attAtt);
                    int attDef = defenseur.getAttack();
                    attaquant.changeHealthPoints(-attDef);                
                    if(defenseur.getHealthPoints()<= 0){
                        Battler mort = this.battleground.getPlayer2Battlers().remove(indDef);
                        System.out.println(mort.toString() + " a succombé !\n");
                    }
                    if(attaquant.getHealthPoints()<= 0){
                        Battler mort = this.battleground.getPlayer1Battlers().remove(indAtt);
                        System.out.println(mort.toString() + " a succombé !\n");
                    }
                }
                auJoueur2 = !auJoueur2;
            }
            //retrait des HPs du joueur perdant
            if(this.battleground.getPlayer1Battlers().size() == 0){
                for(Battler b : this.battleground.getPlayer2Battlers()){
                    this.players.get(1).getHand().add(b);
                }
                players.get(0).reduceHealthPoints(this.battleground.calculateDamageAmount());
                System.out.println(players.get(0).getName() + " a subi " + this.battleground.calculateDamageAmount() + " pt(s) de dégâts !\n");
                System.out.println(playersHpToString());
                this.battleground.getPlayer2Battlers().clear();
            } else {
                for(Battler b : this.battleground.getPlayer1Battlers()){
                    this.players.get(0).getHand().add(b);
                }
                players.get(1).reduceHealthPoints(this.battleground.calculateDamageAmount());
                System.out.println(players.get(1).getName() + " a subi " + this.battleground.calculateDamageAmount() + " pt(s) de dégâts !\n");
                System.out.println(playersHpToString());
                this.battleground.getPlayer1Battlers().clear();
            }
            nbTurn++;
            System.out.println("~~~~~~\nTOUR " +nbTurn+"\n~~~~~~");
        }
        Player gagnant;
        if(players.get(0).getHealthPoints()<=0){
            gagnant = players.get(1);
        } else {
            gagnant = players.get(0);
        }
        System.out.println("FIN DU JEU ! " + gagnant.getName() + " a gagné en "+ nbTurn + " tours !\n");
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

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public String playersHpToString(){
        String rep = "";
        for(Player p : players){
            rep += p.getName() + " a " + p.getHealthPoints() + " pt(s) de vie \n";
       }
       return rep;
    }

}