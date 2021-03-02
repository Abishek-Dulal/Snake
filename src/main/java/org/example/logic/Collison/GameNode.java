package org.example.logic.Collison;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameNode {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public GameNode(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillRect(x,y,width,height);
    }

    public BoundRect getBoundRect(){
        BoundPoint a = new BoundPoint(x,y);
        BoundPoint b = new BoundPoint(x+width,y);
        BoundPoint c = new BoundPoint(x+width,y+height);
        BoundPoint d = new BoundPoint(x,y+height);
        return new BoundRect(a,b,c,d);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
