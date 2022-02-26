package exercise1;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 */
public final class Start extends CSVSeparatorState {

    private static final Start uniqueInstance = new Start();

    private Start() {
    }

    public static Start instance() {
        return uniqueInstance;
    }

    @Override
    public void read(CSVStateBasedAnalyzer c, String input, int index) {
        boolean canGoForward = index < input.length() - 1;
        if (input.charAt(index) == '\"' && canGoForward) {
            c.setState(ReadingCharacters.instance());
            c.getState().read(c, input, index + 1);
        } else if (Character.isDigit(input.charAt(index))) {
            c.setState(ReadingNumbers.instance());
            c.getState().read(c, input, index);
        } else if (isSeparator(input.charAt(index)) && canGoForward) {
            c.getState().read(c, input, index + 1);
        } else {
            throw new IllegalArgumentException("ERROR: character not in quotation marks at position:" + Integer.toString(index));
        }
    }
}
