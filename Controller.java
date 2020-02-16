package pracownicy;

public class Controller {
    protected
    View view;
    Pracownik pracownik;
    public Controller(View view, Pracownik pracownik){
        this.view = view;
        this.pracownik = pracownik;
    }
}
