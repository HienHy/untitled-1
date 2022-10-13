package bank;

public class Account {
    String id;
    String name;
    int balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



    public Account() {
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void credit(int amount) {
        if (amount > 0) {
          int a=this.balance += amount;
          this.balance= a;
        }

    }

    public void debit(int amount){
        if(amount >0 && amount < this.balance){
          int a =  this.balance -= amount;
            this.balance = a;
        } else {
            System.out.println("Thanh toán không thành công");
        }
    }

    public Account transTo(Account a2,int amount){
        if(this.balance > amount){
            a2.balance += amount;
            this.balance -=amount;
        }else {
            System.out.println("Chuyển tiền không thành công");
        }


        return a2;
    }






}
