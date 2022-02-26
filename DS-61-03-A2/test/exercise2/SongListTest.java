package exercise2;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SongListTest {

    @Test
    public void isEmptySongListTest() {
        SongList songList = new SongList();
        assertEquals(true, songList.isEmptySongList());
        SongList songList2 = new SongList(new ArrayList<>());
        assertEquals(true, songList2.isEmptySongList());
    }

    @Test
    public void setSongCursorTest() {
        ArrayList<Song> list = new ArrayList<>();
        list.add(new Song("title1", "author1", "album1", "style1"));
        list.add(new Song("title2", "author2", "album2", "style2"));
        list.add(new Song("title3", "author3", "album3", "style3"));
        SongList songList = new SongList(list);
        songList.setSongCursor(2);
        assertEquals(2, songList.getSongCursor());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setSongCursorInvalidTest() {
        ArrayList<Song> list = new ArrayList<>();
        list.add(new Song("title0", "author0", "album0", "style0"));
        list.add(new Song("title2", "author2", "album2", "style2"));
        SongList songList = new SongList(list);
        songList.setSongCursor(3);
        songList.setSongCursor(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void nextSongTestInvalid() {
        SongList songList = new SongList();
        songList.nextSong();
    }

    @Test
    public void nextSongTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.addSong(song0);
        songList.nextSong();
        assertEquals(song0, songList.playSong());
        songList.addSong(song1);
        songList.nextSong();
        assertEquals(song1, songList.playSong());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void previousSongTestInvalid() {
        SongList songList = new SongList();
        songList.previousSong();
    }

    @Test
    public void previousSongTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.addSong(song0);
        songList.previousSong();
        assertEquals(song0, songList.playSong());
        songList.addSong(song1);
        songList.nextSong();
        songList.previousSong();
        assertEquals(song0, songList.playSong());
    }

    @Test
    public void playSongTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        songList.addSong(song0, 0);
        assertEquals(song0, songList.playSong());
    }

    @Test
    public void resetSongTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        songList.addSong(song0, 0);
        assertEquals(song0, songList.playSong());
    }

    @Test(expected = IllegalArgumentException.class)
    public void playSongTestInvalid() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        assertEquals(song0, songList.playSong());
    }

    @Test
    public void addSongTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        Song song2 = new Song("title2", "author2", "album2", "style2");
        songList.addSong(song0, 0);
        songList.addSong(song1, 1);
        assertEquals(song0, songList.playSong());
        songList.nextSong();
        assertEquals(song1, songList.playSong());
        songList.addSong(song2, 1);
        assertEquals(song1, songList.playSong());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addSongInvalidTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        songList.addSong(song0, -1);
        songList.addSong(song0, 1);
    }

    @Test
    public void addSongLastTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        songList.addSong(song0);

        assertEquals(song0, songList.playSong());
    }

    @Test
    public void removeSongTest() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.addSong(song0);
        songList.setSongCursor(0);
        songList.removeSong(0);
        assertEquals(true, songList.isEmptySongList());
        assertEquals(0,songList.getSongCursor());
        songList.addSong(song0);
        songList.addSong(song1);
        songList.setSongCursor(1);
        songList.removeSong(1);
        assertEquals(0,songList.getSongCursor());
    }
    
        @Test
    public void removeSongTest1() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.addSong(song0);
        songList.setSongCursor(0);
        songList.removeSong(0);
        assertEquals(true, songList.isEmptySongList());
        assertEquals(0,songList.getSongCursor());
        songList.addSong(song0);
        songList.addSong(song1);
        songList.setSongCursor(1);
        songList.removeSong(0);
        assertEquals(0,songList.getSongCursor());
        songList.addSong(song0);
        songList.addSong(song1);
        songList.setSongCursor(0);
        songList.removeSong(1);
        assertEquals(0,songList.getSongCursor());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeSongTestInvalid() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        songList.addSong(song0);
        songList.removeSong(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeSongTestInvalid2() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        songList.addSong(song0);
        songList.removeSong(-1);
    }            

    @Test(expected = IllegalArgumentException.class)
    public void removeSongTestInvalid3() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        songList.removeSong(0);
        songList.addSong(song0);
    }
    
    @Test
    public void isValidPositionTest(){
        SongList songList = new SongList();
        assertFalse(songList.isValidPosition(5));
        assertFalse(songList.isValidPosition(-3));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void moveSongTestInvalid1() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.moveSong(0, 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void moveSongTestInvalid2() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.moveSong(0, -3);        
    }    
    @Test(expected = IndexOutOfBoundsException.class)
    public void moveSongTestInvalid3() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.addSong(song0);
        songList.moveSong(-4, 0);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void moveSongTestInvalid4() {
        SongList songList = new SongList();
        Song song0 = new Song("title0", "author0", "album0", "style0");
        Song song1 = new Song("title1", "author1", "album1", "style1");
        songList.addSong(song0);
        songList.moveSong(5, 0);
    }    
    
    @Test
    public void moveSongTest1() {
        SongList songList = new SongList();
        Song song0 = new Song("0", "0", "0", "0");
        Song song1 = new Song("1", "1", "1", "1");
        Song song2 = new Song("2", "2", "2", "2");
        Song song3 = new Song("3", "3", "3", "3");
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.setSongCursor(3);
        songList.moveSong(1, 3);
        songList.moveSong(1,1);
        String expected
                = "0 - 0 - 0 - 0\n"
                + "2 - 2 - 2 - 2\n"
                + "3 - 3 - 3 - 3\n"
                + "1 - 1 - 1 - 1\n"
                + "2\n";

        assertEquals(expected, songList.toString());
    }

    @Test
    public void moveSongTest2() {
        SongList songList = new SongList();
        Song song0 = new Song("0", "0", "0", "0");
        Song song1 = new Song("1", "1", "1", "1");
        Song song2 = new Song("2", "2", "2", "2");
        Song song3 = new Song("3", "3", "3", "3");
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.setSongCursor(1);
        songList.moveSong(3, 1);
        String expected
                = "0 - 0 - 0 - 0\n"
                + "3 - 3 - 3 - 3\n"
                + "1 - 1 - 1 - 1\n"
                + "2 - 2 - 2 - 2\n"
                + "1\n";
        assertEquals(expected, songList.toString());
    }

    @Test
    public void moveSongTest3() {
        SongList songList = new SongList();
        Song song0 = new Song("0", "0", "0", "0");
        Song song1 = new Song("1", "1", "1", "1");
        Song song2 = new Song("2", "2", "2", "2");
        Song song3 = new Song("3", "3", "3", "3");
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.setSongCursor(1);
        songList.moveSong(1, 3);
        String expected
                = "0 - 0 - 0 - 0\n"
                + "2 - 2 - 2 - 2\n"
                + "3 - 3 - 3 - 3\n"
                + "1 - 1 - 1 - 1\n"
                + "3\n";
        assertEquals(expected, songList.toString());
    }

    @Test
    public void moveSongTest4() {
        SongList songList = new SongList();
        Song song0 = new Song("0", "0", "0", "0");
        Song song1 = new Song("1", "1", "1", "1");
        Song song2 = new Song("2", "2", "2", "2");
        Song song3 = new Song("3", "3", "3", "3");
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.setSongCursor(2);
        songList.moveSong(1, 3);
        String expected
                = "0 - 0 - 0 - 0\n"
                + "2 - 2 - 2 - 2\n"
                + "3 - 3 - 3 - 3\n"
                + "1 - 1 - 1 - 1\n"
                + "1\n";
        assertEquals(expected, songList.toString());
    }

    @Test
    public void moveSongTest5() {
        Song song0 = new Song("0", "0", "0", "0");
        Song song1 = new Song("1", "1", "1", "1");
        Song song2 = new Song("2", "2", "2", "2");
        Song song3 = new Song("3", "3", "3", "3");
        SongList songList = new SongList();
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.setSongCursor(2);
        songList.moveSong(3, 1);
        String expected
                = "0 - 0 - 0 - 0\n"
                + "3 - 3 - 3 - 3\n"
                + "1 - 1 - 1 - 1\n"
                + "2 - 2 - 2 - 2\n"
                + "3\n";
        assertEquals(expected, songList.toString());
    }

    @Test
    public void moveSongTest6() {
        Song song0 = new Song("0", "0", "0", "0");
        Song song1 = new Song("1", "1", "1", "1");
        Song song2 = new Song("2", "2", "2", "2");
        Song song3 = new Song("3", "3", "3", "3");
        SongList songList = new SongList();
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.setSongCursor(1);
        songList.moveSong(3, 2);
        String expected
                = "0 - 0 - 0 - 0\n"
                + "1 - 1 - 1 - 1\n"
                + "3 - 3 - 3 - 3\n"
                + "2 - 2 - 2 - 2\n"
                + "1\n";
        assertEquals(expected, songList.toString());
    }

    @Test
    public void arrangeTest() {
        Song song0 = new Song("A", "0", "A", "0");
        Song song1 = new Song("B", "0", "0", "0");
        Song song2 = new Song("A", "0", "B", "0");
        SongList songList = new SongList();
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.arrange();
        String expected
                = "A - 0 - A - 0\n"
                + "A - 0 - B - 0\n"
                + "B - 0 - 0 - 0\n"
                + "0\n";
        assertEquals(expected, songList.toString());
    }

    @Test
    public void arrangecomparatorTest() {
        Song song0 = new Song("A", "A", "A", "0");
        Song song1 = new Song("A", "A", "B", "0");
        Song song2 = new Song("0", "B", "0", "0");
        Song song3 = new Song("B", "A", "A", "0");
        SongList songList = new SongList();
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.arrange(new AuthorAlbumTitleComparator());
        String expected
                = "A - A - A - 0\n"
                + "B - A - A - 0\n"
                + "A - A - B - 0\n"
                + "0 - B - 0 - 0\n"
                + "0\n";
        String actual = songList.toString();
        assertEquals(expected, songList.toString());
    }

    @Test
    public void IsItPlayingTest() {
        SongList songList = new SongList();
        assertEquals(false, songList.isItPlaying());
    }

    @Test
    public void StopSongTest() {
        SongList songList = new SongList();
        Song song0 = new Song("0", "0", "0", "0");
        songList.addSong(song0);
        songList.playSong();
        songList.stopSong();
        assertEquals(false, songList.isItPlaying());
    }

    @Test
    public void moveSongTest7() {
        Song song0 = new Song("0", "0", "0", "0");
        Song song1 = new Song("1", "1", "1", "1");
        Song song2 = new Song("2", "2", "2", "2");
        Song song3 = new Song("3", "3", "3", "3");
        SongList songList = new SongList();
        songList.addSong(song0);
        songList.addSong(song1);
        songList.addSong(song2);
        songList.addSong(song3);
        songList.setSongCursor(1);
        songList.moveSong(2, 3);
        String expected
                = "0 - 0 - 0 - 0\n"
                + "1 - 1 - 1 - 1\n"
                + "3 - 3 - 3 - 3\n"
                + "2 - 2 - 2 - 2\n"
                + "1\n";
        assertEquals(expected, songList.toString());
    }
}
