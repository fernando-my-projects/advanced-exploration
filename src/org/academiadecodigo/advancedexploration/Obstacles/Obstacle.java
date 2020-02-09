package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.Position;

public abstract class Obstacle implements Interactable {

    protected int damage;
    protected int reward;
    protected Position pos;

    public Obstacle(int col, int row, Field field){
        pos = new Position(col, row, field);
    }

    @Override
    public void interact(Player player) {
        getFightResult(player);
    }

    public abstract void getFightResult(Player player);

}
