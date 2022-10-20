package student;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StudentController {
  public   TextField Age;
  public   TextField Email;
  public   TextField Name;
  public   TextField PhoneNumber;
   public Text txtName;

   public Text txtEmail;
  public   Text txtAge;
   public Text txtPhoneNumber;
    public void submit(ActionEvent actionEvent) {
        String name = Name.getText();
        txtName.setText(name);

        String email = Email.getText();
        txtEmail.setText(email);

        String age = Age.getText();
        txtAge.setText(age);

        String phoneNumber = PhoneNumber.getText();
        txtPhoneNumber.setText(phoneNumber);
    }



}
