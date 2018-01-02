package Database.ObjectModels;

import javafx.beans.property.SimpleStringProperty;

public class Playlist {

    int playlistID;
    int runTime;
    int songCount;
    SimpleStringProperty playListName;
    SimpleStringProperty playlistCreator;

    public Playlist(int playlistID, String playListName, String playlistCreator, int songCount) {
        this.playlistID = playlistID;
        this.runTime = calculateRuntime();
        this.songCount = songCount;
        this.playListName = new SimpleStringProperty(playListName);
        this.playlistCreator = new SimpleStringProperty(playlistCreator);
    }

    public int calculateRuntime()
    {
        return 0;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public int getRunTime() {
        return runTime;
    }

    public String getPlayListName() {
        return playListName.get();
    }

    public SimpleStringProperty playListNameProperty() {
        return playListName;
    }

    public String getPlaylistCreator() {
        return playlistCreator.get();
    }

    public SimpleStringProperty playlistCreatorProperty() {
        return playlistCreator;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistID=" + playlistID +
                ", runTime=" + runTime +
                ", songCount=" + songCount +
                ", playListName=" + playListName +
                ", playlistCreator=" + playlistCreator +
                '}';
    }
}
