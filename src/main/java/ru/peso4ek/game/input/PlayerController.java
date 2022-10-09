package ru.peso4ek.game.input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class PlayerController extends GLFWKeyCallback {
    private static PlayerController controller;

    private MoveDirection moveDirection;

    public PlayerController() {
        controller = this;
    }

    //Кол бек от GLFW - инпуты
    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        if (action != GLFW.GLFW_PRESS) {
            return;
        }
        switch (key) {
            case GLFW.GLFW_KEY_W:
                setMoveDirection(MoveDirection.UP); //Сет на тик, направления вверх
                break;
            case GLFW.GLFW_KEY_S:
                setMoveDirection(MoveDirection.DOWN); //Сет на тик, направления вниз
                break;
            case GLFW.GLFW_KEY_A:
                setMoveDirection(MoveDirection.LEFT); //Сет на тик, направления влево
                break;
            case GLFW.GLFW_KEY_D:
                setMoveDirection(MoveDirection.RIGHT); //Сет на тик, направления вправо
        }
    }

    //Получения направления движения и обнуление
    public MoveDirection getMoveDirection() {
        MoveDirection temp = moveDirection;
        moveDirection = null;
        return temp;
    }

    public void setMoveDirection(MoveDirection moveDirection) {
        this.moveDirection = moveDirection;
    }

    public static PlayerController getController() {
        return controller;
    }
}
