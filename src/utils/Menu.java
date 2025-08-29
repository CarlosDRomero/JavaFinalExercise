package utils;

import java.util.Map;

public abstract class Menu {
    protected String title;
    protected Map<Integer, String> options;
    protected Menu parent;
    protected MenuController controller;

    public Menu(String title, MenuController controller) {
        this.title = title;
        this.controller = controller;
    }
    public Menu(String title, MenuController controller, Menu parent) {
        this.title = title;
        this.parent = parent;
    }

    public String optionsString() {
        StringBuilder optionsString = new StringBuilder();
        for (Map.Entry<Integer, String> option : options.entrySet()) {
            optionsString.append(option.getKey() + ". " + option.getValue() + "\n");
        }
        return optionsString.toString();
    }
    public boolean isValidOption(int option) {
        return options.containsKey(option);
    }

    public abstract void run();

}
