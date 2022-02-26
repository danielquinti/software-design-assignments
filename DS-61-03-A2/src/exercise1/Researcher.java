package exercise1;

public class Researcher extends Faculty {

    public Researcher(String name, int age, String id) {
        super(name, age, id, 7, 35);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append("(");
        str.append("Researcher");
        str.append("): ");
        str.append(salary());
        return str.toString();
    }
}
