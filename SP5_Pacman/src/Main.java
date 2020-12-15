import processing.core.PApplet;

public class Main
{

    public static void main(String[] args)
    {
            String[] processingArgs = {"Main"};
            Pacman mySketch = new Pacman();
            PApplet.runSketch(processingArgs, mySketch);
    }
}