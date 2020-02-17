package pracownicy;

import java.io.Serializable;
import java.math.BigDecimal;

public class Handlowiec extends Pracownik implements Serializable {
    private
    BigDecimal prowizja;
    double limitProwizji;

    public void setProwizja(BigDecimal prowizja) {
        this.prowizja = prowizja;
    }

    public BigDecimal getProwizja() {
        return prowizja;
    }

    public void setLimitProwizji(double limit_prowizji) {
        this.limitProwizji = limit_prowizji;
    }

    public double getLimitProwizji() {
        return limitProwizji;
    }
}
