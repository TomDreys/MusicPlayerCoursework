package Database.ObjectModels;

public class PlaylistSong {

    Song song;
    Playlist playlist;
    String addDate;

    public PlaylistSong(Song song, Playlist playlist, String addDate) {
        this.song = song;
        this.playlist = playlist;
        this.addDate = addDate;
    }
}
