package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.HolyGrail;
import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Entities.Rock;
import org.academiadecodigo.advancedexploration.Items.Hat;
import org.academiadecodigo.advancedexploration.Items.Item;
import org.academiadecodigo.advancedexploration.Items.Whip;
import org.academiadecodigo.advancedexploration.Obstacles.Nazi;
import org.academiadecodigo.advancedexploration.Obstacles.Obstacle;
import org.academiadecodigo.advancedexploration.Obstacles.Snake;
import org.academiadecodigo.advancedexploration.PointsInterest.Crypt;
import org.academiadecodigo.advancedexploration.PointsInterest.PointsInterest;
import org.academiadecodigo.advancedexploration.PointsInterest.Pyramid;
import org.academiadecodigo.advancedexploration.graphics.Color;
import org.academiadecodigo.advancedexploration.graphics.Rectangle;
import org.academiadecodigo.advancedexploration.graphics.Text;
import org.academiadecodigo.advancedexploration.keyboard.Keyboard;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardEvent;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardEventType;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardHandler;

public class Game {

    private Field field;
    private Rectangle grid;
    private Rock[] rocks;
    private Player player;
    private Interactable grail;
    private Interactable[] pointsInterest;
    private Interactable[] obstacles;
    private Interactable[] items;
    private Rectangle rect;
    private boolean gameOver;
    private Text score;


    public Game (int cols, int rows){
        field = new Field(cols, rows);
        rocks = new Rock[16];
        pointsInterest = new PointsInterest[2];
        obstacles = new Obstacle[2];
        items = new Item[2];
    }

    public void init(){
        field.init();
        makeRocks();
        makePlayer();
        makeGrail();
        makeItems();
        makeObstacles();
        makePIs();
        printEntities();
        keyboardPresses();
        score = new Text(435, 510, ""+player.getPoints());
        score.draw();
    }

    public void start() {
        gameOver = false;
        init();
        while (!gameOver) {
            interactionChecker();
            printScore();
        }
        endGame();

        //End Screen here
    }

    public void printScore(){
        //Prints Score: => int score
        //score.delete();
        //score = new Text(435, 510, ""+player.getPoints());
        score.setText(""+player.getPoints());
        score.draw();
    }

    public void printRocks() {
        for (Rock r : rocks) {
            rect = new Rectangle(r.getPos().getX() + field.PADDING, r.getPos().getY() + field.PADDING, field.getCellSize(), field.getCellSize());
            rect.setColor(Color.MAGENTA);
            rect.fill();
        }
    }

    public void printPIs(){
        for (Interactable pi : pointsInterest) {
            Rectangle r = new Rectangle(pi.getPos().getX() + field.PADDING, pi.getPos().getY() + field.PADDING, field.getCellSize(), field.getCellSize());
            r.fill();
            r.setColor(Color.ORANGE);
        }
    }

    public void printObstacles(){
        for (Interactable obstacle : obstacles) {
            Rectangle r = new Rectangle(obstacle.getPos().getX() + field.PADDING, obstacle.getPos().getY() + field.PADDING, field.getCellSize(), field.getCellSize());
            r.fill();
            r.setColor(Color.BLACK);
        }
    }

    public void printItems(){
        for (Interactable item : items) {
            Rectangle r = new Rectangle(item.getPos().getX() + field.PADDING, item.getPos().getY() + field.PADDING, field.getCellSize(), field.getCellSize());
            r.fill();
            r.setColor(Color.RED);
        }
    }

    public void printGrail(){
        Rectangle r = new Rectangle(grail.getPos().getX() + field.PADDING, grail.getPos().getY() + field.PADDING, field.getCellSize(), field.getCellSize());
        r.fill();
        r.setColor(Color.LIGHT_GRAY);
    }

    public void printEntities() {
        printRocks();
        printPIs();
        printObstacles();
        printItems();
        printGrail();
    }

    public void makeRocks(){

        rocks[0] = new Rock(1,0,field);
        rocks[1] = new Rock(1,1,field);
        rocks[2] = new Rock(2,1,field);
        rocks[3] = new Rock(3,1, field);
        rocks[4] = new Rock(4,1,field);
        rocks[5] = new Rock(6,0,field);
        rocks[6] = new Rock (6, 1,field);
        rocks[7] = new Rock (3 , 4,field);
        rocks[8] = new Rock (4, 4,field);
        rocks[9] = new Rock (5, 4,field);
        rocks[10] = new Rock (4, 5,field);
        rocks[11] = new Rock (4, 6,field);
        rocks[12] = new Rock (4, 7,field);
        rocks[13] = new Rock (4, 8,field);
        rocks[14] = new Rock (3, 8,field);
        rocks[15] = new Rock (5, 8,field);
    }

    public Rock[] getRocks() {
        return rocks;
    }

    public Field getField() {
        return field;
    }

    public Player getPlayer() {
        return player;
    }

    public void makePlayer(){
        player = new Player(4,9, field);
    }

    public void makeGrail(){
        grail = new HolyGrail(2,0, field);
    }

    public void makePIs(){
        pointsInterest[0] = new Crypt(6,3, field);
        pointsInterest[1] = new Pyramid(1, 6, field);
    }

    public void makeObstacles(){
        obstacles[0] = new Nazi(5,2, field);
        obstacles[1] = new Snake(2, 7, field);
    }

    public void makeItems(){
        items[0] = new Whip(7, 5, field);
        items[1] = new Hat(2, 3, field);
    }

    public void interactionChecker(){

        for (Interactable pi : pointsInterest) {
            if (player.getPos().equals(pi.getPos()) && !player.getScoreNotUpdated()){
                pi.interact(player);
                printScore();
                player.setScoreNotUpdated(true);
                return;
            }
        }

        for (Interactable obs : obstacles){
            if (player.getPos().equals(obs.getPos()) && !player.getScoreNotUpdated()){
                obs.interact(player);
                printScore();
                player.setScoreNotUpdated(true);
                return;
            }
        }

        for (Interactable item : items){
            if (player.getPos().equals(item.getPos()) && !player.getScoreNotUpdated()){
                item.interact(player);
                printScore();
                player.setScoreNotUpdated(true);
                return;
            }
        }

        if (player.getPos().equals(grail.getPos()) && !player.getScoreNotUpdated()){
            grail.interact(player);
            gameOver = true;
            printScore();
            return;
        }
    }

    public void endGame(){
        field.setClear();
        score = new Text(150, 250, "The End. \nYour score was: "+player.getPoints());
        score.setColor(Color.BLACK);
        score.draw();
    }

    public void keyboardPresses(){
        KeyboardHandler playerMoves = new PlayerMoves(getRocks(), getField(), getPlayer());
        Keyboard k = new Keyboard(playerMoves);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventRight);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventLeft);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventUp);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventDown);
    }



}
