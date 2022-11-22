import java.util.*;

public class Launcher {

    public static void startGame(String name1, String name2){
        Game game = new Game(name1, name2);
        game.gameLoop();
    }

    public static void Launch(){
        String name1 = "Default1";
        String name2 = "Default2";

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println(" Welcome in Auto Battler Project ");
        do {
            System.out.println("|===============================|");
            System.out.println("   Name player 1 : " + name1);
            System.out.println("   Name player 2 : " + name2);
            System.out.println("|===============================|");


            System.out.println("Enter 1 to start the game");
            System.out.println("Enter 2 to change player 1's name");
            System.out.println("Enter 3 to changer player 2's name");

            System.out.print("> ");
            input = sc.nextLine();
            while ( !input.equals("1") && !input.equals("2") && !input.equals("3")){
                System.out.println("Incorrect value, retry :");
                System.out.print(">");
                input = sc.nextLine();
            }

            if(input.equals("2")){
                System.out.println("What name for Player 1 ?");
                System.out.print("> ");
                name1 = sc.nextLine();

                if(name1.length() > 10){
                    name1 = name1.substring(0,10);
                }

            } else if(input.equals("3")){
                System.out.println("What name for Player 2 ?");
                System.out.print("> ");
                name2 = sc.nextLine();


                if(name2.length() > 10){
                    name2 = name2.substring(0,10);
                }

            }

        } while (!input.equals("1"));
        startGame(name1, name2);
    }

    public static void main(String[] args) {
        Launch();

    }
}
