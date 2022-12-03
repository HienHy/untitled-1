package demoGennerics;

public class Main {
    public static void main(String[] args) {
        Demo<String> ds = new Demo<>();
        Demo<Integer> os = new Demo<>();
        ds.element="hello";
        os.element=1223;

        ds.print("hello world");

    }
}

