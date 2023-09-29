package g58137.chess.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxController {
    @FXML
    private VBox root;
    @FXML
    private Button exitButton;
    Stage stage;

    public void getConsole() {
        stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    public void logout() {
        stage = (Stage) root.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
}
