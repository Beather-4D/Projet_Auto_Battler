import model.*;

public class Test {
    public static void main(String[] args) {
        Game jeu = new Game("Emilien", "Bilal");
        for(Player element : jeu.getPlayers()){
            System.out.println(element.getName());
            System.out.println(element.getGolds());
            System.out.println(element.getHealthPoints());
        }
        System.out.println();
        System.out.println("Tour N°"+jeu.getNbTurn());
        System.out.println();
        /*for(Battler b : jeu.getDeck().getDeckBattlers()){
            System.out.println(b.getAttack());
            System.out.println(b.getHealthPoints());
            System.out.println(b.getRank());
            System.out.println(b.getTribe());
            System.out.println();
        }*/
        Player joueur = jeu.getPlayers().get(0);
        for(int i = 0 ; i < 3 ; i++){
            Battler temp = jeu.getDeck().getDeckBattlers().get(i);
            joueur.getHand().add(temp);
        }
        System.out.println("Joueur " + joueur.getName());
        for(Battler element : joueur.getHand()){
            System.out.println(element.getAttack());
            System.out.println(element.getHealthPoints());
            System.out.println(element.getRank());
            System.out.println(element.getTribe()+"\n");
        }
        System.out.println("REFRESH DU SHOP");
        joueur.refreshShop();        
        for(Battler element : joueur.getHand()){
            System.out.println(element.getAttack());
            System.out.println(element.getHealthPoints());
            System.out.println(element.getRank());
            System.out.println(element.getTribe());            
        }
    }
}
