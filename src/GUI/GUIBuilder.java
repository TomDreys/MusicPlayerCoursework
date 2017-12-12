package GUI;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GUIBuilder {



    public static GUI createGUI(Stage primaryStage) {

        GUI mainGUI = new GUI();

        Pane root = GUIBuilder.createPane(mainGUI);

        Scene scene = new Scene(root, 1024, 768);

        primaryStage.setTitle("Music Player");
        primaryStage.setScene(scene);
        primaryStage.show();

        return mainGUI;
    }


    public static Pane createPane(GUI gui)
    {
        Pane root = new Pane();

        root.getChildren().add(createPaneVbox(gui));

        return root;
    }

    public static VBox createPaneVbox(GUI gui)
    {
        VBox paneVbox = new VBox();

        HBox mainHbox = createMainHBox(gui);
        HBox menuHbox = createMenuBar(gui);

        paneVbox.getChildren().add(menuHbox);
        paneVbox.getChildren().add(mainHbox);

        return paneVbox;
    }

    public static HBox createMainHBox(GUI gui)
    {
        HBox mainHbox = new HBox();
        VBox leftVbox = createLeftVBox(gui);
        VBox rightVbox = createRightVBox(gui);
        mainHbox.getChildren().add(leftVbox);
        mainHbox.getChildren().add(rightVbox);
        return mainHbox;
    }

    public static VBox createLeftVBox(GUI gui)
    {
        VBox leftVbox = new VBox();
        HBox leftOptionBar = createLeftOptionBar(gui);
        TableView songs = new TableView();
        HBox visualisationTab = createVisualiationTab(gui);

        return new VBox();
    }

    public static HBox createLeftOptionBar(GUI gui)
    {
        HBox LeftOptionBar = new HBox();
        TextField searchInputField = new TextField();
        ChoiceBox searchTypeChoice = new ChoiceBox();
        Button searchEnterButton = new Button();
        Button addNewSongButton = new Button();

        LeftOptionBar.getChildren().add(searchInputField);
        LeftOptionBar.getChildren().add(searchTypeChoice);
        LeftOptionBar.getChildren().add(searchEnterButton);
        LeftOptionBar.getChildren().add(addNewSongButton);

        return LeftOptionBar;
    }

    public static HBox createVisualiationTab(GUI gui)
    {
        HBox visualiationTab = new HBox();
        Label albumArtLabel = new Label();

        visualiationTab.getChildren().add(albumArtLabel);

        return visualiationTab;
    }

    public static VBox createRightVBox(GUI gui)
    {
        HBox topBar = new HBox();
        TableView playlists = new TableView();
        VBox controlPanel = new VBox();
        return new VBox();
    }

    public static HBox createMenuBar(GUI gui)
    {
        MenuItem fileMenu = new MenuItem();

        MenuItem editMenu = new MenuItem();

        MenuItem viewMenu = new MenuItem();

        MenuItem helpMenu = new MenuItem();

        return new HBox();
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
