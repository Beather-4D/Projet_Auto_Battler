import java.util.*;

public class Launcher {
    
    public static void startGame(String name1, String name2){
        Game game = new Game(name1, name2);
        game.gameLoop();
    }
    
    public static void Launch(){
        String name1 = "R0B0T";
        String name2 = "Player";
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println(" Welcome in Auto Battler Project ");
        do {
            System.out.println("|===============================|");
            System.out.println("   Name AI : " + name1);
            System.out.println("   Name player : " + name2);
            System.out.println("|===============================|");
            
            
            System.out.println("Enter 1 to start the game");
            System.out.println("Enter 2 to change the player's name");
            
            System.out.print("> ");
            input = sc.nextLine();
            while ( !input.equals("1") && !input.equals("2")){
                System.out.println("Incorrect value, retry :");
                System.out.print("> ");
                input = sc.nextLine();
            }
            if(input.equals("2")){
                System.out.println("What name for the Player ?");
                System.out.print("> ");
                name2 = sc.nextLine();
                
                
                if(name2.length() > 10){
                    name2 = name2.substring(0,10);
                }
                
            }
            
        } while (!input.equals("1"));
        //clear de la console
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        startGame(name1, name2);
        sc.close();
    }
    
    public static void main(String[] args) {
        Launch();
        
    }
}
