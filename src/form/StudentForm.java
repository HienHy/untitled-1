package form;



public class StudentForm {
   private String name;
   private String email;
   private Integer mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public StudentForm() {
    }

    public StudentForm(String name, String email, Integer mark) {
        this.name = name;
        this.email = email;
        this.mark = mark;
    }

    public String toString(){


        return this.name+"\t"+this.email+"\t"+this.mark+"\n";
    }
}
