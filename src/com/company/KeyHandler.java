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
            if ((code == KeyEvent.VK_W)||(code == KeyEvent.VK_S)) { //this changes the position of the cursor on the screen
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum<0){
                        gp.ui.commandNum=1;
                    }
            }
//
            if (code == KeyEvent.VK_ENTER) { //this goes to play state if cursor is on new game
                    if(gp.ui.commandNum == 0){
                        gp.gameState = gp.playState;
                    }
                    if(gp.ui.commandNum == 1){ //This does the necessary steps before the game is closed
                        gp.gameState = gp.quitState;
                        Main.updateTime();
                        System.exit(0);



                    }

            }
        }
        if (gp.gameState == gp.playState){
            if(code == KeyEvent.VK_P) { //switches to pausing
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_1){
                Main.newNPC(gp.ObjectNPCNo,1);//creates a new box npc
                gp.npc[gp.ObjectNPCNo] = new box(gp);
                gp.npc[gp.ObjectNPCNo].worldX = 10;
                gp.npc[gp.ObjectNPCNo].worldY = 20;
                gp.npc[gp.ObjectNPCNo].npc=0;
                gp.entitiesCreated[gp.ObjectNPCNo][0]="box";
                gp.entitiesCreated[gp.ObjectNPCNo][1]= String.valueOf(gp.playTime/60);
                gp.ObjectNPCNo++; //increments objectnpcno (total amount of entities placed)
                Main.updateObjectsPlaced(gp.ObjectNPCNo); //updates objectsPlaced in Game table


            }
            if(code == KeyEvent.VK_2){
                Main.newNPC(gp.ObjectNPCNo,2); //creates human npc

//
                gp.npc[gp.ObjectNPCNo] = new human(gp);
                gp.npc[gp.ObjectNPCNo].worldX = 10+gp.tileSize;
                gp.npc[gp.ObjectNPCNo].worldY = 20;
                gp.npc[gp.ObjectNPCNo].npc=0;
                gp.entitiesCreated[gp.ObjectNPCNo][0]="human";
                gp.entitiesCreated[gp.ObjectNPCNo][1]= String.valueOf(gp.playTime/60);
                gp.ObjectNPCNo++;

                Main.updateObjectsPlaced(gp.ObjectNPCNo);

            }
            if(code == KeyEvent.VK_9){ //creates tree
                Main.newObject(gp.ObjectNPCNo,1);
                gp.npc[gp.ObjectNPCNo] = new Tree(gp);
                gp.npc[gp.ObjectNPCNo].worldX = 10+2*gp.tileSize;
                gp.npc[gp.ObjectNPCNo].worldY = 20;
                gp.npc[gp.ObjectNPCNo].npc=1;
                gp.entitiesCreated[gp.ObjectNPCNo][0]="tree";
                gp.entitiesCreated[gp.ObjectNPCNo][1]= String.valueOf(gp.playTime/60);
                gp.ObjectNPCNo++;
                Main.updateObjectsPlaced(gp.ObjectNPCNo);
            }
            if(code == KeyEvent.VK_5){
                System.out.println("What time was the entity you wanted created?");
                int time = scanner.nextInt();
                Main.findTimeCreated(time,gp.entitiesCreated,gp.ObjectNPCNo-1);
            }


        }
        if (gp.gameState == gp.pauseState){
            if ((code == KeyEvent.VK_W)||(code == KeyEvent.VK_S)) { //this cycles the cursor on the pause state
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }

            if (code == KeyEvent.VK_ENTER) { //resumes game
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){ //quits game
                    gp.gameState=gp.quitState;

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

