import ui.ConsoleIO;
import ui.controllers.Controller;
import ui.views.View;

public class App {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        View view = new View(io);
        Controller controller = new Controller(view);

        controller.run();
    }
}
