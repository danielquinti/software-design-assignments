/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

public class AuthorAlbumTitleComparatorTest {

    @Test
    public void testCompareTo() {
        AuthorAlbumTitleComparator comparator = new AuthorAlbumTitleComparator();
        Song song1 = new Song("title", "A", "album", "style");
        Song song2 = new Song("title", "B", "album", "style");
        Song song3 = new Song("title", "A", "A", "style");
        Song song4 = new Song("title", "A", "B", "style");
        Song song5 = new Song("A", "A", "A", "style");
        Song song6 = new Song("B", "A", "A", "style");

        assertTrue(comparator.compare(song1, song2) < 0);
        assertTrue(comparator.compare(song2, song1) > 0);
        assertTrue(comparator.compare(song1, song1) == 0);
        assertTrue(comparator.compare(song3, song4) < 0);
        assertTrue(comparator.compare(song4, song3) > 0);
        assertTrue(comparator.compare(song5, song6) < 0);
        assertTrue(comparator.compare(song6, song5) > 0);
        assertTrue(comparator.compare(song5, song5) == 0);
    }

}
