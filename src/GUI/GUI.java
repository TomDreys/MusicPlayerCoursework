package GUI;

import Database.ObjectModels.Playlist;
import Database.ObjectModels.Song;
import javafx.collections.ObservableList;
import javafx.scene.control.*;


public class GUI {

    //attributes that require updating during use
    public static TableView<Song> songsTable;
    public static TableView<Playlist> playlistsTable;
    public static Button channelButton;
    public static Button playButton;
    public static Button playModeButton;
    public static Label songTitleLabel;
    public static ProgressBar songProgressBar;

    //attributes that need their data read
    public static Slider volumeSlider;
    public static TextField searchTextField;
    public static ComboBox searchType;
    public static ComboBox searchArea;
    public static Slider equalizerSlider1;
    public static Slider equalizerSlider2;
    public static Slider equalizerSlider3;
    public static Slider equalizerSlider4;
    public static Slider equalizerSlider5;
    public static Slider equalizerSlider6;
    public static Slider equalizerSlider7;
    public static Slider equalizerSlider8;
    public static Slider equalizerSlider9;
    public static Slider equalizerSlider10;
    public static int currentPlaylistID;

    public static void updateSongsTable(ObservableList<Song> songs)
    {
        songsTable.setItems(songs);
        songsTable.refresh();
    }

    public static void updatePlaylistsTable(ObservableList<Playlist> playlists)
    {
        playlistsTable.setItems(playlists);
        playlistsTable.refresh();
    }

}
