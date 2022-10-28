
package javafx;

public class Student {
    private Integer index;
    private String name;
    private String email;
    private Integer mark;
    private String gender;

    public Student(String name, String email, Integer mark, Integer index,String gender) {
        this.name = name;
        this.email = email;
        this.mark = mark;
        this.index = index;
        this.gender=gender;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return this.getName()+"\n"+this.getMark()+"\n"+this.gender;
    }
}
