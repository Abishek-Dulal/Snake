package org.example;

import javafx.scene.input.KeyEvent;
import org.example.logic.GameManager;
import org.example.logic.snake.Snake;
import org.example.logic.stage.Stage;

public class SnakeApp extends GraphicApp{

    private GameManager gameManager;

    @Override
    protected void setup() {
        setKeyBoard();
        frames(10);
        gameManager = new GameManager();
    }

    private void setKeyBoard() {
        getStage().addEventHandler(KeyEvent.KEY_PRESSED,keyevent->{
            gameManager.setMove(keyevent.getCode().getChar());
        });
    }



    @Override
    protected void draw() {
        gameManager.draw(graphicsContext);
    }

}
