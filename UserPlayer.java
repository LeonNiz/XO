//Leon Nizovtsov 314801713, Kfir Kraus 318995115
import java.util.Scanner;

public class UserPlayer extends Player{
    static Scanner input = new Scanner(System.in);
    //Properties
    Game game;
    //Constructor
    UserPlayer(PlayerType pt, Game g) {
        super(pt);
        game = g;
    }
    //Run method
    @Override
    public void run() {
        game.playTurn(this);
    }
}
