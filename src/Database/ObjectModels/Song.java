package Database.ObjectModels;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Song {

    String fileURL;
    SimpleStringProperty songTitle;
    SimpleStringProperty songAlbum;
    SimpleStringProperty songArtist;
    SimpleStringProperty releaseYear;
    SimpleIntegerProperty trackNumber;
    SimpleStringProperty length;
    SimpleStringProperty addDate;
    int songID;

    public Song(int songID, String fileURL, String songTitle, String songAlbum, String songArtist,String releaseYear, int trackNumber, String addDate) {
        this.fileURL = fileURL;
        this.songTitle = new SimpleStringProperty(songTitle);
        this.songAlbum = new SimpleStringProperty(songAlbum);
        this.songArtist = new SimpleStringProperty(songArtist);
        this.releaseYear = new SimpleStringProperty(releaseYear);
        this.trackNumber = new SimpleIntegerProperty(trackNumber);
        this.songID = songID;
        this.length = new SimpleStringProperty(Integer.toString(calculateLength()));
        this.addDate = new SimpleStringProperty(addDate);
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

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getSongTitle() {
        return songTitle.get();
    }

    public SimpleStringProperty songTitleProperty() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle.set(songTitle);
    }

    public String getSongAlbum() {
        return songAlbum.get();
    }

    public SimpleStringProperty songAlbumProperty() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum.set(songAlbum);
    }

    public String getSongArtist() {
        return songArtist.get();
    }

    public SimpleStringProperty songArtistProperty() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist.set(songArtist);
    }

    public String getReleaseYear() {
        return releaseYear.get();
    }

    public SimpleStringProperty releaseYearProperty() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear.set(releaseYear);
    }

    public int getTrackNumber() {
        return trackNumber.get();
    }

    public SimpleIntegerProperty trackNumberProperty() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber.set(trackNumber);
    }

    public String getLength() {
        return length.get();
    }

    public SimpleStringProperty lengthProperty() {
        return length;
    }

    public void setLength(String length) {
        this.length.set(length);
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getAddDate() {
        return addDate.get();
    }

    public SimpleStringProperty addDateProperty() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate.set(addDate);
    }
}
