package utils;

import javax.swing.*;
import java.util.Scanner;

public class JOptionController implements MenuController{

    public void showInfo(String info) {
        JOptionPane.showMessageDialog(null, info);
    }

    public int select(Menu menu) {
        int option = -1;
        do {
            String seleccionado = JOptionPane.showInputDialog(null, menu.optionsString(), menu.getTitle(), 1);
            option = Integer.parseInt(seleccionado);
            if (!menu.isValidOption(option)){
                System.out.println("Opción no válida");
            } else break;
        }while(true);
        return option;
    }
}
