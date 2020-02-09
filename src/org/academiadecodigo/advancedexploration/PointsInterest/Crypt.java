package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;

public class Crypt extends PointsInterest {

    public Crypt(int col, int row, Field field){
        super(col, row, field);
        reward = 100;
        penalty = 50;
        risk = 0.7;
    }

    @Override
    public void getExploreResult(Player player) {
       if (Math.random() < risk){
           player.setEnergy(-penalty);
           return;
       } player.setPoints(reward);

    }
}
