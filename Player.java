//Leon Nizovtsov 314801713, Kfir Kraus 318995115
public abstract class Player extends Thread{
    //Properties
    PlayerType playerType;
    //Constructor
    Player(PlayerType pt) {
        playerType = pt;
    }
}
