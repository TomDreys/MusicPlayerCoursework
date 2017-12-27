package Database.ObjectModels;

import javafx.beans.property.SimpleStringProperty;

public class Playlist {

    int playlistID;
    int runTime;
    SimpleStringProperty playListName;
    SimpleStringProperty playlistCreator;

    public Playlist(int playlistID, String playListName, String playlistCreator) {
        this.playlistID = playlistID;
        this.playListName = new SimpleStringProperty(playListName);
        this.playlistCreator = new SimpleStringProperty(playlistCreator);
        this.runTime = calculateRuntime();
    }

    public int calculateRuntime()
    {
        return 0;
    }

}
