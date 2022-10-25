package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class ContactController implements Initializable {
public TextField txtName;
public ListView<Contact> lv;
public TextField txtEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ls.add(new Contact("nguyen dinh hien","hien@gmail.com"));
        ls.add(new Contact("luong trung kien","kien@gmail.com"));
        print();

    }

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
