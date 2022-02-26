package exercise2;

import java.util.Comparator;

public class StyleTitleComparator implements Comparator<Song> {

    @Override
    public int compare(Song s1, Song s2) {
        int result = s1.getStyle().compareToIgnoreCase(s2.getStyle());
        if (result == 0) {
            result = s1.getTitle().compareToIgnoreCase(s2.getTitle());
        }
        return result;
    }
}
