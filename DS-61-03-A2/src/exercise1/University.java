package exercise1;

import java.text.DecimalFormat;
import java.util.List;

public class University {

    private final List<Employee> employeeList;

    public University(List<Employee> list) {
        employeeList = list;
    }


    public String printPayslips() {
        StringBuilder str = new StringBuilder();
        double count = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < employeeList.size(); i++) {
            count = count + employeeList.get(i).salary();
            str.append(employeeList.get(i).toString());
            str.append("\n");
        }
        str.append("The monthly personnel costs of the UDC is ");
        str.append(df.format(count));
        str.append(" euros\n");
        return str.toString();
    }
}
