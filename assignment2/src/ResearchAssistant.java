import java.util.ArrayList;

public class ResearchAssistant extends Academician {
    public ResearchAssistant(String name, String id, String positionname, int yearofstart, int salary) {
        super(name, id, positionname, yearofstart, salary);
    }

    @Override
    public void salaryCalculator(ArrayList<String> monitoringdata) {
        super.salaryCalculator(monitoringdata);
        this.salary += (basesalary * 105)/100;
    }
}
