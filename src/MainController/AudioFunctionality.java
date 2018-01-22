package MainController;

import AudioController.AudioController;
import Database.ObjectModels.Song;
import GUI.GUI;
import java.util.ArrayList;

public class AudioFunctionality {

    private static AudioController audioController;
    private static GUI gui;

    public AudioFunctionality(AudioController audioController, GUI gui) {
        this.audioController = audioController;
        this.gui = gui;
    }

    public static void togglePause()
    {
        boolean isPlaying = audioController.togglePauseSong();
        if (isPlaying == false)
        {
            gui.playButton.setText("Play");
        }
        else
        {
            gui.playButton.setText("Pause");
        }
    }

    public static void togglePlayMode()
    {
        boolean isPlaying = audioController.togglePlayMode();
        if (isPlaying == false)
        {
            gui.playModeButton.setText("Shuffle");
        }
        else
        {
            gui.playModeButton.setText("Loop");
        }
    }

    public static void playSong(String filename) { audioController.playSong(filename);}

    public static void rewindSong()
    {
        audioController.rewind();
    }

    public static void skipSong()
    {
        audioController.skipSong();
    }

    public static void setVolume(double volume)
    {
        audioController.setVolume(volume);
    }

    public static void setPlaylist(ArrayList<Song> songs){audioController.setCurrentPlaylistSongs(songs);}
}
