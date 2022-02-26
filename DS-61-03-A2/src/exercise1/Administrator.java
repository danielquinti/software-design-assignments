package exercise1;

public class Administrator extends AAS {

    @Override
    public double salary() {
        return super.salary() + super.extraSalary();
    }

    public Administrator(String name, int age, String id, int extraHours) {
        super(name, age, id, 7.5, 37, 6);
        setExtraHours(extraHours);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append("(");
        if (getExtraHours() == 0) {
            str.append("Administrator");
        } else {
            str.append("Administrator with ");
            str.append(String.valueOf(getExtraHours()));
            str.append(" extra hours");
        }
        str.append("): ");
        str.append(salary());
        setExtraHours(0);
        return str.toString();
    }

}
