import processing.core.PApplet;




public class Main extends PApplet
{
    Cell [][] grid;
    int cols = 28;
    int rows = 36;

    public void settings(){
        size(500,500);
        grid = new Cell[cols][rows];
        stroke(128,128,255);
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                grid[i][j] = new Cell (i*21.42f, j*22.22f,21.42f,22.22f);
            }
        }
    }

    public void setup()
    {

    }

    public void draw() {
        background(0);
        for (int i = 0; i < cols; i++){
            for ( int j = 0; j < rows; j++){
                grid[i][j].display();
            }
        }

    }


    public static void main(String[] args)
    {
        PApplet.main("Main");
    }
}
