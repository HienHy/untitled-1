package exam;

public class ComplexDemo {
    public static void main(String[] args) {
        Complex a = new Complex(5.9,3.4);
        Complex a2=new Complex(2.4,1.5);

        a.add(a2);
        System.out.println(a);
        a.subtract(a2);
        System.out.println(a);
        a.multiply(a2);
        System.out.println(a);
        a.divide(a2);
        System.out.println(a);




    }
}
