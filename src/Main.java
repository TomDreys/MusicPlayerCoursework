import static GUI.GUI.*;

import Database.DatabaseConnection;
import Database.ModelClasses.SongService;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start (Stage primaryStage) throws Exception {

        createGUI(primaryStage);

        DatabaseConnection DBconnection = new DatabaseConnection("MusicPlayer.db");

        System.out.println(SongService.selectById(1, DBconnection));



    }
}
