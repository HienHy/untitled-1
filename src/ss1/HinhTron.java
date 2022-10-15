package ss1;

public class HinhTron {
    double r;

    public HinhTron() {
    }

    public HinhTron(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
   public double chuVi(){
        double chuVi = 2 * Math.PI * this.r;
        return chuVi;

   }
   public double dienTich(){
        double dienTich = Math.PI * Math.pow(this.r, 2);
        return dienTich;
   }
}
