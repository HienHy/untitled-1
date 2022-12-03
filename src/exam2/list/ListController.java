package exam2.list;


import exam2.Book;
import exam2.impls.BookRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public TableColumn<Book,String> cId;
    public TableColumn<Book,String> cName;
    public TableColumn<Book,String> cAuthor;
    public TableColumn<Book,Integer> cPrice;
    public TableView<Book> tbBook;
    public static ObservableList<Book> ls = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<>("code"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            BookRepository sr = new BookRepository();
            ls.addAll(sr.all());
            tbBook.setItems(ls);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }




    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent listSceneB = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/exam2/Menu.fxml")));
        Scene sc = new Scene(listSceneB, 800, 600);
        exam2.Main.rootStages.setScene(sc);
    }

    public void CreateBook(ActionEvent actionEvent) throws IOException {
        Parent createBook = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/exam2/create/CreateBook.fxml"))));
        Scene sb = new Scene(createBook, 800, 600);
        exam2.Main.rootStages.setScene(sb);
    }
}
