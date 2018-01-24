package Database.ServiceClasses;

import Database.DatabaseConnection;
import Database.ObjectModels.Playlist;
import static Main.Main.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistService {

    public static ArrayList<Playlist> selectAll() {

        PreparedStatement statement = databaseConnection.newStatement("SELECT Playlists.PlaylistID ,Playlists.PlaylistName,Playlists.PlaylistCreator,COUNT(PlaylistSongs.SongID) FROM Playlists \n" +
                "INNER JOIN PlaylistSongs on Playlists.PlaylistID = PlaylistSongs.PlaylistID \n" +
                "GROUP BY playlistSongs.PlaylistID");

        ArrayList<Playlist> targetList = new ArrayList<>();

        try {
            if (statement != null) {

                ResultSet results = databaseConnection.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Playlist(results.getInt("PlaylistID"), results.getString("PlaylistName"), results.getString("PlaylistCreator"), results.getInt("COUNT(PlaylistSongs.SongID)")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

        return targetList;
    }

    public static Playlist selectById(int id) {

        Playlist result = null;

        PreparedStatement statement = databaseConnection.newStatement("SELECT Playlists.PlaylistID ,Playlists.PlaylistName,Playlists.PlaylistCreator,COUNT(PlaylistSongs.SongID) FROM Playlists \n" +
                "INNER JOIN PlaylistSongs on Playlists.PlaylistID = PlaylistSongs.PlaylistID \n" +
                "WHERE Playlists.PlaylistID = ? GROUP BY playlistSongs.PlaylistID");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = databaseConnection.executeQuery(statement);

                if (results != null) {
                    result = new Playlist(results.getInt("PlaylistID"), results.getString("PlaylistName"), results.getString("PlaylistCreator"), results.getInt("COUNT(PlaylistSongs.SongID)"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void deleteById(int id) {

        PreparedStatement statement = databaseConnection.newStatement("DELETE FROM Playlists WHERE PlaylistID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                databaseConnection.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }

    public static void save(Playlist itemToSave) {

        Playlist existingItem = null;

        if (itemToSave.getPlaylistID() != 0) existingItem = selectById(itemToSave.getPlaylistID());

        try {
            if (existingItem == null) {
                PreparedStatement statement = databaseConnection.newStatement("INSERT INTO Playlists (PlaylistName, PlaylistCreator) VALUES (?, ?))");
                statement.setString(2, itemToSave.getPlayListName());
                statement.setString(3, itemToSave.getPlaylistCreator());
                databaseConnection.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = databaseConnection.newStatement("UPDATE Playlists SET PlaylistName = ?, PlaylistCreator = ? WHERE PlaylistID = ?");
                statement.setString(1, itemToSave.getPlayListName());
                statement.setString(2, itemToSave.getPlaylistCreator());
                statement.setInt(3,itemToSave.getPlaylistID());
                databaseConnection.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
