package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public abstract class UnaryOperation implements Expression {

    protected Expression child;

    public UnaryOperation(Expression child) {
        this.child = child;
    }

    public abstract String symbol();

    @Override
    public String represent() {
        return child.represent() + " " + symbol();
    }
}
