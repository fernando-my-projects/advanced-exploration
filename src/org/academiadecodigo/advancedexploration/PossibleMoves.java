package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Entities.Rock;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PossibleMoves {

    private FieldPosition posToCompare;
    private Rock[] rocks;
    private Field field;
    private Player player;
    private int cellSize;
    private Rectangle up, down, left, right;
    private boolean upIsDrawn, downIsDrawn, leftIsDrawn, rightIsDrawn;

    public PossibleMoves(Rock[] rocks, Field field, Player player){
        this.field = field;
        this.rocks = rocks;
        this.player = player;
        cellSize = field.getCellSize();
    }

    public boolean checkRight(){

        if (player.getPos().getCol() == (field.getWidth() - 1)){
            return false;
        }
        //create position at player right
        posToCompare = new FieldPosition(player.getPos().getCol() + 1, player.getPos().getRow());

        for (Rock rock : rocks) {

            if(rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }

    public boolean checkLeft(){

        if (player.getPos().getCol() == 0){
            return false;
        }
        //create position at player left
        posToCompare = new FieldPosition(player.getPos().getCol() - 1, player.getPos().getRow());

        for (Rock rock : rocks) {

            if (rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }

    public boolean checkUp(){

        if (player.getPos().getRow() == 0){
            return false;
        }
        //create position above player
        posToCompare = new FieldPosition(player.getPos().getCol(), player.getPos().getRow() - 1);

        for (Rock rock : rocks) {

            if (rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }

    public boolean checkDown(){

        if (player.getPos().getRow() == (field.getHeight() - 2)){
            return false;
        }
        //create position above player
        posToCompare = new FieldPosition(player.getPos().getCol(), player.getPos().getRow() + 1);

        for (Rock rock : rocks) {

            if (rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }

    public void drawAll(){
        if (checkUp()){
            drawUp();
            upIsDrawn = true;
        }

        if (checkDown()){
            drawDown();
            downIsDrawn = true;
        }

        if (checkLeft()){
            drawLeft();
            leftIsDrawn = true;
        }

        if (checkRight()){
            drawRight();
            rightIsDrawn = true;
        }
    }

    public void hideAll(){
        if (upIsDrawn){
            hideUp();
            upIsDrawn = false;
        }
        if (downIsDrawn){
            hideDown();
            downIsDrawn = false;
        }
        if (leftIsDrawn){
            hideLeft();
            leftIsDrawn = false;
        }
        if (rightIsDrawn){
            hideRight();
            rightIsDrawn = false;
        }
    }


    public void drawUp(){
        up = new Rectangle(field.PADDING + player.getPos().getX(), field.PADDING + player.getPos().getY() - cellSize, cellSize, cellSize);
        up.setColor(Color.GREEN);
        up.draw();
    }

    public void hideUp(){
        up.delete();
    }

    public void drawDown(){
        down = new Rectangle(field.PADDING + player.getPos().getX(), field.PADDING + player.getPos().getY() + cellSize, cellSize, cellSize);
        down.setColor(Color.GREEN);
        down.draw();
    }

    public void hideDown(){
        down.delete();
    }

    public void drawLeft(){
        left = new Rectangle(field.PADDING + player.getPos().getX() - cellSize, field.PADDING + player.getPos().getY(), cellSize, cellSize);
        left.setColor(Color.GREEN);
        left.draw();
    }

    public void hideLeft(){
        left.delete();
    }

    public void drawRight(){
        right = new Rectangle(field.PADDING + player.getPos().getX() + cellSize, field.PADDING + player.getPos().getY(), cellSize, cellSize);
        right.setColor(Color.GREEN);
        right.draw();
    }

    public void hideRight(){
        right.delete();
    }




}
