package Database.ModelClasses;

import Database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SongService {

    public static void selectAll(List<Song> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT songID, FileURL, SongTitle, SongAlbum, ReleaseYear, TrackNumber FROM Table ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Song(results.getInt("SongID"), results.getString("FileURL"), results.getString("SongTitle")
                                , results.getInt("SongAlbum"), results.getString("ReleaseYear"), results.getInt("TrackNumber")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static Song selectById(int id, DatabaseConnection database) {

        Song result = null;

        PreparedStatement statement = database.newStatement("SELECT x, y, z FROM Table WHERE id = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Song(results.getInt("SongID"), results.getString("FileURL"), results.getString("SongTitle")
                            , results.getInt("SongAlbum"), results.getString("ReleaseYear"), results.getInt("TrackNumber"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Table WHERE id = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }

    public static void save(Song itemToSave, DatabaseConnection database) {

        Song existingItem = null;
        if (itemToSave.getSongID() != 0) existingItem = selectById(itemToSave.getSongID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Table (songID, FileURL, SongTitle, SongAlbum, ReleaseYear, TrackNumber) VALUES (?, ?, ?, ?, ?, ?))");
                statement.setInt(1, itemToSave.getSongID());
                statement.setString(2, itemToSave.getFileURL());
                statement.setString(3, itemToSave.getSongTitle());
                statement.setInt(4, itemToSave.getSongAlbum());
                statement.setString(5, itemToSave.getReleaseYear());
                statement.setInt(6, itemToSave.getTrackNumber());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Table SET FileURL = ?, SongTitle = ?, SongAlbum = ?, ReleaseYear = ?, TrackNumber = ? WHERE songID = ?");
                statement.setString(1, itemToSave.getFileURL());
                statement.setString(2, itemToSave.getSongTitle());
                statement.setInt(3, itemToSave.getSongAlbum());
                statement.setString(4, itemToSave.getReleaseYear());
                statement.setInt(5, itemToSave.getTrackNumber());
                statement.setInt(6, itemToSave.getSongID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
