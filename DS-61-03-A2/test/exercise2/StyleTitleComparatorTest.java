package exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

public class StyleTitleComparatorTest {

    @Test
    public void testCompareTo() {
        Song song1 = new Song("title", "author", "album", "A");
        Song song2 = new Song("title", "author", "album", "B");
        Song song3 = new Song("A", "author", "album", "A");
        Song song4 = new Song("B", "author", "album", "A");
        StyleTitleComparator comparator = new StyleTitleComparator();
        assertTrue((comparator.compare(song1, song2) < 0));
        assertTrue((comparator.compare(song2, song1) > 0));
        assertTrue((comparator.compare(song1, song1) == 0));
        assertTrue((comparator.compare(song3, song4) < 0));
        assertTrue((comparator.compare(song4, song3) > 0));
        assertTrue((comparator.compare(song3, song3) == 0));
    }

}
