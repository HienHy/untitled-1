package threads;

public class Number {
    int x=0;
    int y=0;
    public synchronized void changeNumber(){
        x++;
        y++;

    }
    public synchronized void printNumber(){
        System.out.println("x = "+x);
        System.out.println("y = "+y);
    }
}
