package com.company;

import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX, worldY;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    public int speed;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
}
