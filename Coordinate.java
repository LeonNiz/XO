//Leon Nizovtsov 314801713, Kfir Kraus 318995115
public class Coordinate {
    //Properties
    private int x;
    private int y;

    //Constructors
    Coordinate() {
        x = 0;
        y = 0;
    }
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter and Setter methods
    int getX() {return x;}
    void setX(int x) {this.x = x;}
    int getY() {return y;}
    void setY(int y) {this.y = y;}
}
