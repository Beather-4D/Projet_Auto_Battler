package model;

import java.util.LinkedList;

public class Player {
    private int golds;
    private int healthPoints;
    private LinkedList<Battler> hand;
    private Shop shop;
    private String name;
    
    public Player(){
        this.golds=0;
        this.healthPoints=20;
        hand = new LinkedList<Battler>();
        shop = new Shop();
        name = "Player";
    }
    
    public Player(String name){		
        this.golds=0;
        this.healthPoints = 20;
        hand = new LinkedList<Battler>();
        shop = new Shop();
        this.name = name;
    }
    
    //renvoie les golds du joueur
    public int getGolds(){
        return this.golds;
    }
    
    //ajoute des golds au joueur
    public void addGolds(int amount){
        this.golds += amount;
    }
    
    //retire des golds au joueur
    public void removeGolds(int amount){
        this.golds -= amount;
    }
    
    //renvoie les HPs du joueur
    public int getHealthPoints(){
        return this.healthPoints;
    }
    
    //réduit les HPs du joueur
    public void reduceHealthPoints(int amount){
        this.healthPoints -= amount;
    }
    
    //renvoie la main du joueur
    public LinkedList<Battler> getHand(){
        return this.hand;
    }
    
    //renvoie le shop du joueur
    public Shop getShop(){
        return this.shop;
    }
    
    //renvoie le nom du joueur
    public String getName(){
        return this.name;
    }
    //achète un battler du shop
    public void buy(int shopPosition){
        if(this.golds < 3){
            clearConsole();
            System.out.println("Vous n'avez pas assez d'argent pour acheter !\n");
            return;
        }
        if(this.hand.size()==10){
            clearConsole();
            System.out.println("Vous avez le nombre maximum de cartes (10) !\n");
            return;
        }
        Battler battler = this.shop.getShopBattlers().get(shopPosition);
        this.hand.add(battler);
        this.golds-=3;
        this.shop.getShopBattlers().remove(battler);
    }
    
    /* public void sell(Battler battler){
        if(hand.contains(battler)==false){
            //gestion d'erreur
        }
        this.hand.remove(battler);
        this.golds++;
    } */

    public void sell(int pos){
        if(hand.size() <= pos){
            clearConsole();
            System.out.println("Erreur dans le choix de la carte à vendre\n");
        }
        Battler b = this.hand.get(pos);
        Deck.getDeckBattlers().add(b);
        this.hand.remove(pos);
        this.golds++;
    }
    
    public void decreaseUpgradeCost(){
        this.shop.decreaseUpgradeCost();
    }
    
    public void refreshShop(){
        this.shop.changeBattlers(Deck.refreshShop(this.shop, this.shop.getTier()));
    }
    
    public void upgradeShop(){
        if(this.golds >= this.shop.getUpgradeCost()){
            this.shop.upgradeTier();
            removeGolds(this.shop.getUpgradeCost());
            this.shop.resetUpgradeCost();
        } else {
            clearConsole();
            System.out.println("Vous n'avez pas assez d'argent pour améliorer votre shop !\n");
        }
    }
    
    public void freezeShop() {
        //TODO
    }

    public String handToString(){
        String rep = "Votre Main : ";
        if(this.hand.size() > 0){
            for(Battler b : this.hand){
                rep += b.toString() + " ";
            }
        } else {
            rep+="vide";
        }
        rep += "\n";
        return rep;
    }

    //pour clear la console
    public static void clearConsole(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}