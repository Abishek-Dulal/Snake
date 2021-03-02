package org.example.logic.stage;

import javafx.scene.canvas.GraphicsContext;
import org.example.logic.Collison.BoundRect;

import java.util.ArrayList;
import java.util.List;

public class Stage {

    private List<StageNode> stageNodes;

    public Stage() {
        this.stageNodes = new ArrayList<>();
        addStageData();
    }

    public void draw(GraphicsContext graphicsContext){
        for(var stageNode:stageNodes){
            stageNode.draw(graphicsContext);
        }
    }

    private void addStageData(){
        StageNode  leftwall = new StageNode( 0,0,50,750);
        StageNode  rightwall = new StageNode(550,0,50,750);
        StageNode  upwall = new StageNode(0,0,750,50);
        StageNode   downwall = new StageNode(0,550,750,50);
        stageNodes.add(leftwall);
        stageNodes.add(rightwall);
        stageNodes.add(upwall);
        stageNodes.add(downwall);
    }

    public List<BoundRect> getBoundRect(){
        List<BoundRect> boundRects  = new ArrayList<>();
        for (var stageNode:stageNodes){
            boundRects.add(stageNode.getBoundRect());
        }
        return  boundRects;
    }

}
