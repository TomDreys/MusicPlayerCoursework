package MainController;

import Database.ObjectModels.Playlist;
import Database.ObjectModels.Song;
import Database.ServiceClasses.OtherService;
import Database.ServiceClasses.PlaylistService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static Main.Main.*;

import java.util.ArrayList;

public class DatabaseFunctionality {

    public void createNewPlaylist(String name, String creator)
    {
        Playlist playlist = new Playlist(0, name,creator,0);
        PlaylistService.save(playlist);
    }

    public void addToPlaylist(String fileName, int playlistID)
    {

    }

    public static ArrayList<Song> loadFromPlaylist(int playlistID)
    {
        ArrayList<Song> songs = OtherService.loadPlaylistSongs(playlistID);
        ObservableList<Song> Olist = FXCollections.observableArrayList(songs);
        mainGui.updateSongsTable(Olist);
        return songs;
    }

    public static void loadPlaylists()
    {
        ArrayList<Playlist> playlists = PlaylistService.selectAll();
        ObservableList<Playlist> Olist = FXCollections.observableArrayList(playlists);
        mainGui.updatePlaylistsTable(Olist);
    }

    public void deleteSong()
    {

    }

    public void deletePlaylist()
    {

    }


}
