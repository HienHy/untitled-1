package student;

public class Student {
  private   String name;
  private   String email;
  private  String address;
  private   String age;
  private   String phoneNumber;

    public Student(String name, String email,String address, String age, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){

        return this.name+"\t"+this.email+"\t"+this.address+"\t"+this.age+"\t"+this.phoneNumber+"\n";
    }
}
