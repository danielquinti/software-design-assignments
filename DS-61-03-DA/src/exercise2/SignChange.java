package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public final class SignChange extends UnaryOperation {

    public SignChange(Expression child) {
        super(child);
    }

    @Override
    public double evaluate() {
        return -(this.child.evaluate());
    }

    @Override
    public String symbol() {
        return "+/-";
    }
}
