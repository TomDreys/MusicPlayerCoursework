package Database.ServiceClasses;

import Database.DatabaseConnection;
import Database.ObjectModels.Playlist;
import Database.ObjectModels.Song;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtherService {

    public static ArrayList<Song> loadPlaylistSongs(int playlistID, DatabaseConnection database)
    {
        ArrayList<Song> playlistSongs = new ArrayList<>();

        PreparedStatement statement = database.newStatement("SELECT Songs.SongID as 'a', \n" +
                "Songs.FileURL as 'b',\n" +
                "Songs.SongTitle as 'c', \n" +
                "Songs.SongAlbum as 'd', \n" +
                "Songs.Artist as 'e',\n" +
                "Songs.ReleaseYear as 'f',\n" +
                "Songs.TrackNumber as 'g',\n" +
                "PlaylistSongs.AddDate as 'h'\n" +
                "FROM Songs\n" +
                "INNER JOIN PlaylistSongs on PlaylistSongs.SongID = Songs.SongID\n" +
                "INNER JOIN Playlists on PlaylistSongs.PlaylistID = Playlists.PlaylistID\n" +
                "WHERE Playlists.PlaylistId = ?");

        try {
            if (statement != null) {

                statement.setInt(1, playlistID);
                ResultSet results = database.executeQuery(statement);
                database.executeQuery(statement);
                if (results != null) {
                    while (results.next()) {
                        Song s = new Song( results.getInt("a"),
                                results.getString("b"),
                                results.getString("c"),
                                results.getString("d"),
                                results.getString("e"),
                                results.getString("f"),
                                results.getInt("g"),
                                results.getString("h"));
                        System.out.println("----> " + s);
                        playlistSongs.add(s);


                    }
                }
            }

        } catch (SQLException resultsException) {
            System.out.println("loadPlaylistSongs error: " + resultsException.getMessage());
        }

        return playlistSongs;
    }

    public static ArrayList<Song> searchAllSongs(String criteria, String criteriaType, DatabaseConnection database)
    {
        PreparedStatement statement = database.newStatement("SELECT songID, FileURL, SongTitle, SongAlbum, Artist, ReleaseYear, TrackNumber FROM Songs WHERE ? = ?");
        ArrayList<Song> songs= new ArrayList<>();

        try {
            statement.setString(1, criteriaType);
            statement.setString(2, criteria);

            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        songs.add(new Song(results.getInt("SongID"),
                                results.getString("FileURL"),
                                results.getString("SongTitle"),
                                results.getString("SongAlbum"),
                                results.getString("Artist") ,
                                results.getString("ReleaseYear"),
                                results.getInt("TrackNumber"), "N/A"));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

        return songs;
    }

    public static ArrayList<Song> searchPlaylistSongs(int playlistID, String criteria, String criteriaType, DatabaseConnection database)
    {

        ArrayList<Song> songs = new ArrayList<>();
        PreparedStatement statement = database.newStatement("SELECT Songs.FileURL as 'b',\n" +
                "Songs.SongTitle as 'c', \n" +
                "Songs.SongAlbum as 'd', \n" +
                "Songs.Artist as 'e',\n" +
                "Songs.ReleaseYear as 'f',\n" +
                "Songs.TrackNumber as 'g',\n" +
                "PlaylistSongs.AddDate as 'h', FROM Songs \n" +
                "INNER JOIN PlaylistSongs on PlaylistSongs.SongID = Songs.SongID \n" +
                "INNER JOIN Playlists on PlaylistSongs.PlaylistID = Playlists.PlaylistID \n" +
                "WHERE PlaylistID = \"?\" AND ? = \"?\"");

        try {
            statement.setInt(1, playlistID);
            statement.setString(2, criteriaType);
            statement.setString(3, criteria);

            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        songs.add(new Song(results.getInt("SongID"),
                                results.getString("FileURL"),
                                results.getString("SongTitle"),
                                results.getString("SongAlbum"),
                                results.getString("Artist") ,
                                results.getString("ReleaseYear"),
                                results.getInt("TrackNumber"),
                                results.getString("h")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

        return songs;
    }

}
