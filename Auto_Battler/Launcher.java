public class Launcher {
    public void Launcher(){
        //TODO
    }

    public void startGame(String name1, String name2){
        Game game = new Game(name1, name2);
        game.gameLoop();
    }
}
