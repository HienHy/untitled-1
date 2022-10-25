package javafx.create;
import javafx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.Objects;

public class CreateController {
    public void backTolist(ActionEvent actionEvent)throws Exception {
        Parent listScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../list/list.fxml")));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent actionEvent) {

    }
}
