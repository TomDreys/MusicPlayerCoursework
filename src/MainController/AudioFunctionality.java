package MainController;

import AudioController.AudioController;
import Database.ObjectModels.Song;
import java.util.ArrayList;
import static Main.Main.*;

public class AudioFunctionality {

    public static void togglePause()
    {
        boolean isPlaying = audioController.togglePauseSong();
        if (!isPlaying)
        {
            mainGui.playButton.setText("Play");
        }
        else
        {
            mainGui.playButton.setText("Pause");
        }
    }

    public static void togglePlayMode()
    {
        boolean isPlaying = audioController.togglePlayMode();
        if (!isPlaying)
        {
            mainGui.playModeButton.setText("Shuffle");
        }
        else
        {
            mainGui.playModeButton.setText("Loop");
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
