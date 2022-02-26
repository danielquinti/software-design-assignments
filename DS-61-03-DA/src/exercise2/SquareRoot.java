package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public final class SquareRoot extends UnaryOperation {

    public SquareRoot(Expression child) {
        super(child);
    }

    @Override
    public double evaluate() {
        if (child.evaluate() < 0) {
            throw new ArithmeticException();
        } else {
            return Math.sqrt(child.evaluate());
        }
    }

    @Override
    public String symbol() {
        return "√";
    }
}
