package fraction;

public class Fraction {

    int tuSo;
    int mauSo;

    public Fraction() {
    }

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
        this.rutGon();
    }

   public void printPhanSo() {
        System.out.println(getTuSo() + "/" + getMauSo());
    }



    public void ngichDao() {
        int tg = getTuSo();
        if(tg !=0){
        setTuSo(mauSo);
        setMauSo(tg);
        }

    }

   public void rutGon() {
        int ucln = 1;

        for (int i =Math.abs(getTuSo());i>1;i--){
            if(tuSo%i==0 && mauSo %i ==0){
                ucln = i;
                break;
            }
        }

        setTuSo(tuSo/ucln);
        setMauSo(mauSo/ucln);


    }

    public Fraction add(Fraction ps) {
        Fraction t = new Fraction();
        t.setMauSo(this.getMauSo()* ps.getMauSo());
        t.setTuSo(this.getTuSo()*ps.getMauSo() + this.getMauSo()*ps.getTuSo());
        t.rutGon();
        return t;


    }

    public Fraction sub(Fraction ps) {
        int ts = this.getTuSo()* ps.getMauSo() - this.getMauSo()*ps.getTuSo();
        int ms = this.getMauSo()* ps.getMauSo();
        Fraction mb = new Fraction(ts,ms);
        return mb;



    }

    public Fraction mul(Fraction ps) {
       return new Fraction (getTuSo() * ps.getMauSo(),getMauSo() * ps.getTuSo());
    }


    public Fraction div(Fraction ps) {
        ps.ngichDao();
        return this.mul(ps);
    }


}
