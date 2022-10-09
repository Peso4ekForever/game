package ru.peso4ek.game.world;

import ru.peso4ek.game.Game;

public class Entity {
    protected World world;
    protected int x;
    protected int y;

    protected boolean dead = false;

    public Entity(World world) {
        this.world = world;
    }

    public void update() {
        if (dead) {
            world.removeEntity(x, y);
        }
    }

    public void render(double elapsedTick) {
        Game.getGame().drawSquare(x * 60 + 1, y * 60 + 1.5F, 57);
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDead() {
        dead = true;
    }
}
