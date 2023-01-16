package com.company;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }
    public void setNPC() {
        gp.npc[0] = new box(gp);
        gp.npc[0].worldX = gp.tileSize * 19;
        gp.npc[0].worldY = gp.tileSize * 21;

    }

}
