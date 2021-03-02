package org.example.logic.Friut;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.logic.Collison.BoundPoint;
import org.example.logic.Collison.BoundRect;
import org.example.logic.Collison.GameNode;

public class FruitNode extends GameNode {

    public FruitNode(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    public void draw(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillRect(x,y,width,height);
    }


}
