import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();
        VBox topPane = new VBox();
        VBox bottomPane = new VBox();
        VBox rightPane = new VBox();
        VBox leftPane = new VBox();
        VBox centerPane = new VBox();

        root.setBottom(bottomPane);
        root.setCenter(centerPane);
        root.setLeft(leftPane);
        root.setRight(rightPane);
        root.setTop(topPane);

        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        topPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setAlignment(Pos.CENTER_RIGHT);
        leftPane.setAlignment(Pos.CENTER_LEFT);
        centerPane.setAlignment(Pos.CENTER);

        Button buttontop = new Button(); buttontop.setText("top");
        Button buttonbottom = new Button(); buttonbottom.setText("top");
        Button buttonright = new Button(); buttonright.setText("top");
        Button buttonleft = new Button(); buttonleft.setText("top");
        Button buttoncenter = new Button(); buttoncenter.setText("top");

        bottomPane.getChildren().add(buttonbottom);
        topPane.getChildren().add(buttontop);
        rightPane.getChildren().add(buttonright);
        leftPane.getChildren().add(buttonleft);
        centerPane.getChildren().add(buttoncenter);



        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
