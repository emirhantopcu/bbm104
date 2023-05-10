import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reader {
    public Reader() {
    }

    public ArrayList<String> readFile(String path) {
        try {
            ArrayList<String> results = new ArrayList<>();
            for (String line : Files.readAllLines(Paths.get(path))) {
                results.add(line);
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void writeFile(Path file, ArrayList<String> lines){
        try{
            Files.write(file, lines);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void appendFile(File file, String line){
        try{
            FileWriter writer = new FileWriter(file, true);
            writer.write(line+"\n");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Patient> readPatients(ArrayList<String> lines){
        ArrayList<Patient> patientlist = new ArrayList<>();
        for (String a : lines) {
            ArrayList<String> address = new ArrayList<>();
            for (String word : a.split("\t")[3].split(" ") ) {
                address.add(word);
            }
            address.remove(0);
            Patient patient = new Patient(Integer.parseInt(a.split("\t")[0]), a.split("\t")[1],
                    a.split("\t")[2],String.join(" ", address));
            patientlist.add(patient);
        }
        return patientlist;
    }
    public ArrayList<Admission> readAdmissions(ArrayList<String> lines){
        ArrayList<Admission> admissionlist = new ArrayList<>();
        for (String a : lines) {
            if(Character.isDigit(a.charAt(0))){
                ArrayList<Examination> examinations = new ArrayList<>();
                int index = lines.indexOf(a) + 1 ;
                while(Character.isLetter((lines.get(index).charAt(0)))){
                    String line = lines.get(index);
                    if(line.split("\t")[0].equals("Inpatient")){
                        Examination ex = new Inpatient();
                        for (String word : (line.split("\t")[1].split(" "))) {
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
                        examinations.add(ex);
                    }
                    if(line.split("\t")[0].equals("Outpatient")){
                        Examination ex = new Outpatient();
                        for (String word : (line.split("\t")[1].split(" "))) {
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
                        examinations.add(ex);
                    }
                    index += 1;
                    if(index == 12){
                        break;
                    }
                }
                Admission admission = new Admission(Character.getNumericValue(a.charAt(0)),
                        Integer.parseInt(a.split("\t")[1]),examinations);
                admissionlist.add(admission);
            }
        }
        return admissionlist;
    }
}
