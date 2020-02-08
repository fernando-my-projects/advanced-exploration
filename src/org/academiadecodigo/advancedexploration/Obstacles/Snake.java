package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;

public class Snake extends Obstacle {


    public Snake(){
        damage = 20;
        reward = 10;
    }


    @Override
    public void getFightResult(Player player) {
        player.setEnergy(-damage);
        player.setPoints(reward);
    }
}
