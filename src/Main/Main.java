package Main;

import static GUI.GUIBuilder.createGUI;
import AudioController.AudioController;
import Database.DatabaseConnection;
import GUI.GUI;
import MainController.DatabaseFunctionality;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application{

    public static GUI mainGui;
    public static DatabaseConnection databaseConnection;
    public static AudioController audioController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start (Stage primaryStage) throws Exception {

        databaseConnection = new DatabaseConnection("src/MusicPlayer.db");
        audioController = new AudioController();
        mainGui = createGUI(primaryStage);

        DatabaseFunctionality.loadPlaylists();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    mainGui.songProgressBar.setProgress(audioController.getSongProgress());
                });
            }
        },500,500);
    }
}
