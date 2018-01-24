package Database.ServiceClasses;

import Database.ObjectModels.PlaylistSong;
import static Main.Main.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistSongService {

    public static void selectAll(List<PlaylistSong> targetList) {

        PreparedStatement statement = databaseConnection.newStatement("SELECT * FROM PlaylistSongs ORDER BY PlaylistID");

        try {
            if (statement != null) {

                ResultSet results = databaseConnection.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new PlaylistSong(results.getInt("SongID"), results.getInt("PlaylistID"),  results.getString("AddDate")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static PlaylistSong selectById(int songID, int playlistID) {

        PlaylistSong result = null;

        PreparedStatement statement = databaseConnection.newStatement("SELECT * FROM PlaylistSongs WHERE PlaylistID = ? AND SongID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, playlistID);
                statement.setInt(2, songID);
                ResultSet results = databaseConnection.executeQuery(statement);

                if (results != null) {
                    result = new PlaylistSong(results.getInt("SongID"), results.getInt("PlaylistID"),  results.getString("AddDate"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void deleteById(int songD, int playlistID) {

        PreparedStatement statement = databaseConnection.newStatement("DELETE FROM PlaylistSongs WHERE PlaylistID = ? AND SongID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, songD);
                statement.setInt(2, playlistID);
                databaseConnection.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }

    public static void save(PlaylistSong itemToSave) {

        PlaylistSong existingItem = null;

        if (itemToSave.getPlaylistID() != 0 && itemToSave.getSongID() != 0) existingItem = selectById(itemToSave.getSongID(), itemToSave.getPlaylistID());

        try {
            if (existingItem == null) {
                PreparedStatement statement = databaseConnection.newStatement("INSERT INTO PlaylistSongs (PlaylistID, SongID, AddDate) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getPlaylistID());
                statement.setInt(2, itemToSave.getSongID());
                statement.setString(3, itemToSave.getAddDate());
                databaseConnection.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = databaseConnection.newStatement("UPDATE Playlists SET AddDate = ? WHERE PlaylistID = ? AND SongID = ?");
                statement.setString(1, itemToSave.getAddDate());
                statement.setInt(2, itemToSave.getPlaylistID());
                statement.setInt(3,itemToSave.getSongID());
                databaseConnection.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
