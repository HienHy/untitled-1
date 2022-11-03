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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;


public class EditController implements Initializable {


    public static Student editedStudent;

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
          Integer p = Integer.parseInt(txtMark.getText());
            if (    p < 0 || p > 10)
                throw new Exception("Enter Mark 0 ->10");

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(ListController.connectionString,ListController.user,ListController.pwd);
            Statement stt   =   conn.createStatement();
            String sql_txt1 = "UPDATE student SET name = '"+txtName.getText()+"',Email = '"+txtEmail.getText()+"',mark = "+p+", gender ='"+cbGender.getValue()+"'  WHERE id ='"+ editedStudent.getId()+"'";





            stt.executeUpdate(sql_txt1);
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