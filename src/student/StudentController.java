package student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StudentController {
  public   TextField Age;
  public   TextField Email;
  public  TextField Address;
  public   TextField Name;
  public   TextField PhoneNumber;
  public ListView<Student> lv;


  private ObservableList<Student> ls =
          FXCollections.observableArrayList();

    public void submit(ActionEvent actionEvent) {
        String name = Name.getText();


        String email = Email.getText();
        String address =Address.getText();

        String age = Age.getText();

        String phoneNumber = PhoneNumber.getText();

        Student ct = new Student(name,email,address,age,phoneNumber);
        ls.add(ct);
        print();


    }
    public void print(){
        
        lv.setItems(ls);
    }



}
