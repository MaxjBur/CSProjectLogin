package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import static jdk.nashorn.internal.objects.Global.print;

public class UI {

    GamePanel gp;
    Graphics2D g2;

    Font arial_40, arial_80B;
    BufferedImage heart_full,heart_half,heart_blank;
    BufferedImage keyImage;
    public int commandNum = 0;



    DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        //TITLESTATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        //PLAYSTATE
        if (gp.gameState == gp.playState){
            Main.playTime += 1;


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
    public void quitGame(){

    }
    public void drawTitleScreen(){
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
    public void drawPlayScreen(){
        g2.setColor(new Color(135,206,235));
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
        g2.setColor(new Color(86,125,70));
        g2.fillRect(0,gp.screenHeight/2,gp.screenWidth, gp.screenHeight);

    }
    public void drawPauseScreen(){
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
        text = "Settings";
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
    public int getXforCenteredText(String text){
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }


}
