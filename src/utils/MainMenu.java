package utils;

public class MainMenu extends Menu{
    public MainMenu(MenuController controller) {
        super("MENÚ PRINCIPAL", controller);
    }

    public void run() {
        setOptions(new String[]{
            "Mostrar profesores",
            "Ver clases",
            "Crear y agregar estudiante a clase",
            "Crear clase",
            "Listar clases por estudiante"
        });
        int option;
        do{
            option = controller.select(this);
            switch (option){
                case 6:
                    controller.showInfo("Gracias por usar el programa, hasta la próxima");
            }
        }while (!isLastOption(option));
    }
}
