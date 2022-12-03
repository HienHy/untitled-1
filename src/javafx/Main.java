package javafx;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class Main extends Application {
    public static Stage rootStage;
    public static ResourceBundle _msg =ResourceBundle.getBundle("i18n.messages");


    public static void main(String[] args) {
        Locale.setDefault(new Locale("vi","VN"));
        _msg =ResourceBundle.getBundle("i18n.messages");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("list/List.fxml")));
        primaryStage.setTitle("T2204M JavaFX");
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.show();
    }
}
