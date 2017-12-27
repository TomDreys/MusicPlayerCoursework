package Database.ObjectModels;

import javafx.beans.property.SimpleStringProperty;

public class Song {

    String fileURL;
    SimpleStringProperty songTitle;
    SimpleStringProperty songAlbum;
    SimpleStringProperty songArtist;
    SimpleStringProperty releaseYear;
    SimpleStringProperty trackNumber;
    SimpleStringProperty length;
    int songID;

    public Song(int songID, String fileURL, String songTitle, String songAlbum, String songArtist,String releaseYear, int trackNumber) {
        this.fileURL = fileURL;
        this.songTitle = new SimpleStringProperty(songTitle);
        this.songAlbum = new SimpleStringProperty(songAlbum);
        this.songArtist = new SimpleStringProperty(songArtist);
        this.releaseYear = new SimpleStringProperty(releaseYear);
        this.trackNumber = new SimpleStringProperty(Integer.toString(trackNumber));
        this.songID = songID;
        this.length = new SimpleStringProperty(Integer.toString(calculateLength()));
    }

    public int calculateLength()
    {
        return 0;
    }

    @Override
    public String toString() {
        return "Song{" +
                "fileURL='" + fileURL + '\'' +
                ", songTitle=" + songTitle +
                ", songAlbum=" + songAlbum +
                ", songArtist=" + songArtist +
                ", releaseYear=" + releaseYear +
                ", trackNumber=" + trackNumber +
                ", length=" + length +
                ", songID=" + songID +
                '}';
    }

    public String getFileURL() {
        return fileURL;
    }

    public String getSongTitle() {
        return songTitle.get();
    }

    public SimpleStringProperty songTitleProperty() {
        return songTitle;
    }

    public String getSongAlbum() {
        return songAlbum.get();
    }

    public SimpleStringProperty songAlbumProperty() {
        return songAlbum;
    }

    public String getReleaseYear() {
        return releaseYear.get();
    }

    public SimpleStringProperty releaseYearProperty() {
        return releaseYear;
    }

    public int getTrackNumber() {
        return Integer.parseInt(trackNumber.get());
    }

    public SimpleStringProperty trackNumberProperty() {
        return trackNumber;
    }

    public int getSongID() {
        return songID;
    }
}
