package Composite;

import java.util.ArrayList;

public class Playlist implements IComponent {

    public String playlistName;
    public ArrayList<IComponent> playlist = new ArrayList();


    public Playlist(String playlistName) { this.playlistName = playlistName; }

    @Override
    public void play() {
        System.out.println("You've chosen to play " + this.playlistName);
        System.out.println("The songs on this playlist are:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(playlist.get(i).getName());
        }
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        for (IComponent component: playlist) {
            component.setPlaybackSpeed(speed);
        }
    }

    public IComponent getSong(int index) {
        return playlist.get(index);
    }

    @Override
    public String getName() { return playlistName; }

    public void add(IComponent component){ playlist.add(component); }

    public void remove(IComponent component) { playlist.remove(component); }
}