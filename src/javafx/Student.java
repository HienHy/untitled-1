
package javafx;

import javafx.edit.EditController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Objects;

public class Student {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer index) {
        this.id = index;
    }

    private String name;
    private String email;
    private Integer mark;
    private String gender;
    private Button edit;



    public Student(String name, String email, Integer mark,Integer id, String gender) {
        this.name = name;
        this.email = email;
        this.mark = mark;
        this.gender=gender;
        this.id = id;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try {
                EditController.editedStudent = this;
                Parent createForm = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/javafx/edit/Edit.fxml"))));
                Scene sc = new Scene(createForm, 800, 600);
                Main.rootStage.setScene(sc);

            }catch (Exception e){

            }

        });
    }
    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return this.getName()+"\n"+this.getMark()+"\n"+this.gender;
    }
}
