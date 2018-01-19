package MainController;

import AudioController.AudioController;
import GUI.GUI;

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
}
