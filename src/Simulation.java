import model.Map;
import service.ConsoleFieldRenderer;

public class Simulation {
    private Map map;
    private ConsoleFieldRenderer fieldRenderer;
    private int movesCounter;

    public Simulation() {
        map = new Map();
        fieldRenderer = new ConsoleFieldRenderer();
        movesCounter = 0;
    }

    public void startSimulation() {
        Actions.initActions(map);
        fieldRenderer.render(map);
    }

    public void nextTurn() {
//        TODO:
        Actions.turnActions(map);
//        Runtime.getRuntime().exec("cls");
        fieldRenderer.render(map);
    }

    public void pauseSimulation() {
        // TODO:
    }
}
