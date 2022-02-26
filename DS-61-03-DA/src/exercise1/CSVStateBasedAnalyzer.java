package exercise1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 */
public final class CSVStateBasedAnalyzer implements CSVAnalyzer {

    private CSVState state = Start.instance();
    protected List<Field> output = new ArrayList<>();

    @Override
    public List<Field> read(String input) {
        state.read(this, input, 0);
        return this.output;
    }

    protected CSVState getState() {
        return state;
    }

    protected void setState(CSVState state) {
        this.state = state;
    }

    protected void addField(Field field) {
        output.add(field);
    }
}
