package tiendien;

public class KHNN extends KHVN{
    public String qt;

    public KHNN() {

    }

    public KHNN(int customerId, String name, String date, String dt, double sl,String qt) {
        super(customerId, name, date, dt, sl);
        this.qt = qt;
    }

    @Override
    public double TT(){
        double tt = 0;
        tt = this.sl*2000;
        return tt;
    }

}
