package ru.peso4ek.game.world.entity;

import org.lwjgl.opengl.GL11;
import ru.peso4ek.game.world.Entity;
import ru.peso4ek.game.world.World;

public class Rock extends Entity {
    public Rock(World world) {
        super(world);
    }

    @Override
    public void render(double elapsedTick) {
        GL11.glColor3f(0.5F, 0.5F, 0.5F);
        super.render(elapsedTick);
    }
}
