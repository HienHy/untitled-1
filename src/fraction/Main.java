package fraction;


    public class Main {
        public static void main(String[] args){
            Fraction f = new Fraction(5,15);
            Fraction f1 = new Fraction(5,6);

            f.printPhanSo();
            f.rutGon();
            f.add(f1);
            f.sub(f1);
            f.div(f1);
        }

    }

