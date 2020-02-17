package pracownicy;


import java.util.ArrayList;

import java.util.Scanner;



public class View {
    private
    Scanner scn = new Scanner(System.in);

    void showMenu() {
        System.out.println("MENU\n");
        System.out.println("   1. Lista pracowników\n");
        System.out.println("   2. Dodaj pracownika\n");
        System.out.println("   3. Usuń pracownika\n");
        System.out.println("   4. Kopia zapasowa\n");
        System.out.println("\nWybór> ");
    }

    void showEmployee(int current, int all, Dyrektor dyrektor) {
        System.out.println("1. Lista pracowników\n\n");
        System.out.format("%-40s:    " + dyrektor.getPesel() + "\n", "Identyfikator PESEL ");
        System.out.format("%-40s:    " + dyrektor.getImie() + "\n", "Imię ");
        System.out.format("%-40s:    " + dyrektor.getNazwisko() + "\n", "Nazwisko ");
        System.out.format("%-40s:    " + dyrektor.getStanowisko() + "\n", "Stanowisko ");
        System.out.format("%-40s:    " + dyrektor.getWynagrodzenie() + "\n", "Wynagrodzenie (zł) ");
        System.out.format("%-40s:    " + dyrektor.getTelefon() + "\n", "Telefon służbowy numer ");
        System.out.format("%-40s:    " + dyrektor.getDodatekSluzbowy() + "\n", "Dodatek służbowy (zł) ");
        System.out.format("%-40s:    " + dyrektor.getNumerKartySluzbowej() + "\n", "Karta służbowa nr ");
        System.out.format("%-40s:    " + dyrektor.getLimitKosztow() + "\n", "Limit kosztów/miesiąc (zł) ");
        System.out.format("\n%70s", "[Pozycja: " + current + "/" + all + "]\n");
        System.out.println("[ENTER] - następny");
        System.out.println("[Q] - powrót");

    }

    void showEmployee(int current, int all, Handlowiec handlowiec) {
        System.out.println("1. Lista pracowników\n\n");
        System.out.format("%-40s:    " + handlowiec.getPesel() + "\n", "Identyfikator PESEL ");
        System.out.format("%-40s:    " + handlowiec.getImie() + "\n", "Imię ");
        System.out.format("%-40s:    " + handlowiec.getNazwisko() + "\n", "Nazwisko ");
        System.out.format("%-40s:    " + handlowiec.getStanowisko() + "\n", "Stanowisko ");
        System.out.format("%-40s:    " + handlowiec.getWynagrodzenie() + "\n", "Wynagrodzenie (zł) ");
        System.out.format("%-40s:    " + handlowiec.getTelefon() + "\n", "Telefon służbowy numer ");
        System.out.format("%-40s:    " + handlowiec.getProwizja() + "\n", "Prowizja (%) ");
        System.out.format("%-40s:    " + handlowiec.getLimitProwizji() + "\n", "Limit prowizji/miesiąc (zł) ");
        System.out.format("\n%70s", "[Pozycja: " + current + "/" + all + "]\n");
        System.out.println("[ENTER] - następny");
        System.out.println("[Q] - powrót");
    }

    boolean isPeselValid (String pesel){
        PeselValidator temp = new PeselValidator(pesel);
        return temp.isValid();
    }

