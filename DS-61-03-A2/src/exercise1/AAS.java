package exercise1;

public abstract class AAS extends Employee {

    private int extraHours;
    private final double extraHoursWage;

    public final int getExtraHours() {
        return extraHours;
    }

    public final void setExtraHours(int extraHours) {
        if (extraHours < 0) {
            throw new IllegalArgumentException("Illegal argument: extraHours must be positive");
        } else {
            this.extraHours = extraHours;
        }
    }

    public AAS(String name, int age, String id, double hourlyWage, int hoursPerWeek, double extraHoursWage) {
        super(name, age, id, hourlyWage, hoursPerWeek);
        this.extraHoursWage = extraHoursWage;
    }

    public final double getExtraHoursWage() {
        return extraHoursWage;
    }

    public double extraSalary() {
        return (extraHours * extraHoursWage);
    }
}
