package Database.ObjectModels;

import javafx.beans.property.SimpleStringProperty;

public class PlaylistSong {

    int songID;
    int playlistID;
    SimpleStringProperty addDate;

    public PlaylistSong(int songID, int playlistID, String addDate) {
        this.songID = songID;
        this.playlistID = playlistID;
        this.addDate = new SimpleStringProperty(addDate);
    }

    public int getSongID() {
        return songID;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public String getAddDate() {
        return addDate.get();
    }

    public SimpleStringProperty addDateProperty() {
        return addDate;
    }

    @Override
    public String toString() {
        return "PlaylistSong{" +
                "songID=" + songID +
                ", playlistID=" + playlistID +
                ", addDate='" + addDate + '\'' +
                '}';
    }
}
