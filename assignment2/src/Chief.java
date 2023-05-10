import java.util.ArrayList;

public class Chief extends FullTimeEmployee{
    public Chief(String name, String id, String positionname, int yearofstart, int salary) {
        super(name, id, positionname, yearofstart, salary);
    }

    @Override
    public void salaryCalculator(ArrayList<String> monitoringdata) {
        super.salaryCalculator(monitoringdata);
        this.salary += 125 * 20;
        for (String a : monitoringdata.subList(1,5)){
            if (Integer.parseInt(a) - 40 < 8){
                this.salary += (Integer.parseInt(a) - 40) * 15;
            } else{
                this.salary += 8 * 15;
            }
        }
    }
}
