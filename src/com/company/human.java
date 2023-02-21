package com.company;

import com.company.Entity;
import com.company.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class human extends Entity {
    public human(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;
        getImage();

    }
    public void getImage() {
        try {

            up1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
            up2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
            down1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
            down2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
            left1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
            left2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
            right1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
            right2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\human.png"));
//            up1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));
//            up2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));
//            down1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));
//            down2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));
//            left1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));
//            left2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));
//            right1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));
//            right2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\human.png"));

        }

        catch(IOException e){
            e.printStackTrace();
        }


    }
}
