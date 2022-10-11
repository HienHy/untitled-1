    package fraction;


        public class Main {
            public static void main(String[] args){
                Fraction p = new Fraction(5,15);
                Fraction ps = new Fraction(5,6);

                p.printPhanSo();
                p.rutGon();
                p.ngichDao();
                p.printPhanSo();
                p.add(ps);
                p.sub(ps);
                p.div(ps);
                p.mul(ps);
            }



        }

