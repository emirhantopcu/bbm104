import java.util.ArrayList;

public class Admission {
    int admission_id;
    int patient_id;
    ArrayList<Examination> examinations;

    public Admission(int admission_id, int patient_id, ArrayList<Examination> examinations) {
        this.admission_id = admission_id;
        this.patient_id = patient_id;
        this.examinations = examinations;
    }

    public int getAdmission_id() {
        return admission_id;
    }

    public void setAdmission_id(int admission_id) {
        this.admission_id = admission_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public ArrayList<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(ArrayList<Examination> examinations) {
        this.examinations = examinations;
    }

    public void addEx(Examination examination){
        examinations.add(examination);
    }

    public String toString(){
        String out = this.admission_id+"\t"+this.patient_id;
        for (Examination a : examinations) {
            out += "\n" + a.getDescription();
        }
        return out;
    }
}
