import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PatientDataManager implements IDataAccess {
    public PatientDataManager() {
    }
    Reader reader = new Reader();
    ArrayList<Patient> patientlist = reader.readPatients(reader.readFile("patient.txt"));
    Path patientfile = Paths.get("patient.txt");
    Comparator<Patient> patientComparator = new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o1.getID() - o2.getID();
        }
    };
    Comparator<Patient> alphabetComparator = new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    @Override
    public Patient getByID(int id) {
        for (Patient patient : patientlist) {
            if(patient.getID() == id){
                return patient;
            }
        }
        return null;
    }

    @Override
    public void deleteByID(int id) {
        int value = 0;
        for (Patient patient : patientlist) {
            if(patient.getID() == id){
                value = patientlist.indexOf(patient);
            }
        }
        patientlist.remove(patientlist.get(value));
        fileUpdater();
    }

    @Override
    public void add(Object object) {
        Patient newPatient = (Patient) object;
        patientlist.add(newPatient);
        Collections.sort(patientlist,patientComparator);
        fileUpdater();
    }

    @Override
    public ArrayList<String> getALL() {
        ArrayList <String> list = new ArrayList<>();
        ArrayList<Patient> patientlistsorted =  (ArrayList<Patient>) patientlist.clone();
        Collections.sort(patientlistsorted, alphabetComparator);
        for (Patient p: patientlistsorted){
            list.add(p.format());
        }
        return list;
    }

    public ArrayList<String> getALLsorted() {
        ArrayList <String> list = new ArrayList<>();
        for (Patient p: patientlist){
            list.add(p.toString());
        }
        return list;
    }
                        //Updates files after each process
    @Override
    public void fileUpdater(){
        ArrayList<String> txtlines = getALLsorted();
        reader.writeFile(patientfile, txtlines);
    }
}
