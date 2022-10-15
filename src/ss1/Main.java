package ss1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.name = "Hien";
        s.age = 18;

        Student s2 = new Student();
        s2.age = 18;
        s2.name = "Kien";
        s.showInfo();
        s2.showInfo();


        TamGiac t = new TamGiac();

        Scanner sc = new Scanner(System.in);
        System.out.println("nhap canh 1");
        t.setCanh1(sc.nextInt());

        System.out.println("nhap canh 2");
        t.setCanh2(sc.nextInt());

        System.out.println("nhap canh 3");
        t.setCanh3(sc.nextInt());
//        Vuong.canh1 = 3;
//        Vuong.canh2 = 4;
//        Vuong.canh3 = 5;

        System.out.println("Dien tich bang = " + t.Dientich());
        System.out.println("DChu vi bang =" + t.ChuVi());
        HinhTron a = new HinhTron(4);
        System.out.println(a.chuVi());

    }
}
