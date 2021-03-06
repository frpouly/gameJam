package fr.gamejam.papee.entity.environment;

import fr.gamejam.papee.effect.Effect;
import fr.gamejam.papee.entity.Entity;
import fr.gamejam.papee.entity.papee.Papee;
import fr.gamejam.papee.game.map.Map;

public abstract class EnvironmentObject extends Entity {
    private Map map; // C'est dégueu mais j'ai pas le temps de faire un truc potable
    private Effect effect;
    private String name;

    public EnvironmentObject(int ID, float x, float y, int sizeX, int sizeY, boolean rigid, String name) {
        super(ID, x, y, sizeX, sizeY, rigid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effectTime) {
        this.effect = effectTime;
    }

    protected Map getMap() { // C'est dégueu mais j'ai pas le temps de faire un truc potable
        return map;
    }

    public void setMap(Map map) { // C'est dégueu mais j'ai pas le temps de faire un truc potable
        this.map = map;
    }

    public abstract void effect(Papee papee);
}
