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
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

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
    private Text energy;
    private Text pickedUpItems;

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
        initializeTexts();
    }

    private void initializeTexts() {
        score = new Text(435, 510, ""+player.getPoints());
        score.draw();
        energy = new Text(435, 480, ""+player.getEnergy());
        energy.draw();
        pickedUpItems = new Text(20, 520, "You haven't picked up anything yet.");
        pickedUpItems.draw();
    }

    public void start() {
        gameOver = false;
        welcomeScreen();
        init();
        while (!gameOver && (player.getEnergy() >= 0) && (player.getPoints() >= 0)) {
            interactionChecker();
            printScores();
        }
        endGame();
    }

    private void welcomeScreen() {
        field.init();
        Text title = new Text (100, 150, "Welcome to the game stuff cenas game name here");
        Text welcome = new Text (70, 200, "TUTORIAL: Bla bla. Edit this. You lose points on X Y Z, you win on A B C");
        Text timer = new Text(470, 520, "9");
        title.setColor(Color.BLUE);
        timer.setColor(new Color(24, 199, 62));
        title.draw();
        welcome.draw();
        timer.draw();
        timer.grow(16, 23);

        //10 secs counter
        for(int time = 9; time >= 0; time--) {
            sleep(1000);
            timer.setText(""+time);
        }

        title.delete();
        welcome.delete();
        timer.delete();
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printScores(){
        score.setText("Points: "+player.getPoints());
        score.draw();
        energy.setText("Energy: "+player.getEnergy());
        energy.draw();

        if (player.hasHat() || player.hasWhip()) {
            String returnStr = "You have picked up: ";
            if (player.hasHat()) {
                returnStr+="Hat. ";
            }
            if (player.hasWhip()) {
                returnStr += "Whip. ";
            }

            pickedUpItems.setText(returnStr);
        }
    }

    public void printRocks() {
        for (Rock r : rocks) {
            r.draw();
        }
    }

    public void printPIs(){
        for (Interactable pi : pointsInterest) {
            pi.draw();
        }
    }

    public void printObstacles(){
        for (Interactable obstacle : obstacles) {
            obstacle.draw();
        }
    }

    public void printItems(){
        for (Interactable item : items) {
            item.draw();
        }
    }

    public void printGrail(){
        grail.draw();
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
                printScores();
                player.setScoreNotUpdated(true);
                return;
            }
        }

        for (Interactable obs : obstacles){
            if (player.getPos().equals(obs.getPos()) && !player.getScoreNotUpdated()){
                obs.interact(player);
                obs.erase();
                printScores();
                player.setScoreNotUpdated(true);
                return;
            }
        }

        for (Interactable item : items){
            if (player.getPos().equals(item.getPos()) && !player.getScoreNotUpdated()){
                item.interact(player);
                item.erase();
                printScores();
                player.setScoreNotUpdated(true);
                return;
            }
        }

        if (player.getPos().equals(grail.getPos()) && !player.getScoreNotUpdated()){
            grail.interact(player);
            gameOver = true;
            printScores();
            return;
        }
    }

    public void endGame(){
        field.setClear();
        String scoreString = "The End. Your Score was: " + player.getPoints();
        String energyString = "Your Remaining Energy was: " + player.getEnergy();

        if (player.getEnergy() <= 0) {
            player.setToZero();
            energyString = "You Ran Out of Energy: " + player.getEnergy();

        }
        if (player.getPoints() < 0) {
            scoreString = "You Ran Out of Points! (" + player.getPoints() + ")";
        }
        score = new Text(150, 250, scoreString);
        score.setColor(Color.BLACK);
        score.draw();
        energy = new Text(150, 300, energyString);
        energy.setColor(Color.BLACK);
        energy.draw();

    }

    public void keyboardPresses(){
        PlayerMoves playerMoves = new PlayerMoves(getRocks(), getField(), getPlayer());
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
