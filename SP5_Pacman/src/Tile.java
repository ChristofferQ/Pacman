import processing.core.PApplet;
import processing.core.PVector;

public class Tile extends PApplet
{
        boolean wall = false;
        boolean dot = false;
        boolean food = false;
        boolean eaten = false;
        PVector pos;

        Tile(float x, float y) {
            pos = new PVector(x, y);
        }
}
