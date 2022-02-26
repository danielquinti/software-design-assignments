package exercise1;

public class IT extends AAS {

    @Override
    public double salary() {
        return super.salary() + super.extraSalary();
    }

    public IT(String name, int age, String id, int extraHours) {
        super(name, age, id, 6, 40, 6);
        setExtraHours(extraHours);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append("(");
        if (getExtraHours() == 0) {
            str.append("IT");
        } else {
            str.append("IT with ");
            str.append(String.valueOf(getExtraHours()));
            str.append(" extra hours");
        }
        str.append("): ");
        str.append(salary());
        setExtraHours(0);
        return str.toString();
    }
}
