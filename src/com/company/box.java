package com.company;

import javax.imageio.ImageIO;
import java.io.IOException;
import com.company.Entity;
import com.company.GamePanel;

public class box extends Entity{
    public box(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;
        //getImage();

    }
    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("res/Key.png"));
//            up1 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));
//            up2 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));
//            down1 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));
//            down2 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));
//            left1 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));
//            left2 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));
//            right1 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));
//            right2 = ImageIO.read(getClass().getClassLoader().getResource("res/Key.png"));

        }

        catch(IOException e){
            e.printStackTrace();
        }


    }
}
