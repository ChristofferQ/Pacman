import processing.core.PApplet;

public class Pacman extends PApplet {

    Board board;


    public void settings(){
        size(600,800);


    }

    public void setup()
    {
        board = new Board(this);

    }

    public void draw() {

        board.UpdateBoard();
    }
}
