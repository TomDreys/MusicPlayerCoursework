package Database.ModelClasses;

public class Song {

    int songID;
    String fileURL;
    String songTitle;
    int songAlbum;
    String releaseYear;
    int trackNumber;

    public Song(int songID, String fileURL, String songTitle, int songAlbum, String releaseYear, int trackNumber) {
        this.songID = songID;
        this.fileURL = fileURL;
        this.songTitle = songTitle;
        this.songAlbum = songAlbum;
        this.releaseYear = releaseYear;
        this.trackNumber = trackNumber;
    }

    public int getSongID() {
        return songID;
    }

    public int getSongAlbum() {
        return songAlbum;
    }

    public String getFileURL() {
        return fileURL;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songTitle='" + songTitle + '\'' +
                '}';
    }
}
