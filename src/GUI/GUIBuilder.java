package GUI;

import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GUIBuilder {

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
