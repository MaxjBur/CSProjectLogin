package com.company;

import javax.imageio.ImageIO;
import java.io.IOException;

public class box extends Entity{
    public box(GamePanel gp) {
        super(gp);
        speed = 1;
        getImage();

    }
    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Walk 1 down.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/MaxJa/IdeaProjects/CSProjectLogin/src/com/company/res/Walk 1 down.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("C:/Users/MaxJa/IdeaProjects/CSProjectLogin/src/com/company/res/Walk 1 down.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/MaxJa/IdeaProjects/CSProjectLogin/src/com/company/res/Walk 1 down.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("C:/Users/MaxJa/IdeaProjects/CSProjectLogin/src/com/company/res/Walk 1 down.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/MaxJa/IdeaProjects/CSProjectLogin/src/com/company/res/Walk 1 down.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("C:/Users/MaxJa/IdeaProjects/CSProjectLogin/src/com/company/res/Walk 1 down.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/MaxJa/IdeaProjects/CSProjectLogin/src/com/company/res/Walk 1 down.png"));
        }

        catch(IOException e){
            e.printStackTrace();
        }


    }
}
