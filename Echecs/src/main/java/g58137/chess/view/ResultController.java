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

    public void initialize(){

    }

    public void rematch() {
        Stage stage = (Stage) root.getScene().getWindow();
        BoardGrid board = new BoardGrid(stage);
        Scene scene = new Scene(board);
        stage.setScene(scene);
    }

    public void back() {
        Stage stage = (Stage) root.getScene().getWindow();
        URL FxmlLocation = getClass().getResource("Menu.fxml");
        FXMLLoader root = new FXMLLoader(FxmlLocation);
        try {
            Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
