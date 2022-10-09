package ru.peso4ek.game.world.entity;

import org.lwjgl.opengl.GL11;
import ru.peso4ek.game.input.MoveDirection;
import ru.peso4ek.game.input.PlayerController;
import ru.peso4ek.game.world.Entity;
import ru.peso4ek.game.world.World;

public class Player extends Entity {
    private int coinCount;

    public Player(World world) {
        super(world);
    }

    @Override
    public void update() {
        MoveDirection moveDirection = PlayerController.getController().getMoveDirection();
        if (moveDirection != null) {
            Entity entity = null;
            switch (moveDirection) {
                case UP:
                    entity = world.getEntity(x, y - 1);
                    if (!(entity instanceof Rock)) {
                        y -= 1;
                    }
                    break;
                case DOWN:
                    entity = world.getEntity(x, y + 1);
                    if (!(entity instanceof Rock)) {
                        y += 1;
                    }
                    break;
                case LEFT:
                    entity = world.getEntity(x - 1, y);
                    if (!(entity instanceof Rock)) {
                        x -= 1;
                    }
                    break;
                case RIGHT:
                    entity = world.getEntity(x + 1, y);
                    if (!(entity instanceof Rock)) {
                        x += 1;
                    }
            }
            if (entity instanceof Coin) {
                collectCoin((Coin) entity);
            }
        }
        super.update();
    }

    public void collectCoin(Coin coin) {
        coin.setDead();
        coinCount++;
    }

    @Override
    public void render(double elapsedTick) {
        GL11.glColor3f(1, 0, 0);
        super.render(elapsedTick);
    }

    public int getCoinCount() {
        return coinCount;
    }
}
