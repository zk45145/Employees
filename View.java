package pracownicy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class View {
    protected
    Scanner scn = new Scanner(System.in);

    void showMenu() {
        System.out.println("MENU\n");
        System.out.println("   1. Lista pracowników\n");
        System.out.println("   2. Dodaj pracownika\n");
        System.out.println("   3. Usuń pracownika\n");
        System.out.println("   4. Kopia zapasowa\n");
        System.out.println("\nWybór> ");
    }

    void showDirector(int current, int all, Dyrektor dyrektor) {
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

    void showSalesman(int current, int all, Handlowiec handlowiec) {
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


    Pracownik addEmployee() {
        System.out.println("2. Dodaj pracownika\n\n");
        System.out.format("%-20s    ", "[D]yrektor/[H]andlowiec:     ");
        String choice = scn.next();


        switch (choice) {
            case "d": {
                Dyrektor temp = new Dyrektor();
                temp.setStanowisko("Dyrektor");
                System.out.println("-----------------------------------------------------");
                PeselValidator isPeselValid;
                do {
                    System.out.format("%-40s:    ", "Identyfikator PESEL ");
                    temp.setPesel(scn.next());
                    isPeselValid = new PeselValidator(temp.getPesel());
                }
                while (!isPeselValid.isValid());
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
                System.out.format("%-40s:    ", "Identyfikator PESEL ");
                temp.setPesel(scn.next());
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

    Pracownik deleteEmployee(ArrayList<Pracownik> List) {
        System.out.println("3. Usuń pracownika \n");
        System.out.format("%-40s:    ", "Podaj Identyfikator PESEL ");
        Pracownik temp = new Pracownik();
        String pesel = scn.next();
        System.out.println("-----------------------------------------------------");

        boolean flag = false;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getPesel().equals(pesel)) {
                temp = List.get(i);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("Brak podanego nr PESEL w bazie \n");
            return null;
        } else if (temp instanceof Dyrektor) {
            Dyrektor dyrektor = new Dyrektor();
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
            Handlowiec handlowiec = new Handlowiec();
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

    void backUp(ArrayList<Pracownik> List) {
        System.out.println("4. Kopia zapasowa \n");
        System.out.format("%-20s:    ", "[Z]achowaj/[O]dtwórz ");
        String choice = scn.next();
        switch (choice) {
            case "z": {
                System.out.println("-----------------------------------------------------");
                System.out.format("%-20s:    ", "Kompresja [G]zip/[Z]ip ");
                String gzipOrZip = scn.next();
                System.out.format("%-20s:    ", "Nazwa pliku ");
                String fileName = scn.next();
                System.out.println("-----------------------------------------------------");
                System.out.println("[ENTER] - potwierdź");
                System.out.println("[Q] - porzuć");
                String choice2 = scn.next();
                switch (choice2) {
                    case ("e"): {
                        if (gzipOrZip.equals("g")) {
                            makeGzip(List, fileName);
                            break;
                        }
                        if (gzipOrZip.equals("z")) {
                            makeZip(List, fileName);
                            break;
                        }
                    }
                    case ("q"): {
                        System.out.println("");
                        break;
                    }
                    default: {
                        throw new IllegalStateException("Unexpected value: " + choice2);
                    }
                }
                break;
            }
            case "o": {
                System.out.println("-----------------------------------------------------");
                System.out.format("%-20s:    ", "Nazwa pliku ");
                String fileName = scn.next();
                System.out.println("-----------------------------------------------------");
                System.out.println("[ENTER] - potwierdź");
                System.out.println("[Q] - porzuć");
                String choice2 = scn.next();
                switch (choice2) {
                    case ("e"): {
                        if (fileName.endsWith(".gzip")){
                            List.clear();
                            List.addAll(loadGzipFile (fileName));
                            break;
                        }
                        else if (fileName.endsWith(".zip")){
                            List.clear();
                            List.addAll(loadZipFile (fileName));
                            break;
                        }
                        else System.out.println("Niewłaściwe rozszerzenie. Nazwa pliku powinna kończyć się na .gzip lub .zip\n");
                    }
                    case ("q"): {
                        break;
                    }
                    default: {
                        throw new IllegalStateException("Unexpected value: " + choice2);
                    }
                }
            }
            break;
        }
    }

    public static void makeGzip(List vlo, String fileName) {
        FileOutputStream fos = null;
        GZIPOutputStream gos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName+".gzip");
            gos = new GZIPOutputStream(fos);
            oos = new ObjectOutputStream(gos);
            oos.writeObject(vlo);
            oos.flush();
            oos.close();
            gos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void makeZip(List vlo, String fileName) {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName+".zip");
            oos = new ObjectOutputStream(fos);
            zos = new ZipOutputStream(oos);

            oos.writeObject(vlo);
            oos.flush();
            zos.close();
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static ArrayList<Pracownik> loadGzipFile(String fileName) {
        ArrayList<Pracownik> List = null;
        FileInputStream fis = null;
        GZIPInputStream gis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            gis = new GZIPInputStream(fis);
            ois = new ObjectInputStream(gis);

            List = (ArrayList<Pracownik>) ois.readObject();
            ois.close();
            gis.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return List;
    }

    public static ArrayList<Pracownik> loadZipFile(String fileName) {
        ArrayList<Pracownik> List = null;
        FileInputStream fis = null;
        ZipInputStream zis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            zis = new ZipInputStream(ois);

            List = (ArrayList<Pracownik>) ois.readObject();
            zis.close();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return List;
    }

}
