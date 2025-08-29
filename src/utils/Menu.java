package utils;


import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected String title;
    protected List<String> options = new ArrayList<>();
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

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setOptions(String[] options) {
        for (String option : options) {
            this.options.add(option);
        }
    }

    public String optionsString() {
        StringBuilder optionsString = new StringBuilder();
        optionsString.append(title).append("\n");
        int lastIndex;
        for (lastIndex  = 1; lastIndex < options.size() + 1; lastIndex++) {
            optionsString.append(lastIndex).append(". ").append(options.get(lastIndex -1)).append("\n");
        }
        optionsString.append(lastIndex).append(". ").append(parent!=null ? "Volver" : "Sair").append("\n");
        return optionsString.toString();
    }
    public boolean isValidOption(int option) {
        return option>=1 && option<=options.size() + 1;
    }
    public boolean isLastOption(int option){
        return options.size() + 1 == option;
    }

    public abstract void run();

}
