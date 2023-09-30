package g58137.chess.view;

import g58137.chess.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class FxView extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Chess");
        URL FxmlLocation = getClass().getResource("Menu.fxml");
        FXMLLoader root = new FXMLLoader(FxmlLocation);
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        System.exit(0);
    }
}
