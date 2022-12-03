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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import javax.annotation.Resources;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.sql.*;


public class ListController {
    public TableView<Student> tbStudent;
    public TableColumn<Student,String> cName;
    public TableColumn<Student,String> cEmail;
    public TableColumn<Student,Integer> cMark;
    public TableColumn<Student,String> cGender;
    public TableColumn<Student, Button> cAction;
    public final static String connectionString = "jdbc:mysql://localhost:3306/t2204m";
    public final static String user = "root";
    public final static String pwd = "root";
    public Button fxCreate;
    public Button fxSort;


//Lay du lieu tu database

    private boolean sortName =true;
    private boolean sortMark =true;
    public  ObservableList<Student> ls = FXCollections.observableArrayList();



    @FXML
    protected void initialize() {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));



        fxCreate.setText(Main._msg.getString("create"));
        fxSort.setText(Main._msg.getString("sortName"));
        cName.setText(Main._msg.getString("name"));
        cEmail.setText(Main._msg.getString("email"));
        cGender.setText(Main._msg.getString("gender"));
        cAction.setText(Main._msg.getString("edit"));
        cMark.setText(Main._msg.getString("mark"));
        cMark.setText(Main._msg.getString("mark"));



        //lay data tu database cho vao list
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement stt   =   conn.createStatement();
            String sql_txt = "select * from student";
            ResultSet rs = stt.executeQuery(sql_txt);
            while (rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int mark = rs.getInt("mark");
                String gender = rs.getString("gender");
                Student s = new Student(name,email,mark,id,gender);
                ls.add(s);
            }
        }catch (Exception e){
            System.out.println();

        }


        tbStudent.setItems(ls);
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
            if (tbStudent.getSelectionModel().getSelectedItem()==null){
                throw new Exception("Enter student want to edit");
            }

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
        tbStudent.refresh();
    }

    public void sortByMark(ActionEvent actionEvent) {
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortMark?o1.getMark().compareTo(o2.getMark()):o2.getMark().compareTo(o1.getMark());
            }
        });
        sortMark =!sortMark;
        tbStudent.refresh();
    }
}
