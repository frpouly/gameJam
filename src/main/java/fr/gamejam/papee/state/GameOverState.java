package fr.gamejam.papee.state;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.util.GDefines;
import org.lwjgl.opengl.Display;

public class GameOverState extends State {
    public GameOverState() {
        GButton returnMenu = new GButton("MENU", Display.getWidth() / 2 - 4 * 16, 400, 32) {
            @Override
            public void onClick() {
                getWindow().setState(new MenuState());
                getWindow().run();
            }
        };

        getListUI().add(returnMenu);
    }

    @Override
    public void render() {
        super.render();
        GGraphics.renderText("GAME OVER", getWindow().getWidth() / 2 - 252, getWindow().getHeight() / 2 - 28, 56, GDefines.WHITE);
    }
}
