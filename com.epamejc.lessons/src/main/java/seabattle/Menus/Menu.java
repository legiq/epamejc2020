package seabattle.Menus;

import lombok.SneakyThrows;
import seabattle.Main.Game;
import seabattle.Settings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Menu {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Game game = new Game();
    Settings settings = new Settings();

    public abstract void printMenu();

    public abstract void executeCommand(String command);

    public abstract void run();


    @SneakyThrows
    public String readCommand() {
        return reader.readLine();
    }

    public int parseCommandStringToInt(String command) {
        int commandKey = 0;
        try {
            commandKey = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Wrong command!");
        }
        return commandKey;
    }

}
