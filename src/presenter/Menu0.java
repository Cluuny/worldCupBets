package presenter;
import view.View;

import model.WorldCup;

public class Menu0 {
    private View view;
    private WorldCup worldCup;

    public Menu0(View view, WorldCup worldCup) {
        this.view = view;
        this.worldCup = worldCup;
    }

    public void start() {
        String menu0 = "1. Apostar\n2. Mostrar lista de partidos\n3. Que empiece el juego\n4. Salir";
        int option = 0;
        while(option != 4) {
            option = view.readInt(menu0);
            switch (option) {
                case 1:
                    // go to menu1
                break;
                case 2:
                    view.print(worldCup.listMatch());
                break;
                case 3:
                    // run simulatioin and show results
                break;
                case 4:
                    // reject program
                    System.exit(0);
                break;
                default:
                    view.print("Opcion invalida");
                break;
            }
        }
    }
}
