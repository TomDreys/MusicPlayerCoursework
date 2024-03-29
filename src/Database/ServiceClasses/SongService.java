package Database.ServiceClasses;

import Database.ObjectModels.Song;
import static Main.Main.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SongService {

    public static void selectAll(List<Song> targetList) {

        PreparedStatement statement = databaseConnection.newStatement("SELECT songID, FileURL, SongTitle, SongAlbum, Artist, ReleaseYear, TrackNumber FROM Songs ORDER BY SongID");

        try {
            if (statement != null) {

                ResultSet results = databaseConnection.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Song(results.getInt("SongID"),
                                results.getString("FileURL"),
                                results.getString("SongTitle"),
                                results.getString("SongAlbum"),
                                results.getString("Artist"),
                                results.getString("ReleaseYear"),
                                results.getInt("TrackNumber"), "N/A"));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Song Database select all error: " + resultsException.getMessage());
        }
    }

    public static Song selectById(int id) {

        Song result = null;

        PreparedStatement statement = databaseConnection.newStatement("SELECT SongID, FileURL, SongTitle, SongAlbum, Artist, ReleaseYear, TrackNumber FROM Songs WHERE SongID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = databaseConnection.executeQuery(statement);

                if (results != null) {
                    result = new Song(  results.getInt("SongID"),
                                        results.getString("FileURL"),
                                        results.getString("SongTitle"),
                                        results.getString("SongAlbum"),
                                        results.getString("Artist"),
                                        results.getString("ReleaseYear"),
                                        results.getInt("TrackNumber"),
                                                          "N/A");
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Song Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static Song selectByFile(String filepath) {

        Song result = null;

        PreparedStatement statement = databaseConnection.newStatement("SELECT SongID, FileURL, SongTitle, SongAlbum, Artist, ReleaseYear, TrackNumber FROM Songs WHERE FileURL = ?");

        try {
            if (statement != null) {

                statement.setString(1, filepath);
                ResultSet results = databaseConnection.executeQuery(statement);

                if (results != null) {
                    result = new Song(results.getInt("SongID"),
                            results.getString("FileURL"),
                            results.getString("SongTitle"),
                            results.getString("SongAlbum"),
                            results.getString("Artist") ,
                            results.getString("ReleaseYear"),
                            results.getInt("TrackNumber"), "N/A");
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Song Database select by file error: " + resultsException.getMessage());
            System.out.println("Record does not exist");
            return null;
        }

        return result;
    }

    public static void deleteById(int id) {

        PreparedStatement statement = databaseConnection.newStatement("DELETE FROM Songs WHERE SongID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                databaseConnection.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Song Database deletion error: " + resultsException.getMessage());
        }
    }

    public static void save(Song itemToSave) {

        Song existingItem = null;
        if (itemToSave.getSongID() != 0) existingItem = selectById(itemToSave.getSongID());

        try {
            if (existingItem == null) {
                PreparedStatement statement = databaseConnection.newStatement("INSERT INTO Songs  (FileURL, SongTitle, Artist, SongAlbum, ReleaseYear, TrackNumber) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, itemToSave.getFileURL());
                statement.setString(2, itemToSave.getSongTitle());
                statement.setString(3, itemToSave.getSongArtist());
                statement.setString(4, itemToSave.getSongAlbum());
                statement.setString(5, itemToSave.getReleaseYear());
                statement.setInt(6, itemToSave.getTrackNumber());
                databaseConnection.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = databaseConnection.newStatement("UPDATE Songs SET FileURL = ?, SongTitle = ?, SongAlbum = ?, Artist = ?,ReleaseYear = ?, TrackNumber = ? WHERE songID = ?");
                statement.setString(1, itemToSave.getFileURL());
                statement.setString(2, itemToSave.getSongTitle());
                statement.setString(3, itemToSave.getSongAlbum());
                statement.setString(4,itemToSave.getSongArtist());
                statement.setString(5, itemToSave.getReleaseYear());
                statement.setInt(6, itemToSave.getTrackNumber());
                statement.setInt(7, itemToSave.getSongID());
                databaseConnection.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Song Database saving error: " + resultsException.getMessage());
        }
    }
}
