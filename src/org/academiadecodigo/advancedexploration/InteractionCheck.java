package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Items.Item;
import org.academiadecodigo.advancedexploration.Obstacles.Obstacle;
import org.academiadecodigo.advancedexploration.PointsInterest.PointsInterest;

public class InteractionCheck {


    public boolean checkPointsInterest (Player player, PointsInterest pointsInterest) {

        if (player.getPos().equals(pointsInterest.getPos())) {
            return true;
        }
        return false;

    }

    public boolean checkObstacles (Player player, Obstacle obstacle) {

        if (player.getPos().equals(obstacle.getPos())) {
            return true;
        }
        return false;

    }

    public boolean checkItem (Player player, Item item) {

        if (player.getPos().equals(item.getPos())) {
            return true;
        }
        return false;

    }
}
