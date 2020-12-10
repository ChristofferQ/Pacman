import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Main
{

    public static void main(String[] args)
    {
            String[] processingArgs = {"Main"};
            Pacman mySketch = new Pacman();
            PApplet.runSketch(processingArgs, mySketch);
    }
}