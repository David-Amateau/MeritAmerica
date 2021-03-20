package Composite;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ProgramTest {

    @Test
    public void componentInteractionTest() {
        Playlist playlist = new Playlist("Playlist");
        Song song1 = new Song("Jamming", "Jamsters");
        Song song2 = new Song("Rocking", "The Rockers");
        playlist.add(song1);
        playlist.add(song2);
        song1.setPlaybackSpeed(0.50f);
        song2.setPlaybackSpeed(1.50f);

        assertEquals("Jamming", song1.getName());
        assertEquals("Playlist", playlist.getName());
        assertEquals("Jamming", playlist.getSong(0).getName());
        assertEquals(0.50f, playlist.getSong(0).getPlaybackSpeed());

    }

}