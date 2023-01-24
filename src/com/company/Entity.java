package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX, worldY;
    public String direction;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    public int speed;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        image = up1;


//            switch(direction) {
//                case "up":
//                    if (spriteNum == 1) {
//                        image = up1;
//                    }
//                    if (spriteNum == 2) {
//                        image = up2;
//                    }
//                    break;
//                case "down":
//                    if (spriteNum == 1) {
//                        image = down1;
//                    }
//                    if (spriteNum == 2) {
//                        image = down2;
//                    }
//                    break;
//                case "left":
//                    if (spriteNum == 1) {
//                        image = left1;
//                    }
//                    if (spriteNum == 2) {
//                        image = left2;
//                    }
//                    break;
//                case "right":
//                    if (spriteNum == 1) {
//                        image = right1;
//                    }
//                    if (spriteNum == 2) {
//                        image = right2;
//                    }
//                    break;
//            }

            g2.drawImage(image,worldX,worldY, gp.tileSize, gp.tileSize,null);
        }

    }



