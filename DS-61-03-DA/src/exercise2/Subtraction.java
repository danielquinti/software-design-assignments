package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public final class Subtraction extends BinaryOperation {

    public Subtraction(Expression leftChild, Expression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public String symbol() {
        return "-";
    }

    @Override
    public double evaluate() {
        return getLeftChild().evaluate() - getRightChild().evaluate();
    }
}
