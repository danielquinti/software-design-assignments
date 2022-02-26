package exercise1;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 */
public final class ReadingNumbers extends CSVSeparatorState {

    private static final ReadingNumbers uniqueInstance = new ReadingNumbers();

    private ReadingNumbers() {
    }

    public static ReadingNumbers instance() {
        return uniqueInstance;
    }

    @Override
    public void read(CSVStateBasedAnalyzer c, String input, int index) {
        int p = index;
        while (p < input.length() - 1 && Character.isDigit(input.charAt(p + 1))) {
            p++;
        }
        if (p == input.length() - 1 || isSeparator(input.charAt(p + 1))) {
            c.addField(new NumberField(Integer.parseInt(input.substring(index, p + 1))));
        } else {
            throw new IllegalArgumentException("ERROR: Incorrect number");
        }
        if (p < input.length() - 2) {
            c.setState(Start.instance());
            c.getState().read(c, input, p + 1);
        }
    }
}
