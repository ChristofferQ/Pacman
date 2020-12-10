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
                        tiles[j][i].food = true;
                        break;
                    case 1:
                        tiles[j][i].wall = true;
                        break;
                    case 2:
                        tiles[j][i].dot = true;
                        break;
                }
            }
        }
    }

    public void draw()
    {
        image(img, 0, 0);
        this.showPacman(p);
        this.movePacman(p);
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

    public void showPacman(PApplet p)
    {
        fill(255, 255, 0);
        stroke(255, 255, 0);
        ellipse(pos.x, pos.y, 20, 20);
    }

    public void movePacman(PApplet p)
    {
        if (checkPosition())
        {
            pos.add(vel);
        }
    }

    public void showFood(PApplet p)
    {
        fill(255, 255, 0);
        noStroke();
        ellipse(pos.x, pos.y, 3, 3);
        System.out.println("x = " + pos.x + " " + "y = " + pos.y);

        //Problemet opstår i at maden kun bliver vist på Pacmans plads. Læg mærke til sout
    }


    public boolean checkPosition()
    {

        if ((pos.x - 8) % 16 == 0 && (pos.y - 8) % 16 == 0)
        {

            PVector matrixPosition = new PVector((pos.x - 8) / 16, (pos.y - 8) / 16);
            PVector positionToCheck = new PVector(matrixPosition.x + turnTo.x, matrixPosition.y + turnTo.y);

            if (tiles[floor(positionToCheck.y)][floor(positionToCheck.x)].wall)
            {
                if (tiles[floor(matrixPosition.y + vel.y)][floor(matrixPosition.x + vel.x)].wall)
                {
                    return false;
                } else
                {
                    return true;
                }
            } else
            {
                vel = new PVector(turnTo.x, turnTo.y);
                return true;
            }
        } else
        {
            if ((pos.x + 10 * vel.x - 8) % 16 == 0 && (pos.y + 10 * vel.y - 8) % 16 == 0)
            {
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