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
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Game {

    private Field field;
    private Rectangle grid;
    private Rock[] rocks;
    private Player player;
    private Interactable grail;
    private Interactable[] interactables;
    private Rectangle rect;
    private PossibleMoves possibleMoves;
    private boolean gameOver;
    private boolean gameWon;
    private Text score;
    private Text energy;
    private Text victory;
    private Text lose;
    private Text pickedUpItems;
    private Text highScore;
    private File audioFile;
    private Clip audioClipIntro;
    private int highScoreValue;

    public Game (int cols, int rows){
        field = new Field(cols, rows);
        rocks = new Rock[16];
        interactables = new Interactable[6];
    }

    public void init(){
        field.init();
        makeRocks();
        makePlayer();
        makeGrail();
        makeInteractables();
        possibleMoves = new PossibleMoves(rocks, field, player);
        printEntities();
        keyboardPresses();
        initializeTexts();
    }

    private void initializeTexts() {

        score = new Text(400, 517, ""+player.getPoints());
        score.setColor(Color.WHITE);
        score.draw();
        energy = new Text(400, 530, ""+player.getEnergy());
        energy.setColor(Color.WHITE);
        energy.draw();
        pickedUpItems = new Text(40, 525, "You haven't picked up anything yet.");
        pickedUpItems.setColor(Color.WHITE);
        pickedUpItems.draw();
        highScore = new Text(400, 70, "Highscore: "+HighScore.load());
        highScore.setColor(Color.BLACK);
        highScore.draw();
    }

    public void start() {
        playMusic();
        gameOver = false;
        gameWon = false;
        welcomeScreen();
        init();

        while (true) {
            player.setHasMoved(false);
            possibleMoves.drawAll();
            interactionChecker();
            printScores();
            if (gameOver || player.getEnergy() <= 0){
                break;
            }
            sleep(500);
            possibleMoves.hideAll();
        }
        endGame();
        audioClipIntro.close();
        //audioStream.close()

    }

    private void welcomeScreen() {
        field.init();
        //___________________________________________
        Picture intro = new Picture(0,0, "resources/images/introImage2.png");
        intro.draw();
        Text timer2 = new Text(470, 533, "4");
        for(int time = 4; time >= 0; time--) {
            sleep(1000);
            timer2.setText(""+time);
        }
        intro.delete();
        timer2.delete();
        //____________________________________________
        /*Text title = new Text (80, 50, "Indiana Jones and the Last Cruzade");*/
        Text welcome = new Text (80, 70, "TUTORIAL:");
        Text timer = new Text(470, 533, "9");
        /*title.setColor(Color.BLUE);*/
        timer.setColor(Color.WHITE);
        /*title.draw();*/
        welcome.draw();
        timer.draw();
        timer.grow(10, 15);
        field.logo();

        Picture snake = new Picture (80, 90, "resources/images/snake.png");
        snake.draw();
        Picture pyramid = new Picture (80, 150, "resources/images/pyramid.png");
        pyramid.draw();
        Picture crypt = new Picture(80, 210, "resources/images/crypt.png");
        crypt.draw();
        Picture nazi = new Picture(80, 270, "resources/images/nazi-hitler.PNG");
        nazi.draw();
        Picture hat = new Picture(80, 330, "resources/images/hat.png");
        hat.draw();
        Picture whip = new Picture(80, 390, "resources/images/whip.png");
        whip.draw();
        Picture holyGrail = new Picture(80, 450, "resources/images/holyGrail.png");
        holyGrail.draw();

        Text snakeT = new Text(140, 110, "Snake: +40 Points / -20 Energy");
        snakeT.draw();
        Text pyramidT = new Text(140, 170, "Pyramid: +50 Points / 50% chance of -25 Energy");
        pyramidT.draw();
        Text cryptT = new Text(140, 230, "Crypt: +100 Points / 70% chance of -50 Energy");
        cryptT.draw();
        Text naziT = new Text(140, 290, "Nazi: +80 Points / -40 Energy");
        naziT.draw();
        Text hatT = new Text(140, 350, "Hat (Wearable Item)");
        hatT.draw();
        Text whipT = new Text(140, 410, "Whip (Wearable Item)");
        whipT.draw();
        Text holyGrailT = new Text(140, 470, "Holy Grail: +200 Points. Ending Point.");
        holyGrailT.draw();

        //10 secs counter
        for(int time = 9; time >= 0; time--) {
            sleep(1000);
            timer.setText(""+time);
        }

        //title.delete();
        welcome.delete();
        timer.delete();
        snake.delete();
        pyramid.delete();
        crypt.delete();
        nazi.delete();
        hat.delete();
        whip.delete();
        holyGrail.delete();
        snakeT.delete();
        pyramidT.delete();
        cryptT.delete();
        naziT.delete();
        hatT.delete();
        whipT.delete();
        holyGrailT.delete();
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

        /*if (player.hasHat() || player.hasWhip()) {
            String returnStr = "You have picked up: ";
            if (player.hasHat()) {
                returnStr+="Hat. ";
            }
            if (player.hasWhip()) {
                returnStr += "Whip. ";
            }

            pickedUpItems.setText(returnStr);
        }*/
    }

    public void printRocks() {
        for (Rock r : rocks) {
            r.draw();
        }
    }

    public void printInteractables(){
        for (Interactable inter : interactables){
            inter.draw();
        }
    }

    public void printGrail(){
        grail.draw();
    }

    public void printEntities() {
        printRocks();
        printInteractables();
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

    public void makeInteractables(){
        interactables[0] = new Crypt(7,3, field);
        interactables[1] = new Pyramid(1, 5, field);
        interactables[2] = new Nazi(5,2, field);
        interactables[3] = new Snake(2, 7, field);
        interactables[4] = new Whip(7, 6, field);
        interactables[5] = new Hat(2, 3, field);
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

    public boolean getGameOver(){
        return gameOver;
    }

    public void makePlayer(){
        player = new Player(4,9, field);
    }

    public void makeGrail(){
        grail = new HolyGrail(2,0, field);
    }

    public void interactionChecker(){

        for (Interactable inter : interactables){

            if (player.getPos().equals(inter.getPos()) && !player.getScoreNotUpdated() && !inter.hasInteracted()){
                pickedUpItems.delete();
                inter.interact(player);
                player.setScoreNotUpdated(true);
                return;
            }
        }

        if (player.getPos().equals(grail.getPos()) && !player.getScoreNotUpdated()){
            pickedUpItems.delete();
            grail.interact(player);
            gameOver = true;
            gameWon = true;
            printScores();
        }
    }

    public void endGame(){
        audioClipIntro.close();
        field.setClear();
        field.finalImage();
        field.logo();
        String scoreString = "Your Score was: " + player.getPoints();
        String energyString = "Your Remaining Energy was: " + player.getEnergy();
        String victoryString = "";
        String loseString = "";

        if(HighScore.load() < player.getPoints()) {
            scoreString+= ". You also set a new Highscore!";
        }

        if (player.getEnergy() <= 0) {
            player.setToZero();
            loseString = "You lost the game....";
            energyString = "You Ran Out of Energy: " + player.getEnergy();

        }
        /*if (player.getPoints() < 0) {
            scoreString = "You Ran Out of Points! (" + player.getPoints() + ")";
        }*/
        if (gameWon) {
            victoryString = "Congratulations! You won the game!";
        }


        /*lose = new Text(150, 200, loseString);
        lose.setColor(Color.WHITE);
        lose.grow(70,25);
        lose.draw();
        victory = new Text(150, 150, victoryString);
        victory.setColor(Color.WHITE);
        victory.grow(70,25);
        victory.draw();
        energy = new Text(150, 250, energyString);
        energy.setColor(Color.WHITE);
        energy.grow(70,25);
        energy.draw();*/
        score = new Text(150, 150, scoreString);
        score.setColor(Color.WHITE);
        score.grow(70,25);
        score.draw();

        lose = new Text(150, 250, loseString);
        lose.setColor(Color.WHITE);
        lose.grow(70,25);
        lose.draw();

        victory = new Text(150, 250, victoryString);
        victory.setColor(Color.WHITE);
        victory.grow(70,25);
        victory.draw();

        energy = new Text(150, 350, energyString);
        energy.setColor(Color.WHITE);
        energy.grow(70,25);
        energy.draw();

        HighScore.save(player.getPoints());
    }

    public void keyboardPresses(){
        PlayerMoves playerMoves = new PlayerMoves(possibleMoves, this);
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

        KeyboardEvent eventQuit = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_Q);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventQuit);
    }


    public void playMusic() {
        /*Music*/
       //audioFile = new File("resources/gameSounds/theme.wav");

        try {

            InputStream audiosrc = getClass().getResourceAsStream("/resources/gameSounds/theme.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            audioClipIntro = (Clip) AudioSystem.getLine(info);

            audioClipIntro.open(audioStream);
            audioClipIntro.start();



            //audioClipIntro.close();
            //audioStream.close();

            //InputStream audioSrc = getClass().getResourceAsStream("resources/gameSounds/theme.wav");

            //InputStream bufferedIn = new BufferedInputStream(audioSrc);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }




}


