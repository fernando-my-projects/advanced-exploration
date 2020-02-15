package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

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
            PrintRunTimeInfo.print("You entered in a Pyramid. You lost -" + penalty + " Energy...");
            return;
        }

        player.setPoints(reward);
        PrintRunTimeInfo.print("You entered in a Pyramid. You won +" + reward + " points.");


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
