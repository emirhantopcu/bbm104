import java.util.ArrayList;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, String id, String positionname, int yearofstart, int salary) {
        super(name, id, positionname, yearofstart, salary);
    }

    @Override
    public void salaryCalculator(ArrayList<String> monitoringdata) {
        super.salaryCalculator(monitoringdata);
        for (String a : monitoringdata.subList(1,5)){
            if (Integer.parseInt(a) >= 10 & Integer.parseInt(a) <= 20){
                this.salary += Integer.parseInt(a) *18;
            }else if(Integer.parseInt(a) > 20){
                this.salary += 20*18;
            }
        }
    }
}
