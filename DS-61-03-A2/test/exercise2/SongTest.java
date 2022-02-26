package exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

public class SongTest {

    @Test
    public void testGetAuthor() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        assertEquals("U2", song.getAuthor());
    }

    @Test
    public void testGetTitle() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        assertEquals("One", song.getTitle());
    }

    @Test
    public void testGetAlbum() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        assertEquals("Achtung Baby", song.getAlbum());
    }

    @Test
    public void testGetStyle() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        assertEquals("Rock", song.getStyle());
    }

    @Test
    public void testToString() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        assertEquals("One - U2 - Achtung Baby - Rock", song.toString());
    }

    @Test
    public void testToStringTruncate1() {
        Song song = new Song("Another one bites the dust", "Queen", "The Game", "Rock");
        assertEquals("Another one bites th - Queen - The Game - Rock", song.toString());
    }

    @Test
    public void testToStringTruncate2() {
        Song song = new Song("Verano", "No me pises que llevo chanclas", "Exitos", "Pop");
        assertEquals("Verano - No me pises que llev - Exitos - Pop", song.toString());
    }

    @Test
    public void testToStringNoTruncate4() {
        Song song = new Song("Músico Loco", "El último de la fila", "Nuevo pequeno catálogo de seres y estares", "Pop");
        assertNotEquals("Musico Loco - El último de la fila - Nuevo pequeno catálogo de", song.toString());
    }

    @Test
    public void testToStringNoTruncate6() {
        Song song = new Song("No me pises que llevo chanclas", "Another one bites the dust", "Nuevo pequeno catálogo de seres y estares", "Pop");
        assertNotEquals("No me pises que llev - Another one bites th - Nuevo pequeno catálogo de", song.toString());
    }

    @Test
    public void testEquals() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        Song song2 = new Song("One", "U2", "The best of U2", "Rock");
        assertEquals(song, song2);
    }

    @Test
    public void testNotEqualsDifferentAuthor() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        Song song2 = new Song("One", "U2 and Mary J. Blige", "The best of U2", "Rock");
        assertNotEquals(song, song2);
    }

    @Test
    public void testNotEqualsDifferentTitleAuthor() {

        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        Song song2 = new Song("Two", "U2 and Mary J. Blige", "The best of U2", "Rock");
        assertNotEquals(song, song2);
    }

    //Testing equality against a null object
    @Test
    public void testFalseNull() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        assertNotEquals(song, null);
    }

    //Testing equality between different classes
    @Test
    public void testFalseDifClass() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        String song2 = "DifClass";
        assertNotEquals(song, song2);
    }

    @Test
    public void testHashCode() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        Song song2 = new Song("One", "U2", "The best of U2", "Rock");
        assertEquals(song.hashCode(), song2.hashCode());
    }

    @Test
    public void testHashCodeDifferentAuthor() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        Song song2 = new Song("One", "U2 and Mary J. Blige", "Achtung Baby", "Rock");
        assertNotEquals(song.hashCode(), song2.hashCode());
    }

    @Test
    public void testHashCodeDifferentTitleAuthor() {
        Song song = new Song("One", "U2", "Achtung Baby", "Rock");
        Song song2 = new Song("Two", "U2 and Mary J. Blige", "Achtung Baby", "Rock");
        assertNotEquals(song.hashCode(), song2.hashCode());
    }

    @Test
    public void testCompareTo() {
        Song song1 = new Song("A", "author", "album", "style");
        Song song2 = new Song("B", "author", "B", "style");
        Song song3 = new Song("B", "author", "A", "style");

        assertTrue((song1.compareTo(song2) < 0));
        assertTrue((song2.compareTo(song1) > 0));
        assertTrue((song1.compareTo(song1) == 0));
        assertTrue((song2.compareTo(song3) > 0));
        assertTrue((song3.compareTo(song2) < 0));
        assertTrue((song2.compareTo(song2) == 0));
    }

}
