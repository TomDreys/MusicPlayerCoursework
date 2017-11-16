package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI {

    public static void createGUI(Stage primaryStage)
    {
        Pane root = new Pane();

        Scene scene = new Scene(root, 1024, 768);

        HBox mainHBox = new HBox();

        VBox leftVBox = new VBox();
        VBox rightVBox = new VBox();

        Button button1 = new Button();
        button1.setText("uhhh");
        Button button2 = new Button();
        button2.setText("uhhhhhhh");

        leftVBox.getChildren().add(button1);
        rightVBox.getChildren().add(button2);

        mainHBox.getChildren().add(leftVBox);
        mainHBox.getChildren().add(rightVBox);

        root.getChildren().add(mainHBox);

        primaryStage.setTitle("Music Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
