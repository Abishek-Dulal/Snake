package org.example.logic;

import javafx.scene.canvas.GraphicsContext;
import org.example.logic.Collison.BoundRect;
import org.example.logic.Friut.FruitGenerator;
import org.example.logic.Friut.FruitNode;
import org.example.logic.snake.Snake;
import org.example.logic.stage.Stage;

public class GameManager {

    private Snake snake;
    private Stage stage;
    private FruitGenerator fruitGenerator;
    private FruitNode fruitNode;

    public GameManager() {
        snake = new Snake();
        stage = new Stage();
        fruitGenerator = new FruitGenerator(550,50);
        fruitNode = fruitGenerator.generateFriut();
    }

    public void setMove(String code) {
        switch (code){
            case "A":{
                snake.moveLeft();
                break;
            }
            case "W":{
                snake.moveUp();
                break;
            }
            case "S":{
                snake.moveDown();
                break;
            }
            case "D":{
                snake.moveRight();
                break;
            }
            case "H":{

            }
        }
    }


    public void draw(GraphicsContext graphicsContext) {
        stage.draw(graphicsContext);
        if (!snake.hasEatenItsOwnBody() &&  !checkCollison()){
            snake.draw(graphicsContext);
        }
        if(fruitisEaten()){
            snake.grow();
           fruitNode= fruitGenerator.generateFriut();
        }

        fruitNode.draw(graphicsContext);
    }

    public boolean  checkCollison(){
        BoundRect snakeBounds = snake.getBounds();
        for(var wallBound:stage.getBoundRect()){
            if(snakeBounds.isInside(wallBound)){
                return true;
            }
        }
        return false;
    }

    public boolean fruitisEaten(){
        BoundRect snakeBounds = snake.getBounds();
       return snakeBounds.isInside(fruitNode.getBoundRect());
    }


}
