package book.listB;

import book.Book;
import book.Main;

import book.edit.EditController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Collections;

public class ListControllerB implements Initializable{

    public static Book selectBook;
    public TextField searchValue;
    private boolean sortPrice = true;
    private boolean sortQty = true;
    public static ObservableList<Book> ls2 = FXCollections.observableArrayList();


    public ListView<Book> lv;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lv.setItems(ls2);
    }
    public ListControllerB() {
    }

    public void CreateBook(ActionEvent actionEvent) throws Exception {
        Parent createBook = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("../createB/CreateBook.fxml"))));
        Scene sb = new Scene(createBook, 800, 600);
        Main.rootStages.setScene(sb);
    }
    public void edit(){
        try {
            if (lv.getSelectionModel().getSelectedItem() == null){
                throw new Exception("Choice Book want to edit");
            }
            EditController.editedBook = lv.getSelectionModel().getSelectedItem();

            Parent editBook = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("../edit/EditBook.fxml"))));
            Scene se = new Scene(editBook, 800, 600);
            Main.rootStages.setScene(se);
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText(e.getMessage());
            alert.show();

        }
    }



    public void sortByPrice(ActionEvent actionEvent) {
        Collections.sort(ls2,new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return sortPrice ? o1.getPrice().compareTo(o2.getPrice()) : o2.getPrice().compareTo(o1.getPrice());
            }
        });
        sortPrice =!sortPrice;
        lv.refresh();

    }

    public void sortByQty(ActionEvent actionEvent) {
        Collections.sort(ls2,new  Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return sortQty ? o1.getQty().compareTo(o2.getQty()) : o2.getQty().compareTo(o1.getQty());
            }
        });
        sortQty =!sortQty;
        lv.refresh();
    }




    public void search(ActionEvent actionEvent) {

      String filter_value = searchValue.getText().toLowerCase();




    }


    public void remove(ActionEvent actionEvent) {
        try {
            if (lv.getSelectionModel().getSelectedItem() == null){
                throw new Exception("Choice Book want to remove");
            }
            selectBook = lv.getSelectionModel().getSelectedItem();
            lv.getItems().remove(selectBook);


        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }


    }
}
