package Database.ServiceClasses;

import Database.DatabaseConnection;
import Database.ObjectModels.Playlist;
import Database.ObjectModels.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtherService {

    public ArrayList<Song> loadPlaylistSongs(int playlistID, DatabaseConnection database)
    {
        ArrayList<Song> playlistSongs = new ArrayList<>();

        PreparedStatement statement = database.newStatement("SELECT * FROM Songs \n" +
                "INNER JOIN PlaylistSongs on PlaylistSongs.SongID = Songs.SongID \n" +
                "INNER JOIN Playlists on PlaylistSongs.PlaylistID = Playlists.SongID \n" +
                "WHERE PlaylistId = ?");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);
                statement.setInt(1, playlistID);
                database.executeQuery(statement);
                if (results != null) {
                    while (results.next()) {
                        playlistSongs.add(new Song(results.getInt("SongID"), results.getString("FileURL"), results.getString("SongTitle")
                                , results.getString("SongAlbum"),results.getString("Artist") ,results.getString("ReleaseYear"), results.getInt("TrackNumber")));
                    }
                }
            }


        } catch (SQLException resultsException) {
            System.out.println("loadPlaylistSongs error: " + resultsException.getMessage());
        }

        return playlistSongs;
    }

}
