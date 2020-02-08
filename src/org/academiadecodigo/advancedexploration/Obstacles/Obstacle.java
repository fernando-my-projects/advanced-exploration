package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Position;

public abstract class Obstacle {

    protected int damage;
    protected int reward;
    protected Position pos;

    public Obstacle(){
        pos = new Position();
    }

    public abstract void getFightResult(Player player);

}
