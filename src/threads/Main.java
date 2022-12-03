package threads;

public class Main {
    public static void main(String[] args) {
        BankAccount ba=new BankAccount();
     new Thread(()->{
         for (int i = 0;i<10;i++){
             ba .deposit(200);
             try {
                 Thread.sleep(1000);
             }catch (InterruptedException e){

             }
         }
     }).start();
     new  Thread(()->{
         ba.withdraw(1000);
     }).start();
    }















    public static void main3(String[] args) {
        Number n =new Number();
        Runnable r=()->{
            for (int i= 0;i<20;i++){
                  n.changeNumber();
                  n.printNumber();

                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
        };



        Thread t1 =new Thread(r);
        Thread t2 =new Thread(r);
        t1.start();
//        try {
//            t1.join();
//
//        }catch (Exception e){
//
//        }
        t2.start();
    }






















    public static void main2(String[] args) {
        DemoThread d =new DemoThread();
        d.start();


        SubRun s = new SubRun();
        Thread t =new Thread(s);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();


        new Thread(()->{

        }).start();



        Runnable r2 =()->{

        };

        for (int i= 0;i<20;i++){
            System.out.println("Main i ="+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }

    }
}
