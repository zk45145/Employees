package pracownicy;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dyrektor extends Pracownik implements Serializable {
    protected
    BigDecimal dodatekSluzbowy;
    int numerKartySluzbowej;
    double limitKosztow;

    public void setDodatekSluzbowy(BigDecimal dodatekSluzbowy) {
        this.dodatekSluzbowy = dodatekSluzbowy;
    }

    public BigDecimal getDodatekSluzbowy() {
        return dodatekSluzbowy;
    }

    public void setNumerKartySluzbowej(int numerKartySluzbowej) {
        this.numerKartySluzbowej = numerKartySluzbowej;
    }

    public int getNumerKartySluzbowej() {
        return numerKartySluzbowej;
    }

    public void setLimitKosztow(double limitKosztow) {
        this.limitKosztow = limitKosztow;
    }

    public double getLimitKosztow() {
        return limitKosztow;
    }
}
