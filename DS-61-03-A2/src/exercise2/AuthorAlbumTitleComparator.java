package exercise2;

import java.util.Comparator;

public class AuthorAlbumTitleComparator implements Comparator<Song> {

    @Override
    public int compare(Song s1, Song s2) {
        int result = s1.getAuthor().compareToIgnoreCase(s2.getAuthor());
        if (result == 0) {
            result = s1.getAlbum().compareToIgnoreCase(s2.getAlbum());
        }
        if (result == 0) {
            result = s1.getTitle().compareToIgnoreCase(s2.getTitle());
        }
        return result;
    }
}
