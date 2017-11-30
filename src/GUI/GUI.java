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

    public static void createLeftVBox(VBox leftVbox)
    {
        HBox topBar = new HBox();
        TableView songs = new TableView();
    }

    public static void createRightVBox(VBox rightVbox)
    {
        HBox topBar = new HBox();
        TableView playlists = new TableView();
        VBox controlPanel = new VBox();

    }

    public static void createLeftTopBar(HBox topBar)
    {
        MenuItem fileMenu = new MenuItem();

        MenuItem editMenu = new MenuItem();

        MenuItem viewMenu = new MenuItem();

        MenuItem helpMenu = new MenuItem();
    }

    public static void createSongsTable(TableView songTable)
    {

    }

    public static void createPlaylistsTable(TableView playlistTable)
    {

    }

    public static void createPlayControlPanel(HBox playControlPanel)
    {

    }

    public static void createMainControlPanel()
    {
        HBox playControlPanel = new HBox();
        Slider volumeSlider = new Slider();
        ProgressBar playProgressBar = new ProgressBar();
    }
}
