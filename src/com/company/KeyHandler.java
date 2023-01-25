package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.print;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    Scanner scanner = new Scanner(System.in);


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
                        //print (UI.playTime);
                        System.out.println(Main.playTime/60);
                        Main.updateTime();
                        System.exit(0);



                    }

            }
        }
        if (gp.gameState == gp.playState){
            if(code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_1){

                System.out.println("What is this box name?");
                String npcname = scanner.next();
                System.out.println("How old is box?");
                int npcage = scanner.nextInt();
                System.out.println("what?");


                try {
                    Main.writeNPCToDatabase(npcname,1,npcage,5,1,gp.ObjectNPCNo);
                } catch (SQLException ex) {
                    //throw new RuntimeException(ex);
                    System.out.println("failed");
                }
                gp.npc[gp.ObjectNPCNo] = new box(gp);
                gp.npc[gp.ObjectNPCNo].worldX = 10;
                gp.npc[gp.ObjectNPCNo].worldY = 20;

                gp.ObjectNPCNo++;


            }
            if(code == KeyEvent.VK_1){

            }
            if(code == KeyEvent.VK_1){

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
                    //print (UI.playTime);
                    System.out.println(gp.playTime/60);
                    Main.updateTime();



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

