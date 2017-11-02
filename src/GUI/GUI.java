package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public void launch(String args)
    {
        launch(args);
    }
}
