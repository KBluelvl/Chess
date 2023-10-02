package g58137.chess.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class ResultController {
    @FXML
    private VBox root;
    private Stage primaryStage;

    public void getPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }

    public void rematch() {
        BoardGrid board = new BoardGrid(primaryStage);
        Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    public void back() {
        Stage stage = (Stage) root.getScene().getWindow();
        URL FxmlLocation = getClass().getResource("Menu.fxml");
        FXMLLoader loader = new FXMLLoader(FxmlLocation);
        try {
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            stage.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
