package MainController;

import AudioController.AudioController;
import GUI.GUI;
import sun.reflect.generics.tree.VoidDescriptor;

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
}
