package GUI;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.plugin2.message.GetAppletMessage;


public class GUIBuilder {

    public static GUI createGUI(Stage primaryStage) {

        GUI mainGUI = new GUI();

        Pane root = createPane(mainGUI);

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

        HBox menuHbox = createMenuBar(gui);
        HBox mainHbox = createMainHBox(gui);

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
        TableColumn trackNumber = new TableColumn("#");
        TableColumn song = new TableColumn("Song");
        TableColumn artist = new TableColumn("Artist");
        TableColumn album = new TableColumn("Album");
        TableColumn length = new TableColumn("Length");
        TableColumn addDate = new TableColumn("Add Date");
        songs.getColumns().addAll(trackNumber,song,artist,album,length,addDate);

        HBox visualisationTab = createVisualiationTab(gui);

        leftVbox.getChildren().add(leftOptionBar);
        leftVbox.getChildren().add(songs);
        leftVbox.getChildren().add(visualisationTab);
        return leftVbox;
    }

    public static HBox createLeftOptionBar(GUI gui)
    {
        HBox LeftOptionBar = new HBox();

        TextField searchInputField = new TextField();

        ChoiceBox searchTypeChoice = new ChoiceBox();

        Button searchEnterButton = new Button();
        searchEnterButton.setText("Search");

        Button addNewSongButton = new Button();
        addNewSongButton.setText("Add Song");

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
        Slider slider1 = new Slider();
        slider1.setOrientation(Orientation.VERTICAL);

        Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.VERTICAL);

        Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.VERTICAL);

        Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.VERTICAL);

        Slider slider5 = new Slider();
        slider5.setOrientation(Orientation.VERTICAL);

        Slider slider6 = new Slider();
        slider6.setOrientation(Orientation.VERTICAL);

        Slider slider7 = new Slider();
        slider7.setOrientation(Orientation.VERTICAL);

        Slider slider8 = new Slider();
        slider8.setOrientation(Orientation.VERTICAL);

        Button channelButton = new Button();
        channelButton.setText("Stereo");

        visualiationTab.getChildren().add(albumArtLabel);
        visualiationTab.getChildren().addAll(slider1,slider2,slider3,slider4,slider5,slider6,slider7,slider8);
        visualiationTab.getChildren().add(channelButton);

        return visualiationTab;
    }

    public static VBox createRightVBox(GUI gui)
    {
        VBox rightVbox = new VBox();

        Button addPlaylistButton = new Button();
        addPlaylistButton.setText("New Playlist");

        TableView playlists = new TableView();
        TableColumn playlist = new TableColumn("Playlist");
        TableColumn creator = new TableColumn("Creator");
        TableColumn runtime = new TableColumn("Runtime");
        playlists.getColumns().addAll(playlist,creator,runtime);

        VBox controlPanel = createControlPanel(gui);

        rightVbox.getChildren().add(addPlaylistButton);
        rightVbox.getChildren().add(playlists);
        rightVbox.getChildren().add(controlPanel);
        return rightVbox;
    }

    public static VBox createControlPanel(GUI gui)
    {
        VBox controlPanel = new VBox();

        HBox playButtons = createPlayButtons();

        Button playModeButton = new Button();
        playModeButton.setText("Shuffle");

        ProgressBar songProgress = new ProgressBar();

        Slider volumeSlider = new Slider();

        controlPanel.getChildren().add(playButtons);
        controlPanel.getChildren().add(playModeButton);
        controlPanel.getChildren().add(songProgress);
        controlPanel.getChildren().add(volumeSlider);

        return controlPanel;
    }

    public static HBox createPlayButtons()
    {
        HBox playButtons = new HBox();

        Button rewindButton = new Button();
        rewindButton.setText("Rewind");

        Button pauseButton = new Button();
        pauseButton.setText("Pause");

        Button skipButton = new Button();
        skipButton.setText("Skip");

        playButtons.getChildren().add(rewindButton);
        playButtons.getChildren().add(pauseButton);
        playButtons.getChildren().add(skipButton);

        return playButtons;
    }


    public static HBox createMenuBar(GUI gui)
    {
        HBox menuHbox = new HBox();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        menuBar.getMenus().addAll(fileMenu,editMenu);

        menuHbox.getChildren().add(menuBar);

        return menuHbox;
    }



}
