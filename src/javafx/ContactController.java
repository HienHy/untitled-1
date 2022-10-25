package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

    public void submit(ActionEvent actionEvent) throws IOException {
            String name = txtName.getText();

            String email = txtEmail.getText();
            Contact ct=new Contact(email,name);
            ls.add(ct);
            print();


    }
    public void  print(){
        lv.setItems(ls);
    }




    public void Listview(ActionEvent actionEvent) throws IOException {
        Parent contactPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listview.fxml")));
        Scene sc =new Scene(contactPage,800,600);
        Main.rootStage.setScene(sc);
        Main.rootStage.setTitle("Listview");
    }

    public void form(ActionEvent actionEvent) throws IOException {
        Parent contactPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("form_.fxml")));
        Scene sc =new Scene(contactPage,800,600);
        Main.rootStage.setScene(sc);
        Main.rootStage.setTitle("Form");
    }




}
