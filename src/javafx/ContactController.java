package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



public class ContactController {
public TextField txtName;
public ListView<Contact> lv;
public TextField txtEmail;


private ObservableList<Contact> ls= FXCollections.observableArrayList();

    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();

        String email = txtEmail.getText();
        Contact ct=new Contact(email,name);
        ls.add(ct);
        print();
    }
    public void  print(){
        lv.setItems(ls);
    }
}
