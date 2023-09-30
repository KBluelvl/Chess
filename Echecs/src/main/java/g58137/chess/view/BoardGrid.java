package g58137.chess.view;

import g58137.chess.model.Direction;
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
    private final double  SQUARE_SIZE = 64;

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
                    makeDraggable(pieceImageView, new Position(j,i));
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
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(str)),SQUARE_SIZE,SQUARE_SIZE,true,true);
    }

    private void initModel() {
        model = new Game();
        model.start();
    }

    private void makeDraggable(Node node, Position oldPos){
        node.setOnMousePressed(e -> {
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();
            if (node.getParent() != null) {
                node.getParent().toFront(); // Amenez le parent de l'ImageView au premier plan
            }
        });
        node.setOnMouseDragged(e ->{
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
            System.out.println("y : "+(node.getTranslateY()));
            System.out.println("x : "+(node.getTranslateX()));
        });
        node.setOnMouseReleased(e ->{
            if(node.getTranslateY() <= -SQUARE_SIZE/1.1428 && node.getTranslateX() < 24 && node.getTranslateX() > -24) { // UP
                Position newPos = oldPos;
                double transalationY = -node.getTranslateY();
                int n = 0;
                while(transalationY > SQUARE_SIZE){
                    newPos = newPos.next(Direction.N);
                    transalationY = transalationY - SQUARE_SIZE;
                    n++;
                }
                System.out.println("UP "+n+" CASE");
                try {
                    model.movePiecePosition(oldPos, newPos);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            } else if (node.getTranslateY() >= SQUARE_SIZE/1.6 && node.getTranslateX() < 24 && node.getTranslateX() > -24) { // DOWN
                Position newPos = oldPos;
                double transalationY = node.getTranslateY();
                int n = 0;
                while(transalationY >= SQUARE_SIZE/1.6){
                    newPos = newPos.next(Direction.S);
                    transalationY = transalationY - SQUARE_SIZE;
                    n++;
                }
                System.out.println("DOWN "+n+" CASE");
                try {
                    model.movePiecePosition(oldPos, newPos);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            } else if (node.getTranslateX() >= SQUARE_SIZE/1.4545 && node.getTranslateY() > -20 && node.getTranslateY() < 12) { // RIGHT
                Position newPos = oldPos;
                double transalationX = node.getTranslateX();
                int n = 0;
                while(transalationX >= SQUARE_SIZE/1.4545){
                    newPos = newPos.next(Direction.E);
                    transalationX = transalationX - SQUARE_SIZE;
                    n++;
                }
                System.out.println("RIGHT "+n+" CASE");
                try {
                    model.movePiecePosition(oldPos, newPos);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            } else if (node.getTranslateX() <= -SQUARE_SIZE/1.4545 && node.getTranslateY() > -20 && node.getTranslateY() < 12) { //LEFT
                Position newPos = oldPos;
                double transalationX = node.getTranslateX();
                int n = 0;
                while(transalationX <= -SQUARE_SIZE/1.4545){
                    newPos = newPos.next(Direction.W);
                    transalationX = transalationX + SQUARE_SIZE;
                    n++;
                }
                System.out.println("LEFT "+n+" CASE");
                try {
                    model.movePiecePosition(oldPos, newPos);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            displayBackground();
        });
    }
}
