package pracownicy;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Model {
    public ArrayList<Pracownik> database = new ArrayList<>();

    public void makeGzip(String fileName) {
        FileOutputStream fos;
        GZIPOutputStream gos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(fileName+".gzip");
            gos = new GZIPOutputStream(fos);
            oos = new ObjectOutputStream(gos);
            oos.writeObject(database);
            oos.flush();
            oos.close();
            gos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makeZip(String fileName) {
        FileOutputStream fos;
        ZipOutputStream zos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(fileName+".zip");
            oos = new ObjectOutputStream(fos);
            zos = new ZipOutputStream(oos);

            oos.writeObject(database);
            oos.flush();
            zos.close();
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void loadGzipFile(String fileName) {
        FileInputStream fis;
        GZIPInputStream gis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(fileName);
            gis = new GZIPInputStream(fis);
            ois = new ObjectInputStream(gis);

            database = (ArrayList<Pracownik>) ois.readObject();
            ois.close();
            gis.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
    }

    public void loadZipFile(String fileName) {
        FileInputStream fis;
        ZipInputStream zis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            zis = new ZipInputStream(ois);

            database = (ArrayList<Pracownik>) ois.readObject();
            zis.close();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
    }

    public boolean isPeselInTheList(String pesel_to_check){
        for (Pracownik pracownik : database) {
            if (pracownik.getPesel().equals(pesel_to_check)) {
                return true;
            }
        }
        return false;
    }
}
