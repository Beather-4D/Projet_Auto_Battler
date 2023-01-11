import java.util.*;

public class Launcher {
    
    public static void startGame(String name1, String name2){
        Game game = new Game(name1, name2);
        game.gameLoop();
    }
    
    public static void Launch(){
        String name1 = "Player1";
        String name2 = "Player2";
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println(" Bienvenue dans le Projet Auto Battler ");
        do {
            System.out.println("|===============================|");
            System.out.println("   Nom joueur 1 : " + name1);
            System.out.println("   Nom joueur 2 : " + name2);
            System.out.println("|===============================|");

            System.out.println("Entrez 1 pour lancer la partie");
            System.out.println("Entrez 2 pour changer le nom du joueur 1");
            System.out.println("Entrez 3 pour changer le nom du joueur 2");
            
            System.out.print("> ");
            input = sc.nextLine();
            while ( !input.equals("1") && !input.equals("2") && !input.equals("3")){
                System.out.println("Valeur incorrecte, réessayez :");
                System.out.print("> ");
                input = sc.nextLine();
            }
            if(input.equals("2")){
                System.out.println("Quel nom pour le Joueur 1 ?");
                System.out.print("> ");
                name1 = sc.nextLine();
                if(name1.length() > 10){
                    name1 = name1.substring(0,10);
                }                
            }
            if(input.equals("3")){
                System.out.println("Quel nom pour le Joueur 2 ?");
                System.out.print("> ");
                name2 = sc.nextLine();
                if(name2.length() > 10){
                    name2 = name2.substring(0,10);
                }
                
            }
            
        } while (!input.equals("1"));
        startGame(name1, name2);
        sc.close();
    }
    
    public static void main(String[] args) {
        Launch();
        
    }
}
