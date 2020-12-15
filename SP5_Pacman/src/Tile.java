import processing.core.PVector;

public class Tile
{
        boolean wall = false;
        boolean dot = false;
        boolean bigDot = false;
        boolean eaten = false;
        PVector pos;

        Tile(float x, float y)
        {
                pos = new PVector(x, y);
        }
}
