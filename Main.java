package pracownicy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        ArrayList<Pracownik> bazaPracownikow = new ArrayList<>();
        Scanner scn = new Scanner(System.in);

        while(true) {
            view.showMenu();
            int choice = scn.nextInt();
            switch (choice) {
                case 1: {
                    for (int i = 0; i < bazaPracownikow.size(); i++) {
                        if (bazaPracownikow.get(i) instanceof Dyrektor)
                            view.showDirector(i + 1, bazaPracownikow.size(), (Dyrektor) bazaPracownikow.get(i));
                        else if (bazaPracownikow.get(i) instanceof Handlowiec)
                            view.showSalesman(i+1, bazaPracownikow.size(), (Handlowiec) bazaPracownikow.get(i));
                        String choice2 = scn.next();
                        switch (choice2) {
                            case ("q"): {
                                i=bazaPracownikow.size();
                                break;
                            }
                            case ("e"): {
                                if (i == bazaPracownikow.size()-1)
                                    i = -1;
                                break;
                            }
                            default:
                                throw new IllegalStateException("Unexpected value: " + choice2);
                        }
                    }
                    break;
                }
                case 2:{
                    bazaPracownikow.add(view.addEmployee());
                    if (bazaPracownikow.get(bazaPracownikow.size()-1) == null) bazaPracownikow.remove(bazaPracownikow.size()-1);
                    break;
                }
                case 3:{
                    bazaPracownikow.remove(view.deleteEmployee(bazaPracownikow));
                    break;
                    }
                case 4:{
                    view.backUp(bazaPracownikow);
                    break;
                }

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
