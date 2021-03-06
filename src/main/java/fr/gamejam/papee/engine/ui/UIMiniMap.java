package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.entity.papee.Papee;
import fr.gamejam.papee.entity.environment.obstacles.Toilets;
import fr.gamejam.papee.game.level.Difficulty;
import fr.gamejam.papee.translation.Translation;
import org.lwjgl.opengl.GL11;

public class UIMiniMap extends UI {
    private Papee papee;
    private Toilets toilet;

    private int renderCooldown = 0;

    public UIMiniMap(Papee papee, Toilets toilet) {
        super(0, 0, 0, 0, null);
        this.papee = papee;
        this.toilet = toilet;

        if (GDefines.DIFFICULTY.getLevel() == Difficulty.MEDIUM.getLevel()) {
            renderCooldown = 180;
        }
    }

    @Override
    public void update() {
        if (renderCooldown > 0) {
            renderCooldown--;
        }
    }

    @Override
    public void render() {
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION, GDefines.floatBuffer(GDefines.WIDTH - 125, 80, 96, 1));

        if (GDefines.DIFFICULTY == Difficulty.EASY || (GDefines.DIFFICULTY.getLevel() == Difficulty.MEDIUM.getLevel() && renderCooldown > 0)) {
            GGraphics.renderImage(GTextures.GUI_MINIMAP, GDefines.WIDTH - 250, 10, 240, 200, new float[]{1, 1, 1, 0.8f});
            GGraphics.renderImage(GTextures.CROSS_MINIMAP, GDefines.WIDTH - 250 + 16 + papee.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16), 10 + 16 + papee.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16), 10, 10, GDefines.WHITE);
            GGraphics.renderImage(GTextures.CHECK_MINIMAP, GDefines.WIDTH - 250 + 16 + toilet.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16), 10 + 16 + toilet.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16), 10, 10, GDefines.WHITE);

            GGraphics.renderText("Papee", GDefines.WIDTH - 250 + 16 + papee.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16) - 4 * 4, 10 + 16 + papee.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16) - 8, 8, GDefines.BLACK);
            GGraphics.renderText(Translation.get("minimap.toilets.name"), GDefines.WIDTH - 250 + 16 + toilet.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16) - 6 * 4, 10 + 16 + toilet.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16) - 8, 8, GDefines.BLACK);
        }
    }
}
