package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIBuilder {

    public static GUI createGUI(Stage primaryStage) {

        GUI mainGUI = new GUI();

        Pane root = createPane(mainGUI);

        Scene scene = new Scene(root, 1024, 768);

        primaryStage.setTitle("Music Player");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();

        return mainGUI;
    }


    private static Pane createPane(GUI gui)
    {
        Pane root = new Pane();

        root.getChildren().add(createPaneVbox(gui));

        return root;
    }

    private static VBox createPaneVbox(GUI gui)
    {
        VBox paneVbox = new VBox();
        paneVbox.setSpacing(15);

        HBox menuHbox = createMenuBar(gui);
        HBox mainHbox = createMainHBox(gui);

        paneVbox.getChildren().add(menuHbox);
        paneVbox.getChildren().add(mainHbox);

        return paneVbox;
    }

    private static HBox createMainHBox(GUI gui)
    {
        HBox mainHbox = new HBox();
        VBox leftVbox = createLeftVBox(gui);
        VBox rightVbox = createRightVBox(gui);
        mainHbox.getChildren().add(leftVbox);
        mainHbox.getChildren().add(rightVbox);
        return mainHbox;
    }

    private static VBox createLeftVBox(GUI gui)
    {
        VBox leftVbox = new VBox();
        leftVbox.setPrefSize(700, 768);
        leftVbox.setSpacing(5);

        HBox leftOptionBar = createLeftOptionBar(gui);

        TableView songs = new TableView();
        TableColumn trackNumber = new TableColumn("#");
        trackNumber.setPrefWidth(40);
        TableColumn song = new TableColumn("Song");
        song.setPrefWidth(170);
        TableColumn artist = new TableColumn("Artist");
        artist.setPrefWidth(150);
        TableColumn album = new TableColumn("Album");
        album.setPrefWidth(150);
        TableColumn length = new TableColumn("Length");
        length.setPrefWidth(80);
        TableColumn addDate = new TableColumn("Add Date");
        addDate.setPrefWidth(110);
        songs.getColumns().addAll(trackNumber,song,artist,album,length,addDate);
        songs.setPrefHeight(540);

        HBox visualisationTab = createVisualiationTab(gui);

        leftVbox.getChildren().add(leftOptionBar);
        leftVbox.getChildren().add(songs);
        leftVbox.getChildren().add(visualisationTab);
        return leftVbox;
    }

    private static HBox createLeftOptionBar(GUI gui)
    {
        HBox LeftOptionBar = new HBox();
        LeftOptionBar.setSpacing(20);
        LeftOptionBar.setPrefWidth(700);
        LeftOptionBar.setPadding(new Insets(0,0,0,5));

        TextField searchInputField = new TextField();

        ComboBox searchTypeChoice = new ComboBox();
        searchTypeChoice.setPromptText("Search By...");
        searchTypeChoice.getItems().addAll("Song Title", "Album", "Artist","Release Year");

        ComboBox searchAreaChoice = new ComboBox();
        searchAreaChoice.setPromptText("In...");
        searchAreaChoice.getItems().addAll("All Playlists", "Current Playlist");

        Button searchEnterButton = new Button();
        searchEnterButton.setText("Search");

        Button addNewSongButton = new Button();
        addNewSongButton.setText("Add Song");
        VBox newSongVbox = new VBox();
        newSongVbox.setAlignment(Pos.TOP_RIGHT);
        newSongVbox.getChildren().add(addNewSongButton);
        newSongVbox.setPrefWidth(170);

        LeftOptionBar.getChildren().add(searchInputField);
        LeftOptionBar.getChildren().add(searchTypeChoice);
        LeftOptionBar.getChildren().add(searchAreaChoice);
        LeftOptionBar.getChildren().add(searchEnterButton);
        LeftOptionBar.getChildren().add(newSongVbox);

        return LeftOptionBar;
    }

    private static HBox createVisualiationTab(GUI gui)
    {
        HBox visualiationTab = new HBox();
        visualiationTab.setSpacing(30);

        Label albumArtLabel = new Label();
        albumArtLabel.setMaxSize(130,130);
        albumArtLabel.setMinSize(130,130);

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

        Slider slider9 = new Slider();
        slider9.setOrientation(Orientation.VERTICAL);

        Slider slider10 = new Slider();
        slider10.setOrientation(Orientation.VERTICAL);

        Button channelButton = new Button();
        channelButton.setText("Stereo");
        HBox channelButtonHBox = new HBox();
        channelButtonHBox.setAlignment(Pos.CENTER);
        channelButtonHBox.getChildren().add(channelButton);

        visualiationTab.getChildren().add(albumArtLabel);
        visualiationTab.getChildren().addAll(slider1,slider2,slider3,slider4,slider5,slider6,slider7,slider8,slider9, slider10);
        visualiationTab.getChildren().add(channelButtonHBox);

        return visualiationTab;
    }

    private static VBox createRightVBox(GUI gui)
    {
        VBox rightVbox = new VBox();
        rightVbox.setPrefSize(324, 768);
        rightVbox.setSpacing(5);

        Button addPlaylistButton = new Button();
        addPlaylistButton.setText("New Playlist");
        VBox playlistButtonVbox = new VBox();
        playlistButtonVbox.setAlignment(Pos.TOP_RIGHT);
        playlistButtonVbox.getChildren().add(addPlaylistButton);

        TableView playlists = new TableView();
        TableColumn playlist = new TableColumn("Playlist");
        TableColumn creator = new TableColumn("Creator");
        TableColumn runtime = new TableColumn("Runtime");
        playlists.getColumns().addAll(playlist,creator,runtime);

        VBox controlPanel = createControlPanel(gui);

        rightVbox.getChildren().add(playlistButtonVbox);
        rightVbox.getChildren().add(playlists);
        rightVbox.getChildren().add(controlPanel);
        return rightVbox;
    }

    private static VBox createControlPanel(GUI gui)
    {
        VBox controlPanel = new VBox();
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.setSpacing(30);
        controlPanel.setPadding(new Insets(50,0,0,0));

        HBox playButtons = createPlayButtons();

        Button playModeButton = new Button();
        playModeButton.setText("Shuffle");

        ProgressBar songProgress = new ProgressBar();
        songProgress.setMinWidth(200);

        Slider volumeSlider = new Slider();
        volumeSlider.setMaxWidth(220);

        controlPanel.getChildren().add(playButtons);
        controlPanel.getChildren().add(playModeButton);
        controlPanel.getChildren().add(songProgress);
        controlPanel.getChildren().add(volumeSlider);

        return controlPanel;
    }

    private static HBox createPlayButtons()
    {
        HBox playButtons = new HBox();
        playButtons.setAlignment(Pos.CENTER);
        playButtons.setSpacing(15);

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


    private static HBox createMenuBar(GUI gui)
    {
        HBox menuHbox = new HBox();
        menuHbox.setPrefWidth(1024);

        MenuBar menuBar = new MenuBar();
        menuBar.setPrefWidth(1024);
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        menuBar.getMenus().addAll(fileMenu,editMenu);

        menuHbox.getChildren().add(menuBar);

        return menuHbox;
    }



}
