package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;

public class Pyramid extends PointsInterest {

    public Pyramid(){
        reward = 50;
        penalty = -25;
        risk = 0.5;
    }

    @Override
    public void getExploreResult(Player player) {
        if (Math.random() < risk){
            player.setEnergy(penalty);
            return;
        } player.setPoints(reward);
    }
}
