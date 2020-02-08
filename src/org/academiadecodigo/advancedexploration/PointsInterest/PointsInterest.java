package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Position;

public abstract class PointsInterest {

    protected int reward;
    protected int penalty;
    protected double risk;
    private Position pos;

    public PointsInterest (){

        pos = new Position();
    }

    public abstract void getExploreResult(Player player);


}
