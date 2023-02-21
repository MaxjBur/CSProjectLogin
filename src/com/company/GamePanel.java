package com.company;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Screen Settings
    final int originalTileSize = 16; // 16x16 tile - Default size of Characters/NPCs
    final int scale = 3;
    public int playTime = 0; //This is the total time played
    public int ObjectNPCNo=0;
    public String[][] entitiesCreated = new String[50][2];


    public final int tileSize = originalTileSize*scale; // This is the tilesize of the screen
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize*maxScreenRow; // 576 pixels

    public AssetSetter aSetter = new AssetSetter(this);
    public int FPS = 60;
    //SYSTEM
    public UI ui = new UI(this);
    public KeyHandler keyH = new KeyHandler(this);
    //public TileManager tileM = new TileManager(this);
    Thread gameThread;



    public Entity npc[]= new Entity[10];


    //GAME STATE
    public int gameState; //This is the integer that tracks what gameplay loop the user is in
    public int titleState = 1; //Main menu
    public int playState = 2; //gameboard

    public int pauseState = 4; // game is paused

    public int quitState = 5; //user has selected to quit

    public void setupGame(){
        gameState = titleState;
        aSetter.setNPC();
    }

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }
//    public void startGameThread() {
//
//        gameThread = new Thread(this);
//        gameThread.start();
//    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // 1 Billion Nanoseconds = 1 second
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            long currentTime = System.nanoTime();

            // 1 UPDATE: Update information such as character positions
//            update();

            // 2 DRAW: Draw the screen with the updated information
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();

                remainingTime /= 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if (gameState == titleState){
            ui.draw(g2);

        }
        else if(gameState == playState){
            ui.draw(g2);
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].draw(g2);
                }

            }

        }
        else if(gameState == pauseState){
            ui.draw(g2);

        }
    }
}
