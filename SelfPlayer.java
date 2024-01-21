//Leon Nizovtsov 314801713, Kfir Kraus 318995115
public class SelfPlayer extends Player{
    //Properties
    Game game;
    //Constructor
    SelfPlayer(PlayerType pt, Game g) {
        super(pt);
        game = g;
    }
    //Run method
    @Override
    public void run() {
        game.playTurn(this);
    }
}
