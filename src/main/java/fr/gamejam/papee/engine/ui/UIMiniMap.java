package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.obstacles.Toilets;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class UIMiniMap implements UI {

    private PaPee papee;
    private Toilets toilet;

    /*
        Toilets : x, y
     */

    public UIMiniMap(PaPee papee, Toilets toilet) {
        this.papee = papee;
        this.toilet = toilet;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION,
                GDefines.floatBuffer(GDefines.WIDTH - 125,
                        80, 96, 1));
        GGraphics.renderImage(GTexture.GUI_MINIMAP, GDefines.WIDTH - 250,10, 240, 200, new float[] {1, 1, 1, 1});
        GGraphics.renderImage(GTexture.CROSS_MINIMAP, GDefines.WIDTH - 250 + 16 + papee.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16), 10 + 16 + papee.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16), 10, 10, GDefines.WHITE);
        GGraphics.renderImage(GTexture.CHECK_MINIMAP, GDefines.WIDTH - 250 + 16 + toilet.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16), 10 + 16 + toilet.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16), 10, 10, GDefines.WHITE);
        GGraphics.renderText("papee", GDefines.WIDTH - 250 + 16 + papee.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16) - 4 * 4, 10 + 16 + papee.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16) - 8, 8, GDefines.BLACK);
        GGraphics.renderText("toilets", GDefines.WIDTH - 250 + 16 + toilet.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16) - 6 * 4, 10 + 16 + toilet.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16) - 8, 8, GDefines.BLACK);

    }
}