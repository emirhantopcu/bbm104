import java.util.ArrayList;

public class Officer extends Personnel {
    public Officer(String name, String id, String positionname, int yearofstart, int salary) {
        super(name, id, positionname, yearofstart, salary);
    }

    @Override
    public void salaryCalculator(ArrayList<String> monitoringdata) {
        super.salaryCalculator(monitoringdata);
        this.salary += (2600 * 65)/100 + 2600;
        for (String a : monitoringdata.subList(1,5)){
            if (Integer.parseInt(a) - 40 < 10){
                this.salary += (Integer.parseInt(a) - 40) * 20;
            }else{
                this.salary += 10 * 20;
            }
        }
    }
}
