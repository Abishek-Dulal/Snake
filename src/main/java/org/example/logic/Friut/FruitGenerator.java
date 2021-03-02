package org.example.logic.Friut;

import java.util.Random;

public class FruitGenerator {

    private Random random;

    private int maxBound;
    private int minBound;


    public FruitGenerator(int maxBound, int minBound) {
        random = new Random();
        this.maxBound = maxBound;
        this.minBound = minBound;
    }

    public FruitNode generateFriut(){
        int x = minBound+random.nextInt(maxBound - 2 * minBound);
        int y = minBound+ random.nextInt(maxBound- 2 * minBound);
        return new FruitNode(x,y,20, 20);
    }




}
