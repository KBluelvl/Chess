package g58137.chess.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Objects;

public class BoardGrid extends GridPane {

    private ImageView bgGreen1;
    private ImageView bgGreen2;

    public BoardGrid() {
        displayBackground();
    }

    public void displayBackground() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
                    bgGreen1 = new ImageView(getImage("bgGreen1"));
                    this.add(bgGreen1, j, i);
                }else {
                    bgGreen2 = new ImageView(getImage("bgGreen2"));
                    this.add(bgGreen2, j, i);
                }
            }
        }
    }

    public Image getImage(String str) {
        switch (str) {
            case "bgGreen1" -> str = "img/boardGreen1.png";
            case "bgGreen2" -> str = "img/boardGreen2.png";
        }
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(str)),64,64,true,true);
    }
}
