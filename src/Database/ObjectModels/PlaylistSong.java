package Database.ObjectModels;

public class PlaylistSong {

    int songID;
    int playlistID;
    String addDate;

    public PlaylistSong(int songID, int playlistID, String addDate) {
        this.songID = songID;
        this.playlistID = playlistID;
        this.addDate = addDate;
    }

    public int getSongID() {
        return songID;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public String getAddDate() {
        return addDate;
    }
}
