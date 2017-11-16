package Database.ModelClasses;

public class Album {

    int albumID;
    String albumName;
    String releaseDate;
    int trackCount;

    public Album(int albumID, String albumName, String releaseDate, int trackCount) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.trackCount = trackCount;
    }
}
