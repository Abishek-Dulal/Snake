package org.example.logic.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.logic.Collison.GameNode;
import org.example.logic.NodeDirection;

public class SnakeNode extends GameNode {

    private NodeDirection nodeDirection;

    public SnakeNode(int x, int y, int width, int height, NodeDirection nodeDirection) {
        super(x, y, width, height);
        this.nodeDirection = nodeDirection;
    }

    public void draw(GraphicsContext graphicsContext) {
       graphicsContext.setFill(Color.PURPLE);
       graphicsContext.fillRect(x,y,width,height);
    }


    public NodeDirection getNodeDirection() {
        return nodeDirection;
    }

    public void setNodeDirection(NodeDirection nodeDirection) {
        this.nodeDirection = nodeDirection;
    }

    public void move(){
        switch (this.getNodeDirection()){
            case UP: {
               y= -this.width+this.y;
                break;
            }
            case DOWN:{
                y=this.width+this.y;
                break;
            }
            case RIGHT:{
                x=this.height+x;
                break;
            }
            case LEFT:{
                x=-this.height+x;
                break;
            }
        }

    }

}
