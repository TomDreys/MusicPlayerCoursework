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

    public static void addToPlaylist(File file, int playlistID)
    {
        Media songMedia = new Media(file.toURI().toString());
        if (file.toString().endsWith(".mp3"))
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            String currentDate = dtf.format(localDate);

            Song existingSong = SongService.selectByFile(file.getPath());

            if (existingSong == null)
            {
                ObservableMap<java.lang.String,java.lang.Object> metadata = songMedia.getMetadata();

                Song newSong = new Song(0,
                        file.getPath(),
                        metadata.get("title").toString(),
                        metadata.get("album").toString(),
                        metadata.get("artist").toString(),
                        metadata.get("year").toString(),
                        Integer.parseInt(metadata.get("track number").toString()),
                        currentDate);

                SongService.save(newSong);
                PlaylistSong playlistSong = new PlaylistSong(SongService.selectByFile(file.getPath()).getSongID(),
                        playlistID,currentDate);
                PlaylistSongService.save(playlistSong);
            }
            else
            {
                int songId = existingSong.getSongID();
                PlaylistSong playlistSong = new PlaylistSong(songId, playlistID, currentDate);
                PlaylistSongService.save(playlistSong);
            }

        }
        else
        {

        }

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
