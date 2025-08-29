package utils;

import java.util.Scanner;

public class ConsoleController implements MenuController {

    public void showInfo(String info) {
        System.out.println(info);
    }

    public int select(Menu menu) {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            System.out.println(menu.optionsString());
            System.out.print("Seleccione una opción: ");
            option =  sc.nextInt();
            if (!menu.isValidOption(option)){
                System.out.println("Opción no válida");
            } else break;
        }while(true);
        return option;

    }

}
