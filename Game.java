//Leon Nizovtsov 314801713, Kfir Kraus 318995115
public abstract class Game{
    //Properties
    protected char[][] gameBoard;
    protected PlayerType currentPlayer;
    //PrintBoard method
    void printBoard(){
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //getTurn method
    abstract PlayerType getTurn();
    //getFreeCells method
    abstract Coordinate[] getFreeCells();
    //isBoardFull method
    abstract boolean isBoardFull();
    //winner method
    abstract boolean winner(PlayerType player);
    //playTurn method
    abstract void playTurn(Player player);
    //Getter and Setter method
    char getCellValue(Coordinate cell) {
        return gameBoard[cell.getX()][cell.getY()];
    }
    void setCellValue(Coordinate cell, char value) {
        gameBoard[cell.getX()][cell.getY()] = value;
    }
}
