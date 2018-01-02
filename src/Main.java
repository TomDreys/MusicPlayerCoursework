import static GUI.GUIBuilder.createGUI;

import Database.DatabaseConnection;
import Database.ObjectModels.Playlist;
import Database.ObjectModels.PlaylistSong;
import Database.ObjectModels.Song;
import Database.ServiceClasses.PlaylistService;
import Database.ServiceClasses.PlaylistSongService;
import Database.ServiceClasses.SongService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.sqlite.core.DB;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main extends Application{

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start (Stage primaryStage) throws Exception {

        createGUI(primaryStage);

        DatabaseConnection DBconnection = new DatabaseConnection("src/MusicPlayer.db");
        PlaylistSong playlist = PlaylistSongService.selectById(7,3, DBconnection);
        System.out.println(playlist.toString());
    }
}
