package com.company;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import com.company.Entity;
import com.company.GamePanel;

public class box extends Entity{
    public box(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;
        getImage();

    }
    public void getImage() {
        try {

            up1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
            up2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
            down1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
            down2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
            left1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
            left2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
            right1 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
            right2 = ImageIO.read(new File("C:\\Users\\MaxJa\\IdeaProjects\\CSProjectLogin1302\\res\\ChestShut.png"));
//            up1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));
//            up2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));
//            down1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));
//            down2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));
//            left1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));
//            left2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));
//            right1 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));
//            right2 = ImageIO.read(new File("X:\\Users\\MB211187\\IdeaProjects\\CSProjectLogin0602\\res\\ChestShut.png"));

        }

        catch(IOException e){
            e.printStackTrace();
        }


    }
}
