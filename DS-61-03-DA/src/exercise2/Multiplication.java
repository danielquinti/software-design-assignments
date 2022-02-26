package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public final class Multiplication extends BinaryOperation {

    public Multiplication(Expression leftChild, Expression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public String symbol() {
        return "×";
    }

    @Override
    public double evaluate() {
        return getLeftChild().evaluate() * getRightChild().evaluate();
    }
}
