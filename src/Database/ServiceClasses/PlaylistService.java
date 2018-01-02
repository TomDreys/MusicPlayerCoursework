package Database.ServiceClasses;

import Database.DatabaseConnection;
import Database.ObjectModels.Playlist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistService {

    public static void selectAll(List<Playlist> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT * FROM Playlists ORDER BY PlaylistID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Playlist(results.getInt("PlaylistID"), results.getString("PlaylistName"), results.getString("PlaylistCreator")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static Playlist selectById(int id, DatabaseConnection database) {

        Playlist result = null;

        PreparedStatement statement = database.newStatement("SELECT * FROM Playlists WHERE PlaylistID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Playlist(results.getInt("PlaylistID"), results.getString("PlaylistName"), results.getString("PlaylistCreator"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Playlists WHERE PlaylistID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }

    public static void save(Playlist itemToSave, DatabaseConnection database) {

        Playlist existingItem = null;

        if (itemToSave.getPlaylistID() != 0) existingItem = selectById(itemToSave.getPlaylistID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Playlists (PlaylistID, PlaylistName, PlaylistCreator) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getPlaylistID());
                statement.setString(2, itemToSave.getPlayListName());
                statement.setString(3, itemToSave.getPlaylistCreator());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Playlists SET PlaylistName = ?, PlaylistCreator = ? WHERE PlaylistID = ?");
                statement.setString(1, itemToSave.getPlayListName());
                statement.setString(2, itemToSave.getPlaylistCreator());
                statement.setInt(3,itemToSave.getPlaylistID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
