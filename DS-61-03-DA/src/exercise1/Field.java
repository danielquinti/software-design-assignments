package exercise1;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 * @param <T>
 */
public abstract class Field<T> {

    private final T value;

    public Field(T input) {
        value = input;
    }

    public T getValue() {
        return this.value;
    }
}
