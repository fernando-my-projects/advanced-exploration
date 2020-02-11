package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.HolyGrail;
import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Items.Item;
import org.academiadecodigo.advancedexploration.Obstacles.Obstacle;
import org.academiadecodigo.advancedexploration.PointsInterest.PointsInterest;

public class InteractionCheck {


    public boolean checkPointsInterest (Player player, PointsInterest pointsInterest) {

        return player.getPos().equals(pointsInterest.getPos());
    }

    public boolean checkObstacles (Player player, Obstacle obstacle) {

        return player.getPos().equals(obstacle.getPos());
    }

    public boolean checkItem (Player player, Item item) {

        return player.getPos().equals(item.getPos());
    }

    public boolean checkGrail (Player player, HolyGrail grail){

        return player.getPos().equals(grail.getPos());
    }

}