    Pracownik addEmployee() {
        System.out.println("2. Dodaj pracownika\n\n");
        System.out.format("%-20s    ", "[D]yrektor/[H]andlowiec:     ");
        String choice = scn.next();
        boolean check;

        switch (choice) {
            case "d": {
                Dyrektor temp = new Dyrektor();
                temp.setStanowisko("Dyrektor");
                System.out.println("-----------------------------------------------------");
                do {
                    System.out.format("%-40s:    ", "Identyfikator PESEL ");
                    temp.setPesel(scn.next());
                    check = isPeselValid(temp.getPesel());
                    if (!check) System.out.println("Nieprawidłowy PESEL - błędna suma kontrolna\n");
                }
                while (!check);
                System.out.format("%-40s:    ", "Imię ");
                temp.setImie(scn.next());
                System.out.format("%-40s:    ", "Nazwisko ");
                temp.setNazwisko(scn.next());
                System.out.format("%-40s:    ", "Wynagrodzenie (zł) ");
                temp.setWynagrodzenie(scn.nextInt());
                System.out.format("%-40s:    ", "Telefon służbowy numer ");
                temp.setTelefon(scn.nextInt());
                System.out.format("%-40s:    ", "Dodatek służbowy (zł) ");
                temp.setDodatekSluzbowy(scn.nextBigDecimal());
                System.out.format("%-40s:    ", "Karta służbowa nr ");
                temp.setNumerKartySluzbowej(scn.nextInt());
                System.out.format("%-40s:    ", "Limit kosztów/miesiąc (zł) ");
                temp.setLimitKosztow(scn.nextInt());
                System.out.println("------------------------------------------------------");
                System.out.println("[ENTER] - zapisz");
                System.out.println("[Q] - porzuć");
                String choice2 = scn.next();
                switch (choice2) {
                    case ("e"): {
                        return temp;
                    }
                    case ("q"): {
                        return null;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice2);
                }
            }
            case ("h"): {
                Handlowiec temp = new Handlowiec();
                temp.setStanowisko("Handlowiec");
                System.out.println("-----------------------------------------------------");
                do {
                    System.out.format("%-40s:    ", "Identyfikator PESEL ");
                    temp.setPesel(scn.next());
                    check = isPeselValid(temp.getPesel());
                    if (!check) System.out.println("Niepoprawny PESEL\n");
                }
                while (!check);
                System.out.format("%-40s:    ", "Imię ");
                temp.setImie(scn.next());
                System.out.format("%-40s:    ", "Nazwisko ");
                temp.setNazwisko(scn.next());
                System.out.format("%-40s:    ", "Wynagrodzenie (zł) ");
                temp.setWynagrodzenie(scn.nextInt());
                System.out.format("%-40s:    ", "Telefon służbowy numer ");
                temp.setTelefon(scn.nextInt());
                System.out.format("%-40s:    ", "Prowizja (%) ");
                temp.setProwizja(scn.nextBigDecimal());
                System.out.format("%-40s:    ", "Limit prowizji/miesiąc (zł) ");
                temp.setLimitProwizji(scn.nextInt());
                System.out.println("------------------------------------------------------");
                System.out.println("[ENTER] - zapisz");
                System.out.println("[Q] - porzuć");
                String choice2 = scn.next();
                switch (choice2) {
                    case ("e"): {
                        return temp;
                    }
                    case ("q"): {
                        return null;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice2);
                }
            }
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    Pracownik deleteEmployee(ArrayList<Pracownik> database) {
        System.out.println("3. Usuń pracownika \n");
        System.out.format("%-40s:    ", "Podaj Identyfikator PESEL ");
        Pracownik temp = new Pracownik();
        String pesel = scn.next();
        System.out.println("-----------------------------------------------------");

        boolean flag = false;
        for (Pracownik pracownik : database) {
            if (pracownik.getPesel().equals(pesel)) {
                temp = pracownik;
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Brak podanego nr PESEL w bazie \n");
            return null;
        } else if (temp instanceof Dyrektor) {
            Dyrektor dyrektor;
            dyrektor = (Dyrektor) temp;
            System.out.format("%-40s:    " + dyrektor.getImie() + "\n", "Imię ");
            System.out.format("%-40s:    " + dyrektor.getNazwisko() + "\n", "Nazwisko ");
            System.out.format("%-40s:    " + dyrektor.getStanowisko() + "\n", "Stanowisko ");
            System.out.format("%-40s:    " + dyrektor.getWynagrodzenie() + "\n", "Wynagrodzenie (zł) ");
            System.out.format("%-40s:    " + dyrektor.getTelefon() + "\n", "Telefon służbowy numer ");
            System.out.format("%-40s:    " + dyrektor.getDodatekSluzbowy() + "\n", "Dodatek służbowy (zł) ");
            System.out.format("%-40s:    " + dyrektor.getNumerKartySluzbowej() + "\n", "Karta służbowa nr ");
            System.out.format("%-40s:    " + dyrektor.getLimitKosztow() + "\n", "Limit kosztów/miesiąc (zł) ");
            System.out.println("-----------------------------------------------------");
            System.out.println("[ENTER] - potwierdź");
            System.out.println("[Q] - porzuć");
            String choice = scn.next();
            switch (choice) {
                case ("e"):
                    return temp;

                case ("q"):
                    return null;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } else if (temp instanceof Handlowiec) {
            Handlowiec handlowiec;
            handlowiec = (Handlowiec) temp;
            System.out.format("%-40s:    " + handlowiec.getImie() + "\n", "Imię ");
            System.out.format("%-40s:    " + handlowiec.getNazwisko() + "\n", "Nazwisko ");
            System.out.format("%-40s:    " + handlowiec.getStanowisko() + "\n", "Stanowisko ");
            System.out.format("%-40s:    " + handlowiec.getWynagrodzenie() + "\n", "Wynagrodzenie (zł) ");
            System.out.format("%-40s:    " + handlowiec.getTelefon() + "\n", "Telefon służbowy numer ");
            System.out.format("%-40s:    " + handlowiec.getProwizja() + "\n", "Prowizja (%) ");
            System.out.format("%-40s:    " + handlowiec.getLimitProwizji() + "\n", "Limit prowizji/miesiąc (zł) ");
            System.out.println("[ENTER] - potwierdź");
            System.out.println("[Q] - porzuć");
            String choice = scn.next();
            switch (choice) {
                case ("e"):
                    return temp;

                case ("q"):
                    return null;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
        return temp;
    }

    String[] backUp() {
        System.out.println("4. Kopia zapasowa \n");
        System.out.format("%-20s:    ", "[Z]achowaj/[O]dtwórz ");
        String choice = scn.next();
        String [] typeAndName = new String[2];
        switch (choice) {
            case "z": {
                System.out.println("-----------------------------------------------------");
                System.out.format("%-20s:    ", "Kompresja [G]zip/[Z]ip ");
                typeAndName[0]=(scn.next());
                System.out.format("%-20s:    ", "Nazwa pliku ");
                typeAndName[1] = scn.next();
                System.out.println("-----------------------------------------------------");
                System.out.println("[ENTER] - potwierdź");
                System.out.println("[Q] - porzuć");
                String choice2 = scn.next();
                switch (choice2) {
                    case ("e"): {
                        return typeAndName;
                    }
                    case ("q"): {
                        System.out.println();
                        typeAndName[0]="q";
                        return typeAndName;
                    }
                    default: {
                        throw new IllegalStateException("Unexpected value: " + choice2);
                    }
                }
            }
            case "o": {
                typeAndName[0]="o";
                System.out.println("-----------------------------------------------------");
                System.out.format("%-20s:    ", "Nazwa pliku ");
                typeAndName[1] = scn.next();
                System.out.println("-----------------------------------------------------");
                System.out.println("[ENTER] - potwierdź");
                System.out.println("[Q] - porzuć");
                String choice2 = scn.next();
                switch (choice2) {
                    case ("e"): {
                            return typeAndName;
                    }
                    case ("q"): {
                        typeAndName[0]="quit";
                        return typeAndName;
                    }
                    default: {
                        throw new IllegalStateException("Unexpected value: " + choice2);
                    }
                }
            }
        }
        return null;
    }

    public void peselIsInTheListError(){
        System.out.println("Podany PESEL już istnieje w bazie\n");
    }

    public void unexpectedFileNameError(){
        System.out.println("Niewłaściwe rozszerzenie. Nazwa pliku powinna kończyć się na .gzip lub .zip\n");
    }

}
