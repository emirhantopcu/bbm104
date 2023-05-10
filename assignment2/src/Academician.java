import java.util.ArrayList;

public class Academician extends Personnel {
    public Academician(String name, String id, String positionname, int yearofstart, int salary) {
        super(name, id, positionname, yearofstart, salary);
    }
    int basesalary = 2600;
    @Override
    public void salaryCalculator(ArrayList<String> monitoringdata) {
        super.salaryCalculator(monitoringdata);
        this.salary += basesalary;
    }
}
