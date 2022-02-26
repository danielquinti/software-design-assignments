package exercise1;

public class Professor extends Faculty {

    private int numberOfSYT;

    @Override
    public double salary() {
        return (super.salary() + 100 * numberOfSYT);
    }

    public Professor(String name, int age, String id, int numberOfSYT) {
        super(name, age, id, 8, 37);
        if (numberOfSYT < 0 || numberOfSYT > 6) {
            throw new IllegalArgumentException();
        } else {
            this.numberOfSYT = numberOfSYT;
        }
    }

    public int getNumberOfSYT() {
        return numberOfSYT;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append("(");
        if (getNumberOfSYT() == 0) {
            str.append("Professor");
        } else {
            str.append("Professor with ");
            str.append(String.valueOf(getNumberOfSYT()));
            str.append(" six-year terms");
        }
        str.append("): ");
        str.append(salary());
        return str.toString();
    }
}
