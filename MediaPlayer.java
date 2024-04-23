package MP3;

import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class MP3Player {
    public static void main(String[] args) {
        try {
            // Create a FileInputStream to read the MP3 file
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\user\\Music for Assignment Code\\PANTROPIKO.mp3");
            
            // Create a Player object to play the MP3 file
            Player player = new Player(fileInputStream);
            
            // Start playback
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
