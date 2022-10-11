package fraction;

public class Fraction {

    int tuSo;
    int mauSo;
    int uocChung;

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public Fraction(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    void printPhanSo() {
        System.out.println(getTuSo() + "/" + getMauSo());
    }

    int uocChung() {
        for (int i = 1; i <= tuSo && i <= mauSo; i++) {
            if (tuSo % i == 0 && mauSo % i == 0)
                uocChung = i;
        }
        return uocChung;
    }

    void ngichDao() {
        int tg = tuSo;
        tuSo = mauSo;
        mauSo = tg;

    }

    void rutGon() {
        System.out.println((getTuSo() / uocChung()) + "/" + (getMauSo() / uocChung()));
    }

    void add(Fraction ps) {
        int ts = getTuSo() * ps.getMauSo() + getMauSo() * ps.getTuSo();
        int ms = getMauSo() * ps.getMauSo();
        System.out.println(ts + "/" + ms);
    }

    void sub(Fraction ps) {
        System.out.println(getTuSo() * ps.getTuSo() + "/" + getMauSo() * ps.getMauSo());
    }

    void div(Fraction ps) {
        System.out.println(getTuSo() * ps.getMauSo() + "/" + getMauSo() * ps.getTuSo());
    }


    void mul(Fraction ps) {
        System.out.println(getTuSo() * ps.getTuSo() + "/" + getMauSo() * ps.getMauSo());
    }


}
