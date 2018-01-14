package MainController;

import Database.DatabaseConnection;
import Database.ObjectModels.Song;
import Database.ServiceClasses.SongService;

public class DatabaseFunctionality {

    public void createNewPlaylist()
    {

    }

    public void addToPlaylist(String fileName, int playlistID, DatabaseConnection databaseConnection)
    {
        if(SongService.selectByFile(fileName, databaseConnection) == null)
        {

        }
        else
        {

        }
    }

    public void loadFromPlaylist()
    {

    }

    public void loadPlaylists()
    {

    }

    public void deleteSong()
    {

    }

    public void deletePlaylist()
    {

    }


}
