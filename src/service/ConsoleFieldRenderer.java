package service;

import model.Map;
import model.entity.Coordinates;

public class ConsoleFieldRenderer {
    private final int width = Map.width;
    private final int height = Map.height;

    public void render(Map map) {
        StringBuilder horizontalBlocks = getHorizontalBlocks(width);
        StringBuilder field = new StringBuilder("").append(horizontalBlocks);

        for (int i = 1; i <= height; i++) {
            StringBuilder line = new StringBuilder("\uD83E\uDDF1");
            for (int j = 1; j <= width; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (!map.isCellEmpty(coordinates)) {
                    line.append(map.getEntity(coordinates).representation);
                } else {
                    line.append("⬜");
                }
            }
            line.append("\uD83E\uDDF1\n");
            field.append(line);
        }

        field.append(horizontalBlocks);

        System.out.println(field);
    }

    private StringBuilder getHorizontalBlocks(int width) {
        StringBuilder horizontalBlocks = new StringBuilder("");
        for (int i = 0; i <= width + 1; i++) {
            horizontalBlocks.append("\uD83E\uDDF1");
        }
        horizontalBlocks.append("\n");

        return horizontalBlocks;
    }
}
