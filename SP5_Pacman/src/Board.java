import processing.core.PApplet;

public class Board {

    PApplet p;
    Cell[][] grid;
    int cols = 28;
    int rows = 36;

    public Cell[][] getGrid() {
        return grid;
    }

    public Board(PApplet p) {
        this.p = p;
        CreateBoard();
    }

    public void CreateBoard() {
        grid = new Cell[cols][rows];
        p.stroke(128, 128, 255);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = new Cell(i * 21.42f, j * 22.22f, 21.42f, 22.22f);
            }
        }
    }

    public void UpdateBoard(){
        p.background(0);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j].display(p);
            }
        }
    }


}
