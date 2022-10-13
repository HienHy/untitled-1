package bank;

public class Main {
    public static void main(String[] args) {
        Account a =new Account("abc","16373",5);
        a.credit(5);
        System.out.println(a.balance);
        a.debit(3);
        Account a2  = new Account("sad","sfdsf",5);
        a.transTo(a2,1);
        System.out.println(a2.balance);



    }
}
