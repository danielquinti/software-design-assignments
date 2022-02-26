package exercise1;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 */
public final class ReadingCharacters extends CSVSeparatorState {

    private static final ReadingCharacters uniqueInstance = new ReadingCharacters();

    private ReadingCharacters() {
    }

    public static ReadingCharacters instance() {
        return uniqueInstance;
    }

    @Override
    public void read(CSVStateBasedAnalyzer c, String input, int index) {
        int p = index;
        while (p < input.length() - 1 && !isSeparator(input.charAt(p + 1)) && !(input.charAt(p + 1) == '\"')) {
            p++;
        }
        if (p == input.length() - 1) {
            throw new IllegalArgumentException("ERROR: Missing closing quotation marks");
        }
        if (input.charAt(p + 1) == '\"') {
            c.addField(new StringField(input.substring(index, p + 1)));
            if (p < input.length() - 2) {
                c.setState(Start.instance());
                c.getState().read(c, input, p + 2);
            }
        } else {
            throw new IllegalArgumentException("ERROR: Missing closing quotation marks");
        }
    }
}
