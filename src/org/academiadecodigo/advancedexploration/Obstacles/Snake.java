package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;

public class Snake extends Obstacle {


    public Snake(int col, int row, Field field){
        super(col, row, field);
        damage = 20;
        reward = damage*2;
    }

    @Override
    public void getFightResult(Player player) {
        player.setEnergy(-damage);
        player.setPoints(reward);
    }
}
