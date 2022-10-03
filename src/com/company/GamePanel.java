package com.company;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Screen Settings
    final int originalTileSize = 16; // 16x16 tile - Default size of Characters/NPCs
    final int scale = 3;

    public final int tileSize = originalTileSize*scale; // 48x48 tile - Actual tile size that is displayed on game screen
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize*maxScreenRow; // 576 pixels
    public int FPS = 60;
    //SYSTEM
    public UI ui = new UI(this);
    //public TileManager tileM = new TileManager(this);
    Thread gameThread;

    //GAME STATE
    public int gameState;
    public int titleState = 1;
    public int playState = 2;
    public int objectState = 3;

    public void setupGame(){
        gameState = titleState;
    }

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        //this.addKeyListener(keyH);
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

        }
    }
}
