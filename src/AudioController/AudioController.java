package AudioController;

import Database.ObjectModels.Song;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class AudioController {

    static ArrayList<Song> currentPlaylistSongs;
    static int currentSongPointer = 0;
    static int previousSongPointer = 0;
    static MediaPlayer mediaPlayer = null;
    static boolean playMode;
    static boolean channelMode;
    static boolean isPlaying;

    public static void rewind()
    {
        if (mediaPlayer.getCurrentTime().toSeconds()< 3)
        {
            playSong(currentPlaylistSongs.get(previousSongPointer).getFileURL());
        }
        else
        {
            playSong(currentPlaylistSongs.get(currentSongPointer).getFileURL());
        }
    }

    public static void skipSong()
    {
        if (playMode == false)
        {
            previousSongPointer = currentSongPointer;
            getRandomPointer(0,currentPlaylistSongs.size() -1);
            playSong(currentPlaylistSongs.get(currentSongPointer).getFileURL());
        }
        else
        {
            previousSongPointer = currentSongPointer;
            getNextPointer();
            playSong(currentPlaylistSongs.get(currentSongPointer).getFileURL());
        }
    }

    public static boolean togglePauseSong()
    {
        if (mediaPlayer != null)
        {
            if (isPlaying == false)
            {
                mediaPlayer.play();
                isPlaying = true;
            }
            else
            {
                mediaPlayer.pause();
                isPlaying = false;
            }
        }

        return isPlaying;
    }

    public static boolean togglePlayMode()
    {
        if (playMode == false)
        {
            playMode = true;
        }
        else
        {
            playMode = false;
        }

        return playMode;
    }

    public static void setVolume(double volume)
    {
        mediaPlayer.setVolume(volume);
    }

    public static void setEqualisation()
    {

    }

    public static void setProgress()
    {

    }

    public static void setCurrentPlaylistSongs(ArrayList<Song> currentPlaylistSongs) {
        AudioController.currentPlaylistSongs = currentPlaylistSongs;
    }

    public static void playSong(String fileURL)
    {
        File songFile = new File(fileURL + ".mp3");
        if (songFile.isFile())
        {
            Media songMedia = new Media(songFile.toURI().toString());
            if (mediaPlayer != null)
            {
                mediaPlayer.stop();
            }
            mediaPlayer = new MediaPlayer(songMedia);
            mediaPlayer.play();
            isPlaying = true;
        }
        else
        {
            System.out.println("File error.");
        }
    }

    private static void getRandomPointer(int min, int max)
    {
        Random rand = new Random();
        int pointer;
        do {
            pointer = rand.nextInt(max) + min;
        }while (pointer ==  currentSongPointer);

        currentSongPointer = pointer;
    }

    private static void getNextPointer()
    {
        currentSongPointer += 1;
        if (currentSongPointer == currentPlaylistSongs.size())
        {
            currentSongPointer = 0;
        }
    }
}

