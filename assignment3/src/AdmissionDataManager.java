import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdmissionDataManager implements IDataAccess {
    public AdmissionDataManager() {
    }
    Reader reader = new Reader();
    ArrayList<Admission> admissionlist = reader.readAdmissions(reader.readFile("admission.txt"));
    Path admissionfile = Paths.get("admission.txt");
    Comparator<Admission> admissionComparator = new Comparator<Admission>() {
        @Override
        public int compare(Admission o1, Admission o2) {
            return o1.getAdmission_id() - o2.getAdmission_id();
        }
    };
    @Override
    public Admission getByID(int id) {
        for (Admission admission : admissionlist) {
            if(admission.getAdmission_id() == id){
                return admission;
            }
        }
        return null;
    }

    @Override
    public void deleteByID(int id) {
        int value = 0;
        for (Admission admission : admissionlist) {
            if(admission.getPatient_id() == id){
                value = admissionlist.indexOf(admission);
            }
        }
        admissionlist.remove(value);
        fileUpdater();
    }

    @Override
    public void add(Object object) {
        Admission newAdmission = (Admission) object;
        admissionlist.add(newAdmission);
        admissionlist.sort(admissionComparator);
        fileUpdater();
    }

    public void addExamination(int id, ArrayList<String> examinationline){
        for (Admission a : admissionlist) {
            if(a.getAdmission_id() == id){
                if(examinationline.get(0).equals("Inpatient")){
                    Examination ex = new Inpatient();
                    for (String word : (examinationline.subList(1,examinationline.size()))) {
                        if (word.equals("doctorvisit")){
                            ex = new DoctorVisit(ex);
                        }if(word.equals("imaging")){
                            ex = new Imaging(ex);
                        }if(word.equals("tests")){
                            ex = new Tests(ex);
                        }if(word.equals("measurements")){
                            ex = new Measurements(ex);
                        }
                    }
                    a.addEx(ex);
                }
                if(examinationline.get(0).equals("Outpatient")){
                    Examination ex = new Outpatient();
                    for (String word : (examinationline.subList(1,examinationline.size()))) {
                        if (word.equals("doctorvisit")){
                            ex = new DoctorVisit(ex);
                        }if(word.equals("imaging")){
                            ex = new Imaging(ex);
                        }if(word.equals("tests")){
                            ex = new Tests(ex);
                        }if(word.equals("measurements")){
                            ex = new Measurements(ex);
                        }
                    }
                    a.addEx(ex);
                }
            }
        }
        fileUpdater();
    }

    @Override
    public ArrayList<String> getALL() {
        ArrayList <String> list = new ArrayList<>();
        for (Admission p: admissionlist){
            list.add(p.toString());
        }
        return list;
    }
                                    //Updates file after each process
    @Override
    public void fileUpdater(){
        ArrayList<String> txtlines = getALL();
        reader.writeFile(admissionfile, txtlines);
    }

    public int cost(int id) {
        int totalcost = 0;
        for (Admission a : admissionlist) {
            if (a.getAdmission_id() == id){
                for (Examination e : a.getExaminations()){
                    totalcost += e.getCost();
                }
            }
        }
        return totalcost;
    }
}
