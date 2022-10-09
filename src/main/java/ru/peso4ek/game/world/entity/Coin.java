package ru.peso4ek.game.world.entity;

import org.lwjgl.opengl.GL11;
import ru.peso4ek.game.world.Entity;
import ru.peso4ek.game.world.World;

public class Coin extends Entity {
    public Coin(World world) {
        super(world);
    }

    @Override
    public void render(double elapsedTick) {
        GL11.glColor3f(1, 1, 0);
        super.render(elapsedTick);
    }
}
