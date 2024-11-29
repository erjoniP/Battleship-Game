package battleshipgame;

public class Main {
    public static void main(String[] args) {

        Gamesrv myGamesrv = new Gamesrv();
        myGamesrv=Gamesrv.load_game();
        myGamesrv.Start(10,10);


    }
}