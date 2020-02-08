package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;

public class Nazi extends Obstacle {

    public Nazi(){
        damage = 40;
        reward = 30;
    }


    @Override
    public void getFightResult(Player player) {
        player.setEnergy(-damage);
        player.setEnergy(reward);
    }
}
