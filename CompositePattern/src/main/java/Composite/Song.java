package Composite;

public class Song implements IComponent {
    public String songName;
    public String artist;
    public float speed = 1; // Default playback speed

    public Song(String songName, String artist ) { this.songName = songName; this.artist = artist; }

    @Override
    public void play() { System.out.println("You've chosen to play " + this.songName); }

    @Override
    public void setPlaybackSpeed(float speed) { this.speed = speed; }

    public float getPlaybackSpeed() { return speed; }


    @Override
    public String getName() { return songName; }

    public String getArtist() { return artist; }
}