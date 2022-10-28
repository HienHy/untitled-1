package javafx.edit;
import book.Book;
import javafx.Main;
import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.list.ListController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditController implements Initializable {


    public static Student editedStudent;
    public static Book editedBook;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ComboBox<String> cbGender;

    public EditController() {

    }

    public void backToList() throws Exception {
        Parent listScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../list/list.fxml")));
        Scene sc = new Scene(listScene, 800, 600);
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent actionEvent) {
        try{
            txtName.getText();
            txtMark.getText();
            txtEmail.getText();
            if (Integer.parseInt(txtMark.getText()) < 0 || Integer.parseInt(txtMark.getText()) > 10)
                throw new Exception("Enter Mark 0 ->10");
            ListController.ls.set(editedStudent.getIndex(),new Student(txtName.getText(), txtEmail.getText(), Integer.parseInt(txtMark.getText()), editedStudent.getIndex(),cbGender.getValue()));
            backToList();


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setText(editedStudent.getName());
        txtEmail.setText(editedStudent.getEmail());
        txtMark.setText(editedStudent.getMark().toString());
        ObservableList<String> genders = FXCollections.observableArrayList();
        genders.add("Nam");
        genders.add("Nữ");
        genders.add("Khác");
        cbGender.setItems(genders);
        cbGender.setValue(editedStudent.getGender());

    }
}