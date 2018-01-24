package Main;

import static GUI.GUIBuilder.createGUI;
import AudioController.AudioController;
import Database.DatabaseConnection;
import GUI.GUI;
import MainController.DatabaseFunctionality;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static GUI mainGui;
    public static DatabaseConnection databaseConnection;
    public static AudioController audioController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start (Stage primaryStage) throws Exception {

        mainGui = createGUI(primaryStage);
        databaseConnection = new DatabaseConnection("src/MusicPlayer.db");
        audioController = new AudioController();

        DatabaseFunctionality.loadPlaylists();
    }
}
