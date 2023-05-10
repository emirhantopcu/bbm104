import java.util.ArrayList;

public class Security extends Personnel {
    public Security(String name, String id, String positionname, int yearofstart, int salary) {
        super(name, id, positionname, yearofstart, salary);
    }

    @Override
    public void salaryCalculator(ArrayList<String> monitoringdata) {
        super.salaryCalculator(monitoringdata);
        this.salary += 15 * 24;
        for (String a : monitoringdata.subList(1,5)){
            if (Integer.parseInt(a) > 5 * 6 && Integer.parseInt(a) <= 6*9){
                this.salary += Integer.parseInt(a) * 10;
            }else if (Integer.parseInt(a) > 6*9){
                this.salary += 6*9;
            }
        }
    }
}
