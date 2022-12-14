package form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;




import java.util.Comparator;

public class StudentFormController {
    public   TextField Name;
    public   TextField Email;
    public  TextField Mark;

    public boolean nameFlg = false;
    public boolean markFlg = false;

    public boolean isMarkFlg() {
        return markFlg;
    }

    public void setMarkFlg() {
        this.markFlg =!this.nameFlg;
    }

    public boolean isNameFlg() {
        return nameFlg;
    }

    public void setNameFlg() {
        this.nameFlg = !this.nameFlg;
    }

    public ListView<StudentForm> lv;


    private ObservableList<StudentForm> ls =
            FXCollections.observableArrayList();


    public void submit(ActionEvent actionEvent) {
        String name = Name.getText();
        String email = Email.getText();
        Integer mark = Integer.valueOf(Mark.getText());

        StudentForm ct = new StudentForm(name,email,mark);
        ls.add(ct);
        print();


    }
    public void sortByName(ActionEvent actionEvent) {
        Comparator<StudentForm> studentComparator = Comparator.comparing(StudentForm::getName);
        if (this.isNameFlg()){
            ls.sort(studentComparator);
        }
        else {

        ls.sort(studentComparator.reversed());
        }
        this.setNameFlg();


    }
    public void sortByMark(ActionEvent actionEvent) {
        Comparator<StudentForm> studentComparators = Comparator.comparing(StudentForm::getMark);
        if (this.isMarkFlg()) {
            ls.sort(studentComparators);
        } else {
            ls.sort(studentComparators.reversed());
        }
        this.setMarkFlg();
    }


    public void print(){

        
        lv.setItems(ls);
    }



}

