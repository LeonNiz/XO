//Leon Nizovtsov 314801713, Kfir Kraus 318995115
import java.util.Random;
import java.util.Scanner;

public class UserGame extends Game{
    static Scanner input = new Scanner(System.in);
    //Constructor
    UserGame() {
        gameBoard = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        currentPlayer = PlayerType.X;
    }
    //getTurn method that return the turn of the current player
    PlayerType getTurn(){return currentPlayer;}
    //getFreeCells method that counting the number of free cells and create array with all the coordinates of this free cells
    Coordinate[] getFreeCells(){
        Coordinate [] freeCells;
        int counter=0;
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                if (gameBoard[i][j]==' '){
                    counter++;
                }
            }
        }
        freeCells=new Coordinate[counter];
        counter=0;
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                if (gameBoard[i][j]==' '){
                    freeCells[counter++]=new Coordinate(i,j);
                }
            }
        }
        return freeCells;
    }
    //isBoardFull method check if the board is full and return true or false
    boolean isBoardFull(){
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                if (gameBoard[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }
    //winner method check all the possibilities that exit for board 5X5 to win
    boolean winner(PlayerType p){
        for (int i = 0 ; i < 5 ; i++){
            if ((gameBoard[i][0]==p.name().charAt(0)&&gameBoard[i][1]==p.name().charAt(0)&&gameBoard[i][2]==p.name().charAt(0)&&gameBoard[i][3]==p.name().charAt(0))||
                    (gameBoard[i][1]==p.name().charAt(0)&&gameBoard[i][2]==p.name().charAt(0)&&gameBoard[i][3]==p.name().charAt(0)&&gameBoard[i][4]==p.name().charAt(0))){
                return true;
            }else if ((gameBoard[0][i]==p.name().charAt(0)&&gameBoard[1][i]==p.name().charAt(0)&&gameBoard[2][i]==p.name().charAt(0)&&gameBoard[3][i]==p.name().charAt(0))||
                    (gameBoard[1][i]==p.name().charAt(0)&&gameBoard[2][i]==p.name().charAt(0)&&gameBoard[3][i]==p.name().charAt(0)&&gameBoard[4][i]==p.name().charAt(0))){
                return true;
            }
        }
        if ((gameBoard[0][0] == p.name().charAt(0) &&
                gameBoard[1][1] == p.name().charAt(0) &&
                gameBoard[2][2] == p.name().charAt(0) &&
                gameBoard[3][3] == p.name().charAt(0))||
                (gameBoard[1][1] == p.name().charAt(0) &&
                        gameBoard[2][2] == p.name().charAt(0) &&
                        gameBoard[3][3] == p.name().charAt(0) &&
                        gameBoard[4][4] == p.name().charAt(0))||
                (gameBoard[0][1] == p.name().charAt(0) &&
                        gameBoard[1][2] == p.name().charAt(0) &&
                        gameBoard[2][3] == p.name().charAt(0) &&
                        gameBoard[3][4] == p.name().charAt(0))||
                (gameBoard[1][0] == p.name().charAt(0) &&
                        gameBoard[2][1] == p.name().charAt(0) &&
                        gameBoard[3][2] == p.name().charAt(0) &&
                        gameBoard[4][3] == p.name().charAt(0))) {
            return true;
        }

        if ((gameBoard[0][3] == p.name().charAt(0) &&
                gameBoard[1][2] == p.name().charAt(0) &&
                gameBoard[2][1] == p.name().charAt(0) &&
                gameBoard[3][0] == p.name().charAt(0))||
                (gameBoard[0][4] == p.name().charAt(0) &&
                        gameBoard[1][3] == p.name().charAt(0) &&
                        gameBoard[2][2] == p.name().charAt(0) &&
                        gameBoard[3][1] == p.name().charAt(0))||
                (gameBoard[1][3] == p.name().charAt(0) &&
                        gameBoard[2][2] == p.name().charAt(0) &&
                        gameBoard[3][1] == p.name().charAt(0) &&
                        gameBoard[4][0] == p.name().charAt(0))||
                (gameBoard[1][4] == p.name().charAt(0) &&
                        gameBoard[2][3] == p.name().charAt(0) &&
                        gameBoard[3][2] == p.name().charAt(0) &&
                        gameBoard[4][1] == p.name().charAt(0))) {
            return true;
        }

        return false;
    }
    //playTurn synchronized method that get Thread check if this his turn to play if not he will wait until the current Thread will and his turn and will notify to him that he is finished
    synchronized void playTurn(Player p){
        while(isBoardFull()==false && winner(currentPlayer)==false){
            if(currentPlayer==getTurn()){
                if(currentPlayer.name().charAt(0)=='X'){
                    int row, column;
                    Coordinate userChoice;
                    do{
                        System.out.println("Choose the row:");
                        row = input.nextInt();
                        System.out.println("Choose the column:");
                        column = input.nextInt();
                        userChoice = new Coordinate(row ,column);
                    }while ((row < 0 || row > 4)||(column < 0 || column > 4)||(getCellValue(userChoice)!=' '));
                    setCellValue(userChoice, currentPlayer.name().charAt(0));
                    printBoard();
                }else{
                    Coordinate[] freeCells=getFreeCells();
                    Random rnd = new Random();
                    Coordinate randomCell = freeCells[rnd.nextInt(freeCells.length)];
                    setCellValue(randomCell, currentPlayer.name().charAt(0));
                    printBoard();
                }
                if (winner(currentPlayer)==true){
                    String result = (currentPlayer.name().charAt(0)=='X')?"You Won!":"Game Over!";
                    System.out.println(result);
                    return;
                }else if(isBoardFull()==true){
                    System.out.println("Board is full");
                    return;
                }else {
                    currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
                    notify();
                }
            }else{
                try{
                    wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
