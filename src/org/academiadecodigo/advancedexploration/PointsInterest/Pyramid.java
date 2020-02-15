package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.printRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pyramid extends PointsInterest {

    public Pyramid(int col, int row, Field field){
        super(col, row, field);
        picInit();
        reward = 50;
        penalty = 25;
        risk = 0.5;
    }

    @Override
    public void getExploreResult(Player player) {
        if (Math.random() < risk){
            player.setEnergy(-penalty);
            printRunTimeInfo.print("You got unlucky... You lost " + penalty + " Energy... You got +" + reward + " points.");
            return;
        }
        printRunTimeInfo.print("You got +" + reward + " points.");
        player.setPoints(reward);
    }

    @Override
    public void picInit() {
        rect = new Rectangle(PADDING + pos.getX(), PADDING + pos.getY(), cellSize, cellSize);
        rect.setColor(Color.GREEN);
    }

    @Override
    public void draw() {
        rect.fill();
    }

    @Override
    public void erase() {
        rect.delete();
    }
}
