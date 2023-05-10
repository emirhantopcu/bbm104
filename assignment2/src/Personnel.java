import java.util.ArrayList;

public class Personnel {
    String name;
    String id;
    String positionname;
    int yearofstart;
    int salary;

    public Personnel(String name, String id, String positionname, int yearofstart, int salary) {
        this.name = name;
        this.id = id;
        this.positionname = positionname;
        this.yearofstart = yearofstart;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public int getYearofstart() {
        return yearofstart;
    }

    public void setYearofstart(int yearofstart) {
        this.yearofstart = yearofstart;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void salaryCalculator(ArrayList<String> monitoringdata){
        int currentyear = 2020;
        double severancepay = ((currentyear - this.yearofstart) * 0.8) * 20;
        this.salary += severancepay;
    }
}
