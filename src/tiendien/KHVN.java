package tiendien;

public class KHVN {
    public int customerId;
    public String name;
    public String date;
    public String dt;
    public double sl;



    public KHVN() {
    }

    public KHVN(int customerId, String name, String date, String dt, double sl) {
        this.customerId = customerId;
        this.name = name;
        this.date = date;
        this.dt = dt;
        this.sl = sl;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public double getSl() {
        return sl;
    }

    public void setSl(Double sl) {
        this.sl = sl;
    }

    public double TT() {
        double tt = 0;
        if (this.sl <= 50) {
            tt = (this.sl * 1000);
        }

        if (this.sl > 50 && this.sl <= 100) {
            tt = (this.sl - 50) * 1200 + (50 * 1000);
        }

        if (this.sl > 100 && this.sl <= 200) {
            tt = (this.sl - 100) * 1500 + (50 * 1000) + (50 * 1200);
        }

        if (this.sl > 200) {

            tt = (this.sl-200) * 2000+(50 * 1000) + (50 * 1200)+(100*1500);

        }
        return tt;

    }
}