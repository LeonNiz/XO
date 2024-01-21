//Leon Nizovtsov 314801713, Kfir Kraus 318995115
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game g=null;
        Player p1=null, p2;
        boolean flag;
        //Do while loop that runs until we get valid input and creates objects accordingly
        do {
            flag = true;
            System.out.println("Choose game version:");
            System.out.println("1. SelfPlayer vs. SelfPlayer");
            System.out.println("2. User vs. SelfPlayer");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    g = new SelfGame();
                    p1 = new SelfPlayer(PlayerType.X, g);
                    break;
                case 2:
                    g = new UserGame();
                    p1 = new UserPlayer(PlayerType.X, g);
                    break;
                default:
                    flag=false;
                    System.out.println("Input is not valid!");
                    break;
            }
        }while(!flag);
        p2 = new SelfPlayer(PlayerType.O, g);
        //Starting the Threads
        p1.start();
        p2.start();
    }
}
