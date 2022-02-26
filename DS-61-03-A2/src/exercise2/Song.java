package exercise2;

public final class Song implements Comparable<Song> {

    private final String title;
    private final String author;
    private final String album;
    private final String style;

    /**
     * Constructs a song with the given arguments
     *
     * @param title
     * @param author
     * @param album
     * @param style
     */
    public Song(String title, String author, String album, String style) {
        this.title = title;
        this.author = author;
        this.album = album;
        this.style = style;
    }

    // Getters 
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getAlbum() {
        return album;
    }

    public String getStyle() {
        return style;
    }

    /**
     * Returns a String representing the song . Consists in concatenating title
     * , author and album , separated by dashes : " Title - Author - Album ". If
     * any of the fields is longer than 20 characters , it will be truncated to
     * 20 characters in order to avoid long Strings .
     *
     * @return String representing the song .
     */
    @Override
    public String toString() {
        /**
         * Concatenation of the attributes Title, Author and Album avoiding
         * strings longer than 20 characters.
         */
        return this.title.substring(0, Math.min(20, this.title.length())) + " - "
                + this.author.substring(0, Math.min(20, this.author.length())) + " - "
                + this.album.substring(0, Math.min(20, this.album.length())) + " - "
                + this.style.substring(0,Math.min(20,this.style.length()));
    }

    /**
     * Logical equality between two songs . Two songs are considered equals if
     * they have the same title and the same author . The album will be ignored
     * in this comparison ( the same song may appear in compilations ) and the
     * style (the same song may be classified under different styles ).
     *
     * For simplicity , we will assume that two songs are equal if and only if
     * the Strings for title and author are exactly the same ( the comparison is
     * case - sensitive ).
     *
     * @param song2 Object to be compared with the current object .
     * @return True if they are equal , false otherwise .
     */
    @Override
    public boolean equals(Object song2) {
        /*If the classes of the objects that are being compared do not match, they are not equal. 
    Nor if the compared object is null.*/
        if (song2 == null) {
            return false;
        }
        if (getClass() != song2.getClass()) {
            return false;
        }

        final Song other = (Song) song2;
        return this.title.equals(other.title) && this.author.equals(other.author);
    }

    /**
     * Returns a hash code representing the song . Remember that songs that are
     * considered equal must return the same hash code .
     *
     * @return An int representing the hash code for the song .
     */
    @Override
    public int hashCode() {
        return this.title.hashCode() * 79 + this.author.hashCode();

    }

    @Override
    public int compareTo(Song s) {
        int result = this.getTitle().compareToIgnoreCase(s.getTitle());
        if (result == 0) {
            return this.getAlbum().compareToIgnoreCase(s.getAlbum());
        }
        else return result;
    }

}
