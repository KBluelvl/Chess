package g58137.chess.view;

import g58137.chess.model.Game;
import g58137.chess.model.Model;
import g58137.chess.model.Position;
import g58137.chess.model.pieces.Piece;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class BoardGrid extends GridPane {

    private ImageView backgroundImageView;
    private Model model;
    private double startX;
    private double startY;

    public BoardGrid() {
        initModel();
        displayBackground();
    }

    private void displayBackground() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
                    backgroundImageView = new ImageView(getImage("bgGreen2"));
                }else {
                    backgroundImageView = new ImageView(getImage("bgGreen1"));
                }
                Piece piece = model.getPiece(new Position(j,i));
                if(piece == null) {
                    this.add(backgroundImageView, i, 7-j);
                } else{
                    StackPane stackPane = new StackPane();
                    ImageView pieceImageView = new ImageView(getImage(piece.getName()));
                    stackPane.getChildren().addAll(backgroundImageView,pieceImageView);
                    makeDraggable(pieceImageView);
                    this.add(stackPane, i, 7-j);
                }
            }
        }
    }

    private Image getImage(String str) {
        switch (str) {
            case "bgGreen1" -> str = "img/boardGreen1.png";
            case "bgGreen2" -> str = "img/boardGreen2.png";
            case "BLACKRook" -> str = "img/blackRook.png";
            case "WHITERook" -> str = "img/whiteRook.png";
            case "BLACKBishop" -> str = "img/blackBishop.png";
            case "WHITEBishop" -> str = "img/whiteBishop.png";
            case "BLACKKing" -> str = "img/blackKing.png";
            case "WHITEKing" -> str = "img/whiteKing.png";
            case "BLACKQueen" -> str = "img/blackQueen.png";
            case "WHITEQueen" -> str = "img/whiteQueen.png";
            case "BLACKPawn" -> str = "img/blackPawn.png";
            case "WHITEPawn" -> str = "img/whitePawn.png";
            case "BLACKKnight" -> str = "img/blackKnight.png";
            case "WHITEKnight"-> str = "img/whiteKnight.png";
        }
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(str)),64,64,true,true);
    }

    private void initModel() {
        model = new Game();
        model.start();
    }

    private void makeDraggable(Node node){
        node.setOnMousePressed(e -> {
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();
        });
        node.setOnMouseDragged(e ->{
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });
    }
}
