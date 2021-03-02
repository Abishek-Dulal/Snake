package org.example.logic.snake;
import javafx.scene.canvas.GraphicsContext;
import org.example.logic.Collison.BoundRect;
import org.example.logic.NodeDirection;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeNode> snakeNodes;
    private SnakeNode headNode;
    private SnakeNode tailNode;

    public Snake() {
        this.snakeNodes =new ArrayList<>();
        var snakeNode = new SnakeNode(          100,100,20,20, NodeDirection.RIGHT);
        this.snakeNodes.add(snakeNode);
        this.headNode = snakeNode;
        this.tailNode =snakeNode;
        grow();
        grow();
        grow();
        grow();
        grow();
    }

    public void draw(GraphicsContext graphicsContext) {
        for (var snakeNode :snakeNodes){
            snakeNode.draw(graphicsContext);
        }
        move();
    }

    public void grow(){
        int nodeXPosition;
        int nodeYPosition;
        switch (tailNode.getNodeDirection()) {
            case LEFT: {
                nodeXPosition = tailNode.getX()+tailNode.getWidth();
                nodeYPosition = tailNode.getY();
                break;
            }
            case RIGHT: {
                nodeXPosition = tailNode.getX()- tailNode.getWidth();
                nodeYPosition = tailNode.getY();
                break;
            }
            case DOWN: {
                nodeXPosition = tailNode.getX();
                nodeYPosition = tailNode.getY()-tailNode.getHeight();
                break;
            }
            case UP: {
                nodeXPosition = tailNode.getX();
                nodeYPosition = tailNode.getY()+tailNode.getHeight();;
                break;
            }
            default:{
                nodeXPosition=0;
                nodeYPosition=0;
            }

        }
        var snakeNode = new SnakeNode(nodeXPosition, nodeYPosition, 20, 20, tailNode.getNodeDirection());
        snakeNodes.add(snakeNode);
        tailNode = snakeNode;

    }

    public void move(){
        var frontNodeDirection = headNode.getNodeDirection();
        for(var snakeNode : snakeNodes){
            var curNodeDirection = snakeNode.getNodeDirection();
            snakeNode.move();
            snakeNode.setNodeDirection(frontNodeDirection);
            frontNodeDirection = curNodeDirection;
        }
    }

    public void moveLeft() {
        moveOnPreCondition(NodeDirection.LEFT,NodeDirection.RIGHT);
    }

    public void moveUp() {
        moveOnPreCondition(NodeDirection.UP,NodeDirection.DOWN);
    }

    public void moveRight(){
        moveOnPreCondition(NodeDirection.RIGHT,NodeDirection.LEFT);
    }

    public void moveDown(){
        moveOnPreCondition(NodeDirection.DOWN,NodeDirection.UP);
    }

    private void moveOnPreCondition(NodeDirection moveDirection,NodeDirection blockDirection ){
        if(headNode.getNodeDirection()!=blockDirection){
            headNode.setNodeDirection(moveDirection);
        }
    }

    public boolean hasEatenItsOwnBody(){
        BoundRect boundRect = headNode.getBoundRect();
        for (int i = 3; i < snakeNodes.size(); i++) {
            SnakeNode snakeNode = snakeNodes.get(i);
                if (boundRect.isInside(snakeNode.getBoundRect())) {
                    return true;
                }
        }
        return false;
    }


    public BoundRect getBounds() {
        return headNode.getBoundRect();
    }
}