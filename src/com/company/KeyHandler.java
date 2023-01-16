package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class KeyHandler implements KeyListener {
    GamePanel gp;


    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Random random = new Random();

        int code = e.getKeyCode();
        //TITLE STATE
        if (gp.gameState == gp.titleState) {
            if ((code == KeyEvent.VK_W)||(code == KeyEvent.VK_S)) {
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum<0){
                        gp.ui.commandNum=1;
                    }
            }
//            if (code == KeyEvent.VK_S) {
//                    gp.ui.commandNum++;
//                    if (gp.ui.commandNum > 2) {
//                        gp.ui.commandNum = 0;
//
//                    }
//            }
            if (code == KeyEvent.VK_ENTER) {
                    if(gp.ui.commandNum == 0){
                        gp.gameState = gp.playState;
                    }
                    if(gp.ui.commandNum == 1){
                        gp.gameState = gp.quitState;
                        System.out.println("hi");
                        System.exit(0);



                    }

            }
        }
        if (gp.gameState == gp.playState){
            if(code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }

        }
        if (gp.gameState == gp.pauseState){
            if ((code == KeyEvent.VK_W)||(code == KeyEvent.VK_S)) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }

            if (code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState=gp.quitState;
                    System.exit(0);

                }

            }



        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}

