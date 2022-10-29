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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ListControllerB implements Initializable{
    public TableView<Book> tbBook;
    public static Book selectBook;
    public TextField searchValue;
    public TableColumn<Book,String> cId;
    public TableColumn<Book,String> cName;
    public TableColumn<Book,String> cAuthor;
    public TableColumn<Book,Integer> cPrice;
    public TableColumn<Book,Integer> cQty;
    public TableColumn<Book,String> cType;
    public TableColumn<Book,String> cPub;

    public TableColumn<Book,Button> cAction;
    public TableColumn<Book,Button> cActionR;

    private boolean sortPrice = true;
    private boolean sortQty = true;
    public static ObservableList<Book> ls2 = FXCollections.observableArrayList();







    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<>("code"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        cPub.setCellValueFactory(new PropertyValueFactory<>("nxb"));
        cType.setCellValueFactory(new PropertyValueFactory<>("type"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));
        cActionR.setCellValueFactory(new PropertyValueFactory<>("remove"));
        if (ls2.size()==0){
        ls2.add(new Book("hien","hien","a","hoa mai","hoa",9,10));
        ls2.add(new Book("kien","kien","a","hoa mai","hoa",100,100));

    }
        tbBook.setItems(ls2);
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
            if (tbBook.getSelectionModel().getSelectedItem() == null){
                throw new Exception("Choice Book want to edit");
            }
            EditController.editedBook = tbBook.getSelectionModel().getSelectedItem();

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
        tbBook.refresh();

    }

    public void sortByQty(ActionEvent actionEvent) {
        Collections.sort(ls2,new  Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return sortQty ? o1.getQty().compareTo(o2.getQty()) : o2.getQty().compareTo(o1.getQty());
            }
        });
        sortQty =!sortQty;
        tbBook.refresh();
    }




    public void search(ActionEvent actionEvent) {
        try {
            String s = searchValue.getText().toLowerCase();
            if (s.isEmpty()) {
                tbBook.setItems(ls2);
                throw new Exception("nhap ten can tim kiem");

            }
            ObservableList<Book> results = ls2.stream()
                    .filter(book -> book.getName().toLowerCase().contains(s))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tbBook.setItems(results);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }

    public void remove(ActionEvent actionEvent) {
        try {
            if (tbBook.getSelectionModel().getSelectedItem() == null){
                throw new Exception("Choice Book want to remove");
            }
            selectBook = tbBook.getSelectionModel().getSelectedItem();
            tbBook.getItems().remove(selectBook);


        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }


    }

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../listB/ListBook.fxml")));
        Scene sc = new Scene(listScene, 800, 600);
        Main.rootStages.setScene(sc);
    }
}
