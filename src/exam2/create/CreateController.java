package exam2.create;



import exam2.Book;
import exam2.enums.RepoType;
import exam2.factory.Factory;
import exam2.impls.BookRepository;
import exam2.list.ListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class CreateController {
    public TextField txtCode;
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtPrice;

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent listScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../list/ListBook.fxml")));
        Scene sc = new Scene(listScene, 800, 600);
        exam2.Main.rootStages.setScene(sc);
    }

    public void save(ActionEvent actionEvent) {

        try {
            Integer cpc =Integer.parseInt(txtPrice.getText());

                Book s = new Book(txtCode.getText(), txtName.getText(),txtAuthor.getText(),cpc);
                BookRepository csc =(BookRepository) Factory.createRepository(RepoType.Book);
                if (csc.create(s)) {
                    backToList(null);
                    return;
                }

            throw new Exception("Không thêm được dữ liệu");

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }


    }
}
