package ru.peso4ek.game;

import org.lwjgl.opengl.GL11;
import ru.peso4ek.game.world.World;
import util.GameLoop;

public class Game implements GameLoop {
    private static final int TICKS_PER_SECOND = 20; //Тик-рейт

    private static Game game;
    private World world;

    @Override
    public void init() {
        world = new World();
        game = this;
    }

    @Override
    public void render(double elapsedTick) {
        resizeGL();
        drawGrid();
        world.getEntities().forEach(entity -> entity.render(elapsedTick));
    }

    @Override
    public void update() {
        world.update();
    }

    @Override
    public int getTicksPerSecond() {
        return TICKS_PER_SECOND;
    }

    //Рсеайз гл проекций и матриц
    private void resizeGL() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 600, 600, 0, 1000, 3000);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0, 0, -2000);
    }

    //Отрисовка для энтити
    public void drawSquare(float x, float y, float length) {
        GL11.glBegin(GL11.GL_POLYGON);
        GL11.glVertex2f(x + length, y + length);
        GL11.glVertex2f(x + length, y);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x, y + length);
        GL11.glEnd();
    }

    public void drawGrid() {
        GL11.glColor3f(1, 1, 1);
        GL11.glBegin(GL11.GL_LINES);
        for (int i = 0; i < 10; i++) {
            GL11.glVertex2f(i * 60, 0);
            GL11.glVertex2f(i * 60, 600);
        }
        for (int i = 0; i < 10; i++) {
            GL11.glVertex2f(0, i * 60);
            GL11.glVertex2f(600, i * 60);
        }

        GL11.glEnd();
    }

    public static Game getGame() {
        return game;
    }
}
