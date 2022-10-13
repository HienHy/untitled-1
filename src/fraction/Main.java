    package fraction;


        public class Main {
            public static void main(String[] args){
                Fraction p = new Fraction(5,15);
                Fraction ps = new Fraction(5,6);
                p.printPhanSo();
                ps.printPhanSo();
                p.ngichDao();
                p.printPhanSo();
                Fraction a1 = p.mul(ps);
                Fraction a2 = p.sub(ps);
                Fraction a3 = p.div(ps);
                Fraction a4 = p.add(ps);
                a4.printPhanSo();
                a3.printPhanSo();
                a2.printPhanSo();
                a1.printPhanSo();





            }



        }

