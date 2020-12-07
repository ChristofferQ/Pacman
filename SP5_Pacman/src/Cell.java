import processing.core.PApplet;

public class Cell extends PApplet {
    float x;
    float y;
    float w;
    float h;

    public Cell(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void display(){
        stroke(0);
        fill(255);
        rect(x,y,w,h);
    }
}
