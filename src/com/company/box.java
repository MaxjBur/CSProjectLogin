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
            up1 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
        }

        catch(IOException e){
            e.printStackTrace();
        }


    }
}
