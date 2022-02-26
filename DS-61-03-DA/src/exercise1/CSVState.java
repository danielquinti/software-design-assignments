package exercise1;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 */
public interface CSVState {

    public abstract void read(CSVStateBasedAnalyzer c, String input, int index);
}
