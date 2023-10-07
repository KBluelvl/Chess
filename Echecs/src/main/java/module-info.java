module g.chess.Echecs {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;

    opens g58137.chess.view to javafx.fxml;
    exports g58137.chess.view;
}