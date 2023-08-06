import java.util.ArrayList;
import java.util.List;

interface MusicPlayer {
    void play();
    void pause();
    void stop();
    void addSong(String song);
    void removeSong(String song);
}

class MyMusicPlayer implements MusicPlayer {
    private List<String> playlist;
    private boolean isPlaying;

    public MyMusicPlayer() {
        playlist = new ArrayList<>();
        isPlaying = false;
    }

  
    public void play() {
        if (!playlist.isEmpty()) {
            isPlaying = true;
            System.out.println("Playing: " + playlist.get(0));
        } else {
            System.out.println("Playlist is empty.");
        }
    }
    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Paused.");
        } else {
            System.out.println("No song is currently playing.");
        }
    }
  public void stop() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Stopped.");
        } else {
            System.out.println("No song is currently playing.");
        }
    }

  
    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added song: " + song);
    }

   
    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed song: " + song);
        } else {
            System.out.println("Song not found in playlist.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyMusicPlayer musicPlayer = new MyMusicPlayer();

        musicPlayer.addSong("Song 1");
        musicPlayer.addSong("Song 2");
        musicPlayer.addSong("Song 3");
        musicPlayer.addSong("Song 4");
        musicPlayer.addSong("Song 5");

        musicPlayer.play();
        musicPlayer.pause();
        musicPlayer.removeSong("Song 3");
        musicPlayer.stop();
    }
}
