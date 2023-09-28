package g58137.chess.main;

import g58137.chess.controller.Controller;
import g58137.chess.model.Game;
import g58137.chess.model.Model;
import g58137.chess.view.TextView;
import g58137.chess.view.FxView;
import javafx.stage.Stage;

/**
 * MAVEN_OPTS='-Dfile.encoding=UTF-8' 'C:\Program Files\NetBeans-12.5\netbeans\java\maven\bin\mvn' exec:java -Dexec.mainClass=g58137.chess.main.main
 * @author Florian
 */
public class main {

    public static void main(String[] args) {
        /*
        Model game = new Game();
        TextView textView = new TextView(game);
        Controller controller = new Controller(game, textView);
        controller.play();
         */
        FxView.exec(args);
    }
}
