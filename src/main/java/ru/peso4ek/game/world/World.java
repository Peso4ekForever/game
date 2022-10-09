package ru.peso4ek.game.world;

import ru.peso4ek.game.world.entity.Air;
import ru.peso4ek.game.world.entity.Coin;
import ru.peso4ek.game.world.entity.Player;
import ru.peso4ek.game.world.entity.Rock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class World {
    private static final int SPAWN_WEIGHT = 5;

    private final Entity[][] entitiesGrid = new Entity[10][10];
    private final Random random;

    public World() {
        random = new Random();
        generateWorld();
    }

    //Генератор мира
    public void generateWorld() {
        for (int i = 0; i < entitiesGrid.length; i++) {
            Entity[] entities = entitiesGrid[i]; //Строка мира с энтити
            for (int j = 0; j < entities.length; j++) {
                if (i == 0 && j == 0) {
                    entities[j] = new Player(this);
                    continue; //Создан игрок
                }

                Entity randomEntity = getRandomEntity(random.nextInt(SPAWN_WEIGHT)); //Генерим энтити
                randomEntity.setPos(i, j);
                entities[j] = randomEntity;
            }
        }
    }

    //Перебор энтити
    public void update() {
        getEntities().forEach(Entity::update);
    }

    //Получение листа энтити
    public List<Entity> getEntities() {
        List<Entity> entitiesList = new ArrayList<>();
        Arrays.stream(entitiesGrid)
                .forEach(o -> entitiesList.addAll(Arrays.stream(o).collect(Collectors.toList())));
        return entitiesList;
    }

    //Генератор энтити
    public Entity getRandomEntity(int id) {
        switch (id) {
            case 0:
                return new Coin(this);
            case 1:
                return new Rock(this);
        }
        return new Air(this);
    }

    //Null-безопасное получение энтити
    public Entity getEntity(int x, int y) {
        if (x >= 10 || x < 0) {
            return null;
        }
        if (y >= 10 || y < 0) {
            return null;
        }
        return entitiesGrid[x][y];
    }

    //Реплейс энтити на воздух
    public void removeEntity(int x, int y) {
        Air air = new Air(this);
        air.setPos(x, y);
        entitiesGrid[x][y] = air;
    }
}
