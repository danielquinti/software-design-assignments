package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public final class Number implements Expression {

    private final int value;

    Number(int i) {
        this.value = i;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String represent() {
        return Integer.toString(this.value);
    }
}
