package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SongList {

    private final List<Song> listOfSongs;
    private int songCursor;
    private boolean isPlaying;

    public SongList(List<Song> l) {
        listOfSongs = l;
        songCursor = 0;
        isPlaying = false;
    }

    public SongList() {
        listOfSongs = new ArrayList<>();
        songCursor = 0;
        isPlaying = false;
    }

    public boolean isEmptySongList() {
        return this.listOfSongs.isEmpty();
    }

    public int getSongCursor() {
        return songCursor;
    }

    public void setSongCursor(int songCursor) {
        if (songCursor <= listOfSongs.size() && songCursor >= 0) {
            this.songCursor = songCursor;
        } else {
            throw new IndexOutOfBoundsException("The cursor must be set to a valid position.");
        }
    }

    public boolean isItPlaying() {
        return isPlaying;
    }

    public void addSong(Song mySong, int pos) {
        if (pos <= listOfSongs.size() && pos >= 0) {
            listOfSongs.add(pos, mySong);
            if (pos<=songCursor)
                nextSong();
        }
        else 
            throw new IndexOutOfBoundsException("The position must be valid.");
    }

    public void addSong(Song mySong) {
        listOfSongs.add(listOfSongs.size(), mySong);
    }

    public void removeSong(int pos) {
        if (isValidPosition(pos)){
            if(!listOfSongs.isEmpty()){
                listOfSongs.remove(pos);
                if (listOfSongs.isEmpty()||pos==songCursor) {
                    setSongCursor(0);
                    isPlaying=false;
                } 
                else 
                    if(songCursor>pos)
                        previousSong();
            }
            else throw new IllegalArgumentException("The list is empty");
        }
        else throw new IndexOutOfBoundsException("The position on the list must be valid");
    }

    public boolean isValidPosition(int position){
        return (position>=0)&&(position<=listOfSongs.size());
    }
    
    public void moveSong(int origin, int destination) {
        if (isEmptySongList())
            throw new IllegalArgumentException("The list is empty.");
        else {
            if (destination != origin) {
                if (isValidPosition(origin)&&isValidPosition(destination)){
                    Song song =listOfSongs.get(origin);
                    listOfSongs.remove(song);
                    listOfSongs.add(destination,song);
                    if (destination == songCursor) {
                        if (destination > origin) {
                            setSongCursor(songCursor - 1);
                        } else {
                            setSongCursor(destination);
                        }
                    }else if (origin == getSongCursor()) {
                        setSongCursor(destination);
                    } else if ((destination > songCursor) && (origin < songCursor)) {
                        setSongCursor(songCursor - 1);
                    } else if ((destination < songCursor) && (origin > songCursor)) {
                        setSongCursor(songCursor + 1);
                    }
                } else
                    throw new IndexOutOfBoundsException("The song cannot be found in the list.");
            }
        }
    }

    public Song playSong() {
        if (isEmptySongList()) {
            throw new IllegalArgumentException("The list is empty.");
        } else {
            isPlaying = true;
            return listOfSongs.get(songCursor);
        }
    }

    public void nextSong() {
        if (isEmptySongList()) {
            throw new IndexOutOfBoundsException("The list is empty.");
        } else if (songCursor == listOfSongs.size() - 1) {
            songCursor = 0;
        } else {
            songCursor++;
        }
    }

    public void previousSong() {
        if (isEmptySongList()) {
            throw new IndexOutOfBoundsException("The list is empty.");
        } else if (songCursor == 0) {
            songCursor = listOfSongs.size() - 1;
        } else {
            songCursor--;
        }
    }

    public void stopSong() {
        isPlaying = false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < listOfSongs.size(); i++) {
            str.append(listOfSongs.get(i).toString());
            str.append("\n");
        }
        str.append(songCursor);
        str.append("\n");
        return str.toString();
    }

    public void arrange() {
        stopSong();
        songCursor = 0;
        Collections.sort(this.listOfSongs);
    }

    public void arrange(Comparator<Song> comparator) {
        isPlaying = false;
        songCursor = 0;
        Collections.sort(this.listOfSongs, comparator);
    }
}
