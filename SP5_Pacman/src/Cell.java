import processing.core.PApplet;

public class Cell{
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

    public void display(PApplet p){
        p.stroke(0);
        p.fill(255);
        p.rect(x,y,w,h);
    }
}
