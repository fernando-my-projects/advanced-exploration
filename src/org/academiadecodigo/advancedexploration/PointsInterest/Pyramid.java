package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;

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
            return;
        } player.setPoints(reward);
    }
}
