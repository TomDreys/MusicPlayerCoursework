package GUI;

import AudioController.AudioController;
import Database.ObjectModels.Playlist;
import Database.ObjectModels.Song;
import MainController.AudioFunctionality;
import MainController.DatabaseFunctionality;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static Main.Main.audioController;

public class GUIBuilder {

    private static GUI gui = new GUI();

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

        TableView<Song> songs = new TableView<>();
        songs.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Song seletedSong = null;
                if ((seletedSong = songs.getSelectionModel().getSelectedItem()) != null && event.getClickCount() == 2)
                {
                    AudioFunctionality.playSong(seletedSong.getFileURL());
                    gui.songTitleLabel.setText(seletedSong.getSongTitle() + " - " + seletedSong.getSongArtist());
                }
            }
        });

        TableColumn<Song, String> trackNumber = new TableColumn<>("#");
        trackNumber.setPrefWidth(40);
        trackNumber.setCellValueFactory(new PropertyValueFactory<>("trackNumber"));
        songs.getColumns().add(trackNumber);

        TableColumn<Song, String> song = new TableColumn<>("Song");
        song.setPrefWidth(170);
        song.setCellValueFactory(new PropertyValueFactory<>("songTitle"));
        songs.getColumns().add(song);

        TableColumn<Song, String> artist = new TableColumn<>("Artist");
        artist.setPrefWidth(150);
        artist.setCellValueFactory(new PropertyValueFactory<>("songArtist"));
        songs.getColumns().add(artist);

        TableColumn<Song, String> album = new TableColumn<>("Album");
        album.setPrefWidth(150);
        album.setCellValueFactory(new PropertyValueFactory<>("songAlbum"));
        songs.getColumns().add(album);

        TableColumn<Song, String> length = new TableColumn<>("Length");
        length.setPrefWidth(80);
        length.setCellValueFactory(new PropertyValueFactory<>("length"));
        songs.getColumns().add(length);

        TableColumn<Song, String> addDate = new TableColumn<>("Add Date");
        addDate.setPrefWidth(110);
        addDate.setSortType(TableColumn.SortType.ASCENDING);
        addDate.setCellValueFactory(new PropertyValueFactory<>("addDate"));
        songs.getColumns().add(addDate);

        songs.setPrefHeight(540);

        gui.songsTable = songs;

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
        gui.searchTextField = searchInputField;

        ComboBox searchTypeChoice = new ComboBox();
        searchTypeChoice.setPromptText("Search By...");
        searchTypeChoice.getItems().addAll("Song Title", "Album", "Artist","Release Year");
        gui.searchType = searchTypeChoice;

        ComboBox searchAreaChoice = new ComboBox();
        searchAreaChoice.setPromptText("In...");
        searchAreaChoice.getItems().addAll("All Playlists", "Current Playlist");
        gui.searchArea = searchAreaChoice;

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
        gui.equalizerSlider1 = slider1;

        Slider slider2 = new Slider();
        slider2.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider2 = slider2;

        Slider slider3 = new Slider();
        slider3.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider3 = slider3;

        Slider slider4 = new Slider();
        slider4.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider4 = slider4;

        Slider slider5 = new Slider();
        slider5.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider5 = slider5;

        Slider slider6 = new Slider();
        slider6.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider6 = slider6;

        Slider slider7 = new Slider();
        slider7.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider7 = slider7;

        Slider slider8 = new Slider();
        slider8.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider8 = slider8;

        Slider slider9 = new Slider();
        slider9.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider9 = slider9;

        Slider slider10 = new Slider();
        slider10.setOrientation(Orientation.VERTICAL);
        gui.equalizerSlider10 = slider10;

        Button channelButton = new Button();
        channelButton.setText("Stereo");
        HBox channelButtonHBox = new HBox();
        channelButtonHBox.setAlignment(Pos.CENTER);
        channelButtonHBox.getChildren().add(channelButton);
        gui.channelButton = channelButton;

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

        TableView<Playlist> playlists = new TableView();
        playlists.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Playlist seletedPlaylist = null;
                if ((seletedPlaylist = playlists.getSelectionModel().getSelectedItem()) != null && event.getClickCount() == 2)
                {
                    ArrayList<Song> songs = DatabaseFunctionality.loadFromPlaylist(seletedPlaylist.getPlaylistID());
                    AudioFunctionality.setPlaylist(songs);
                }
            }
        });

        TableColumn playlist = new TableColumn("Playlist");
        playlist.setPrefWidth(70);
        playlist.setCellValueFactory(new PropertyValueFactory<>("playlistID"));

        TableColumn creator = new TableColumn("Creator");
        creator.setPrefWidth(174);
        creator.setCellValueFactory(new PropertyValueFactory<>("playlistCreator"));

        TableColumn runtime = new TableColumn("Runtime");
        runtime.setPrefWidth(79);
        runtime.setCellValueFactory(new PropertyValueFactory<>("runTime"));

        playlists.getColumns().addAll(playlist,creator,runtime);
        gui.playlistsTable = playlists;

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
        controlPanel.setPadding(new Insets(30,0,0,0));

        Label songTitleLabel = new Label("");
        gui.songTitleLabel = songTitleLabel;

        HBox playButtons = createPlayButtons();

        Button playModeButton = new Button();
        playModeButton.setText("Shuffle");
        playModeButton.setPrefWidth(60);
        gui.playModeButton = playModeButton;
        playModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AudioFunctionality.togglePlayMode();
            }
        });

        ProgressBar songProgress = new ProgressBar();
        songProgress.setMinWidth(200);
        gui.songProgressBar = songProgress;

        Slider volumeSlider = new Slider();
        volumeSlider.setMaxWidth(220);
        volumeSlider.setMax(1);
        volumeSlider.setMin(0);
        gui.volumeSlider = volumeSlider;
        volumeSlider.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                AudioFunctionality.setVolume(volumeSlider.getValue());
            }
        });

        controlPanel.getChildren().add(songTitleLabel);
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
        rewindButton.setPrefWidth(60);
        rewindButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AudioFunctionality.rewindSong();
            }
        });

        Button pauseButton = new Button();
        pauseButton.setText("Pause");
        pauseButton.setPrefWidth(60);
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AudioFunctionality.togglePause();
            }
        });
        gui.playButton = pauseButton;

        Button skipButton = new Button();
        skipButton.setText("Skip");
        skipButton.setPrefWidth(60);
        skipButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AudioFunctionality.skipSong();
            }
        });

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
