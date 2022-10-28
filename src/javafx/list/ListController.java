package javafx.list;

import javafx.Contact;
import javafx.Main;
import javafx.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.create.CreateController;
import javafx.edit.EditController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;


import javax.annotation.Resources;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;


public class ListController {
    private boolean sortName =true;
    private boolean sortMark =true;
    public static ObservableList<Student> ls = FXCollections.observableArrayList();

    public ListView<Student> lv2;

    @FXML
    protected void initialize() {
        lv2.setItems(ls);
    }


    public ListController() {

    }


    public void CreateStudent(ActionEvent actionEvent) throws Exception {
        Parent createForm = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("../create/Create.fxml"))));
        Scene sc = new Scene(createForm, 800, 600);
        Main.rootStage.setScene(sc);


    }

    public void edit() throws IOException {
        try {
            if (lv2.getSelectionModel().getSelectedItem()==null){
                throw new Exception("Enter student want to edit");
            }
            EditController.editedStudent = lv2.getSelectionModel().getSelectedItem();
            Parent createForm = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("../edit/Edit.fxml"))));
            Scene sc = new Scene(createForm, 800, 600);
            Main.rootStage.setScene(sc);
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }




    }

    public void sortByName(ActionEvent actionEvent) {
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortName?o1.getName().compareTo(o2.getName()):o2.getName().compareTo(o1.getName());
            }
        });
        sortName =!sortName;
        lv2.refresh();
    }

    public void sortByMark(ActionEvent actionEvent) {
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortMark?o1.getMark().compareTo(o2.getMark()):o2.getMark().compareTo(o1.getMark());
            }
        });
        sortMark =!sortMark;
        lv2.refresh();
    }
}
