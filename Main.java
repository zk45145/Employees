package pracownicy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        Scanner scn = new Scanner(System.in);

        while(true) {
            view.showMenu();
            int choice = scn.nextInt();
            switch (choice) {
                case 1: {
                    controller.browse();
                    break;
                }
                case 2:{
                    controller.insert();
                    break;
                }
                case 3:{
                    controller.delete();
                    break;
                    }
                case 4:{
                    controller.save_or_load();
                    break;
                }

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
