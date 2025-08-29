package utils;

// La idea de esta interfaz es que permita tener una abstracción común para mostrar los menús y recibir entradas de diferentes formas
public interface MenuController {
    void showInfo(String info);
    int select(Menu menu);
}
