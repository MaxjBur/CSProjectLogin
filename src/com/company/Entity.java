package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX, worldY; //the position on the screen for an entity
    public int fallDamage; //this tracks whether the entity has taken for damage or not so they only receive damage once and ground level
    public int npc; //This tracks whether the entity is an NPC or an Object
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



            g2.drawImage(image,worldX,worldY, gp.tileSize, gp.tileSize,null);
        }

    }



