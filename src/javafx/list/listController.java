package javafx.list;

import javafx.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import student.Student;

import java.util.Objects;

public class listController {
    public ListView<Student> lv;
    public static ObservableList<Student> ls= FXCollections.observableArrayList();
    public void CreateStudent(ActionEvent actionEvent)throws Exception {
        Parent createForm = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../create/Create.fxml")));
        Scene sc=new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);

    }
}
