package exercise1;

public abstract class Employee {

    private final String name;
    private final int age;
    private final String id;
    private final double hourlyWage;
    private final int hoursPerWeek;

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final String getID() {
        return id;
    }

    public Employee(String name, int age, String id, double hourlyWage, int hoursPerWeek) {
        this.name = name;
        if (age<0)
            throw new IllegalArgumentException("Illegal argument: column or row out of bounds");
        else
            this.age = age;
        this.id = id;
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    public final double getHourlyWage() {
        return hourlyWage;
    }

    public final int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public double salary() {
        return (4 * hourlyWage * hoursPerWeek);
    }

    @Override
    public abstract String toString();
}
