package exercise2;

/**
 * @author daniel.quintillan
 * @author ivan.garcia.fernandez
 */
public abstract class BinaryOperation implements Expression {

    private final Expression leftChild;
    private final Expression rightChild;

    public BinaryOperation(Expression leftChild, Expression rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Expression getLeftChild() {
        return leftChild;
    }

    public Expression getRightChild() {
        return rightChild;
    }

    public abstract String symbol();

    @Override
    public String represent() {
        return leftChild.represent() + " " + rightChild.represent()
                + " " + this.symbol();
    }
}
