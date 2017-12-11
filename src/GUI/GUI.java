package GUI;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI {

    public static void createGUI(Stage primaryStage) {
        Pane root = new Pane();

        Scene scene = new Scene(root, 1024, 768);

        HBox mainHBox = new HBox();

        VBox leftVBox = new VBox();
        VBox rightVBox = new VBox();

        mainHBox.getChildren().add(leftVBox);
        mainHBox.getChildren().add(rightVBox);

        root.getChildren().add(mainHBox);

        primaryStage.setTitle("Music Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
