package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.printRunTimeInfo;

public class Pyramid extends PointsInterest {

    public Pyramid(int col, int row, Field field){
        super(col, row, field);
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
}
