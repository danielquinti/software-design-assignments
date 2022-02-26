package exercise1;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 */
public abstract class CSVSeparatorState implements CSVState {

    protected boolean isSeparator(char inputChar) {
        return (inputChar == '\n' || inputChar == ',');
    }
}
