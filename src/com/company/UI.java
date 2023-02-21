package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.text.DecimalFormat;

import static jdk.nashorn.internal.objects.Global.print;

public class UI {

    GamePanel gp;
    Graphics2D g2;

    Font arial_40, arial_80B;


    public int commandNum = 0;





    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        //TITLESTATE
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        //PLAYSTATE
        if (gp.gameState == gp.playState) {
            Main.playTime += 1;
            for (int i = 0; i < gp.ObjectNPCNo; i++) { //loop repeats for each entity that has been created this game
                if (gp.npc[i] == null) {

                } else {
                    if (gp.npc[i].worldY < 400) { //checks if entity has reached ground yet

                        gp.npc[i].worldY++;
                        gp.npc[i].worldY++;

                    } else if (gp.npc[i].worldY == 400) {

                        if (gp.npc[i].fallDamage != 1) { //if entity has not taken fall damage
                            if (gp.npc[i].npc == 1) { //if it is an object entity
                                try {

                                    Main.updateObjectHealth(i, 5); //takes 5 fall damage
                                } catch (SQLException ex) {
                                    System.out.println("Mailed");
                                }
                            } else if (gp.npc[i].npc == 0) { //if it is an NPC entity
                                try {
                                    Main.updateHealth(i, 5);
                                    Main.updateMood(i, 10);
                                    System.out.println("Mood is " + Main.checkMood(i) + "/100"); //prints npc mood after taking fall damage
                                } catch (SQLException ex) {
                                    System.out.println("grailed");
                                }
                            }
                            gp.npc[i].fallDamage = 1; // Entity has now taken fall damage


                        } else {
                            if (gp.npc[i].npc == 0) { //if it is an NPC entity and are on the ground they move off the screen.
                                gp.npc[i].worldX++;
                            }
                        }
                    }


                    if (Main.checkNPCHealth(i) <= 0) { //if NPC health is less than 0, they are null
                        gp.npc[i] = null;
                    } else if (Main.checkObjectHealth(i) <= 0) { //if object health is less than 0, they are null
                        gp.npc[i] = null;

                    } else if (gp.npc[i].npc == 0) {

                        if (gp.npc[i].worldX == gp.screenWidth + gp.tileSize) { //if npc moves off the screen, they are null
                            gp.npc[i] = null;
                        }
                    }
                }
            }



            drawPlayScreen();
        }


        //PAUSESTATE
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();

        }
        //QUITSTATE
        if (gp.gameState == gp.quitState){




        }
    }

    public void drawTitleScreen(){ //draws the main menu screen
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Life Simulator";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;
        // SHADOW COLOUR
        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);

        // MAIN COLOUR
        g2.setColor(Color.white);
        g2.drawString(text, x,y);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text,x,y);
        if(commandNum == 0) {
            g2.drawString(">",x-gp.tileSize,y);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 1) {
            g2.drawString(">",x-gp.tileSize,y);
        }
    }
    public void drawPlayScreen(){ //draws the play screen
        g2.setColor(new Color(135,206,235));
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
        g2.setColor(new Color(86,125,70));
        g2.fillRect(0,440,gp.screenWidth, gp.screenHeight);

    }
    public void drawPauseScreen(){ //draws the pause screen
        g2.setColor(new Color(235,235,235));
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        g2.setColor(new Color(0,0,0));
        String text = "Pause";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;
        // SHADOW COLOUR
        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        text = "Resume";
        x = getXforCenteredText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text,x,y);
        if(commandNum == 0) {
            g2.drawString(">",x-gp.tileSize,y);
        }
        text = "Quit";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 1) {
            g2.drawString(">",x-gp.tileSize,y);
        }
    }
    public int getXforCenteredText(String text){ //centres text for main menu and pause screen
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }


}
