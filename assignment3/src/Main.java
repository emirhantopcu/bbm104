import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        ArrayList<String> inputlines = reader.readFile(args[0]);
        PatientDataManager pDao = new PatientDataManager();             //Creates data access objects
        AdmissionDataManager aDao = new AdmissionDataManager();
        File outputfile = new File("output.txt");
        FileWriter writer = new FileWriter(outputfile, true);
        for (String a: inputlines) {                                    //takes each line of input file and executes given commands
            String command = a.split(" ")[0];
            switch (command) {
                case "AddPatient":
                    writer.write("Patient " + a.split(" ")[1] + " " + a.split(" ")[2] + " added\n");
                    ArrayList<String> patientinfo = new ArrayList<>();
                    Collections.addAll(patientinfo, a.split(" "));
                    Patient newPatient = new Patient(Integer.parseInt(patientinfo.get(1)), String.join(" ", patientinfo.subList(2, 4)),
                            patientinfo.get(4), String.join(" ", patientinfo.subList(5, patientinfo.size())));
                    pDao.add(newPatient);
                    break;
                case "RemovePatient":
                    writer.write("Patient " + a.split(" ")[1] + " " +
                            pDao.getByID(Integer.parseInt(a.split(" ")[1])).getName().split(" ")[0] + " removed\n");
                    pDao.deleteByID(Integer.parseInt(a.split(" ")[1]));
                    aDao.deleteByID(Integer.parseInt(a.split(" ")[1]));
                    break;
                case "CreateAdmission":
                    writer.write("Admission " + a.split(" ")[1] + " created\n");
                    ArrayList<Examination> examinations = new ArrayList<>();
                    Admission newAdmission = new Admission(Integer.parseInt(a.split(" ")[1]),
                            Integer.parseInt(a.split(" ")[2]), examinations);
                    aDao.add(newAdmission);
                    break;
                case "AddExamination":
                    writer.write(a.split(" ")[2] + " examination added to admission " + a.split(" ")[1] + "\n");
                    ArrayList<String> aLine = new ArrayList<>();
                    Collections.addAll(aLine, a.split(" "));
                    aLine.remove(0);
                    aLine.remove(0);
                    aDao.addExamination(Integer.parseInt(a.split(" ")[1]), aLine);
                    break;
                case "TotalCost":
                    int value = Integer.parseInt(a.split(" ")[1]);
                    writer.write("TotalCost for admission " + value + "\n");
                    for (Examination b : aDao.getByID(value).getExaminations()) {
                        writer.write("\t" + String.join(" ", b.getDescription().split("\t")) + b.getCost() + "$\n");
                    }
                    writer.write("\tTotal: " + aDao.cost(value) + "$\n");
                    break;
                case "ListPatients":
                    writer.write("Patient List:\n");
                    for (String line : pDao.getALL()) {
                        writer.write(line + "\n");
                    }
                    break;
            }
        }
        writer.close();
    }
}
