package util;

public interface GameLoop {
    void init();

    void render(double elapsedTick);

    void update();

    int getTicksPerSecond();
}
