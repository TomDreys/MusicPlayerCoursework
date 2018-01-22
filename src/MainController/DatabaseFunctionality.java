package MainController;

import Database.DatabaseConnection;
import Database.ObjectModels.Playlist;
import Database.ObjectModels.Song;
import Database.ServiceClasses.OtherService;
import Database.ServiceClasses.PlaylistService;
import Database.ServiceClasses.SongService;
import GUI.GUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DatabaseFunctionality {

    private static DatabaseConnection databaseConnection;

    public DatabaseFunctionality(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createNewPlaylist(String name, String creator, DatabaseConnection databaseConnection)
    {
        Playlist playlist = new Playlist(0, name,creator,0);
        PlaylistService.save(playlist, databaseConnection);
    }

    public void addToPlaylist(String fileName, int playlistID, DatabaseConnection databaseConnection)
    {

    }

    public static void loadFromPlaylist(int playlistID, GUI gui)
    {
        ArrayList<Song> songs = OtherService.loadPlaylistSongs(playlistID,databaseConnection);
        ObservableList<Song> Olist = FXCollections.observableArrayList(songs);
        gui.updateSongsTable(Olist);
    }

    public static void loadPlaylists(DatabaseConnection databaseConnection, GUI gui)
    {
        ArrayList playlists = PlaylistService.selectAll(databaseConnection);
        ObservableList<Playlist> Olist = FXCollections.observableArrayList(playlists);
        gui.updatePlaylistsTable(Olist);
    }

    public void deleteSong()
    {

    }

    public void deletePlaylist()
    {

    }


}
