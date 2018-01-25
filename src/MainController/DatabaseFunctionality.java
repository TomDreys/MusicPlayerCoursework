package MainController;

import Database.ObjectModels.Playlist;
import Database.ObjectModels.PlaylistSong;
import Database.ObjectModels.Song;
import Database.ServiceClasses.OtherService;
import Database.ServiceClasses.PlaylistService;
import Database.ServiceClasses.PlaylistSongService;
import Database.ServiceClasses.SongService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.media.Media;

import static Main.Main.*;

import java.io.File;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DatabaseFunctionality {

    public void createNewPlaylist(String name, String creator)
    {
        Playlist playlist = new Playlist(0, name,creator,0);
        PlaylistService.save(playlist);
    }

    public void addToPlaylist(String fileName, int playlistID)
    {
        File songFile = new File(fileName);
        Media songMedia = new Media(songFile.toURI().toString());
        ObservableMap<java.lang.String,java.lang.Object> metadata = songMedia.getMetadata();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String currentDate = dtf.format(localDate);
        
        Song newSong = new Song(0,
                fileName,
                metadata.get("title").toString(),
                metadata.get("album").toString(),
                metadata.get("artist").toString(),
                metadata.get("year").toString(),
                Integer.parseInt(metadata.get("track number").toString()),
                currentDate);

        SongService.save(newSong);
        PlaylistSong playlistSong = new PlaylistSong(SongService.selectByFile(fileName).getSongID(),
                                                    playlistID,currentDate);
        PlaylistSongService.save(playlistSong);
    }

    public static ArrayList<Song> loadFromPlaylist(int playlistID)
    {
        ArrayList<Song> songs = OtherService.loadPlaylistSongs(playlistID);
        audioController.setCurrentPlaylistSongs(songs);
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
