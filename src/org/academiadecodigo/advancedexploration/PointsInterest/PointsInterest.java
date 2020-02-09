package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.Position;

public abstract class PointsInterest implements Interactable {

    protected int reward;
    protected int penalty;
    protected double risk;
    private Position pos;

    public PointsInterest (int col, int row, Field field){

        pos = new Position(col, row, field);
    }

    @Override
    public void interact(Player player) {
        getExploreResult(player);
    }

    public abstract void getExploreResult(Player player);


}
