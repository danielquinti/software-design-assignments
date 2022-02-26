package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public final class Division extends BinaryOperation {

    public Division(Expression leftChild, Expression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public String symbol() {
        return "÷";
    }

    @Override
    public double evaluate() {
        if (getRightChild().evaluate() != 0) {
            return getLeftChild().evaluate() / getRightChild().evaluate();
        } else {
            throw new ArithmeticException("You are dividing by zero");
        }
    }
}
