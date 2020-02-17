package pracownicy;

import java.util.Scanner;

public class Controller {
    private
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void browse() {
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < model.database.size(); i++) {
            if (model.database.get(i) instanceof Dyrektor)
                view.showEmployee(i + 1, model.database.size(), (Dyrektor) model.database.get(i));
            else if (model.database.get(i) instanceof Handlowiec)
                view.showEmployee(i + 1, model.database.size(), (Handlowiec) model.database.get(i));
            String choice2 = scn.next();
            switch (choice2) {
                case ("q"): {
                    i = model.database.size();
                    break;
                }
                case ("e"): {
                    if (i == model.database.size() - 1)
                        i = -1;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + choice2);
            }
        }
    }

    public void insert() {
        Pracownik temp = view.addEmployee();
        if (temp != null){
            if (!model.isPeselInTheList(temp.getPesel()))
                model.database.add(temp);
            else
                view.peselIsInTheListError();
        }
    }

    public void delete() {
        Pracownik temp = view.deleteEmployee(model.database);
        if (temp != null)
            model.database.remove(temp);
    }

    public void save_or_load() {
        String [] temp= view.backUp();
        if (temp[0].equals("g"))
            model.makeGzip(temp[1]);
        if (temp[0].equals("z"))
            model.makeZip(temp[1]);
        if (temp[0].equals("o")) {
            if (temp[1].endsWith(".gzip")) {
                model.database.clear();
                model.loadGzipFile(temp[1]);
            } else if (temp[1].endsWith("zip")) {
                model.database.clear();
                model.loadZipFile(temp[1]);
            }
            else view.unexpectedFileNameError();
        }
    }
}
