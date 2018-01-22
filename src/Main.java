import static GUI.GUIBuilder.createGUI;

import AudioController.AudioController;
import Database.DatabaseConnection;
import Database.ObjectModels.PlaylistSong;
import Database.ServiceClasses.PlaylistSongService;
import GUI.GUI;
import MainController.AudioFunctionality;
import MainController.DatabaseFunctionality;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start (Stage primaryStage) throws Exception {

        GUI gui = createGUI(primaryStage);

        DatabaseConnection DBconnection = new DatabaseConnection("src/MusicPlayer.db");
        PlaylistSong playlist = PlaylistSongService.selectById(7,3, DBconnection);
        System.out.println(playlist.toString());

        DatabaseFunctionality.loadFromPlaylist(3, DBconnection, gui);
        DatabaseFunctionality.loadPlaylists(DBconnection, gui);

        AudioController audioController = new AudioController();
        AudioFunctionality audioFunctionality = new AudioFunctionality(audioController,gui);

    }
}
