package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;

public class Nazi extends Obstacle {

    public Nazi(int col, int row, Field field){
        super(col, row, field);
        damage = 40;
        reward = damage*2;
    }

    @Override
    public void getFightResult(Player player) {
        player.setEnergy(-damage);
        player.setEnergy(reward);
    }
}
