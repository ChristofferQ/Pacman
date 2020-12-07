import processing.core.PApplet;

public class Main extends PApplet
{
//    public static PApplet processing;
    public static void main(String[] args)
    {
        PApplet.main("Main");
    }

    public void settings()
    {
        size(600,800);
    }

    public void setup()
    {
        background(0);
//        processing = this;
    }

    public void draw()
    {
//        Board myBoard = new Board();
//        myBoard.drawBoard();
        noFill();
        stroke(128, 128, 255);
        for (int j = 0; j < height / 20; j++)
        {
            for (int i = 0; i < width / 20; i++)
            {
                rect(20 * i, 20 * j, 20, 20);
            }
        }
    }


}
