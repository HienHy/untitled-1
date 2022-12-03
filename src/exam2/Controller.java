package exam2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class Controller {

    public void CreateBook(ActionEvent actionEvent) throws IOException {
        Parent createBook = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/exam2/create/CreateBook.fxml"))));
        Scene sb = new Scene(createBook, 800, 600);
        exam2.Main.rootStages.setScene(sb);
    }

    public void display(ActionEvent actionEvent) throws IOException {
        Parent listSceneB = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/exam2/list/ListBook.fxml")));
        Scene sc = new Scene(listSceneB, 800, 600);
        exam2.Main.rootStages.setScene(sc);
    }
}
