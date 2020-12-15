import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Pacman extends PApplet
{
    PApplet p = new PApplet();

    PVector pos;
    PVector vel = new PVector(-1, 0);
    PVector turnTo = new PVector(-1, 0);
    boolean turn = false;
    boolean eaten = false;
    boolean dot = false;
    PImage img;

    public Pacman()
    {
        pos = new PVector(13 * 16 + 8, 23 * 16 + 8);
    }

    Tile[][] tiles = new Tile[31][28];
    int[][] tilesRepresentation = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 8, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 8, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 6, 1, 1, 6, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 6, 1, 1, 6, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 6, 6, 6, 1, 1, 1, 1, 1, 1, 1, 1, 6, 6, 6, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 8, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 8, 1},
            {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};


    public void setup()
    {
        frameRate(100);
    }

    public void settings()
    {
        size(448, 496);
        img = loadImage("map.jpg");

        for (int i = 0; i < 28; i++)
        {
            for (int j = 0; j < 31; j++)
            {
                tiles[j][i] = new Tile(16 * i + 8, 16 * j + 8);
                switch (tilesRepresentation[j][i])
                {
                    case 0:
                        tiles[j][i].dot = true;
                        break;
                    case 1:
                        tiles[j][i].wall = true;
                        break;
                }
            }
        }
    }

    public void draw()
    {
        image(img, 0, 0);
        this.movePacman(p);
        this.showPacman(p);
        this.showFood(p);
    }


    public void keyPressed()
    {
        switch (key)
        {
            case CODED:
                switch (keyCode)
                {
                    case UP:
                        this.turnTo = new PVector(0, -1);
                        this.turn = true;
                        break;
                    case DOWN:
                        this.turnTo = new PVector(0, 1);
                        this.turn = true;
                        break;
                    case LEFT:
                        this.turnTo = new PVector(-1, 0);
                        this.turn = true;
                        break;
                    case RIGHT:
                        this.turnTo = new PVector(1, 0);
                        this.turn = true;
                        break;
                }
        }
    }

    public void movePacman(PApplet p)
    {
        if (checkPosition())
        {
            pos.add(vel);
        }
    }

    public void showPacman(PApplet p)
    {
        fill(255, 255, 0);
        stroke(255, 255, 0);
        ellipse(pos.x, pos.y, 20, 20);
    }

    public void showFood(PApplet p)
    {
        for (int i = 0; i < 28; i++)
        {
            for (int j = 0; j < 31; j++)
            {

                if (tilesRepresentation[j][i] == 0 || tilesRepresentation[j][i] == 6)
                {
                    if (!eaten)
                    {
                        //draw small dot
                        fill(255, 255, 0);
                        noStroke();
                        ellipse(i * 16 + 8, j * 16 + 8, 5, 5);
                    }
                } else if (tilesRepresentation[j][i] == 8)
                {
                    if (!eaten)
                        //draw big dot
                        fill(102, 0, 204);
                        noStroke();
                        ellipse(i * 16 + 8, j * 16 + 8, 14, 14);
                }
            }
        }
    }

    public boolean checkPosition()
    {

        if ((pos.x - 8) % 16 == 0 && (pos.y - 8) % 16 == 0)
        {

            PVector matrixPosition = new PVector((pos.x - 8) / 16, (pos.y - 8) / 16);
            PVector positionToCheck = new PVector(matrixPosition.x + turnTo.x, matrixPosition.y + turnTo.y);

            if (tiles[floor(positionToCheck.y)][floor(positionToCheck.x)].wall)
            {
                return !tiles[floor(matrixPosition.y + vel.y)][floor(matrixPosition.x + vel.x)].wall;

            } else if
            ((pos.x+10*vel.x-8)%16 == 0 && (pos.y + 10*vel.y - 8)% 16 ==0)
            {
                    if (!tiles[floor(matrixPosition.y)][floor(matrixPosition.x)].eaten )
                    {
                        tiles[floor(matrixPosition.y)][floor(matrixPosition.x)].eaten = true;
                    }

            } else
            {
                vel = new PVector(turnTo.x, turnTo.y);
                return true;
            }
        }
        if (turnTo.x + vel.x == 0 && vel.y + turnTo.y == 0)
        {
            vel = new PVector(turnTo.x, turnTo.y);
            return true;
        }
        return true;
    }
}