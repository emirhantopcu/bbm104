import java.util.ArrayList;

public class Worker extends FullTimeEmployee {
    public Worker(String name, String id, String positionname, int yearofstart, int salary) {
        super(name, id, positionname, yearofstart, salary);
    }

    @Override
    public void salaryCalculator(ArrayList<String> monitoringdata) {
        super.salaryCalculator(monitoringdata);
        this.salary += 105 * 20;
        for (String a : monitoringdata.subList(1,5)){
            if (Integer.parseInt(a) - 40 < 10){
                this.salary += (Integer.parseInt(a) - 40) * 11;
            }else{
                this.salary += 10 * 11;
            }
        }
    }
}
