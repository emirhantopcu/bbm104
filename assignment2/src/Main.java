import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Reader reader = new Reader();
		ArrayList<String> personneldata = reader.readFile(args[0]);
		ArrayList<String> monitoringdata = reader.readFile(args[1]);
		for(String a: personneldata){
			ArrayList<String> person = new ArrayList<>();
			for (String word : a.split("\t")) {
				person.add(word);
			}
			if (person.get(2).equals("FACULTY_MEMBER")) {
				FacultyMember personnel = new FacultyMember(person.get(0),person.get(1),person.get(2),Integer.parseInt(person.get(3)),0);
				ArrayList<String> onemonitor = new ArrayList<>();
				for (String hours : monitoringdata.get(personneldata.indexOf(a)).split("\t"))  {
					onemonitor.add(hours);
				}
				personnel.salaryCalculator(onemonitor);
				reader.outputWriter(personnel);
			}
			else if (person.get(2).equals("WORKER")) {
				Worker personnel = new Worker(person.get(0),person.get(1),person.get(2),Integer.parseInt(person.get(3)),0);
				ArrayList<String> onemonitor = new ArrayList<>();
				for (String hours : monitoringdata.get(personneldata.indexOf(a)).split("\t"))  {
					onemonitor.add(hours);
				}
				personnel.salaryCalculator(onemonitor);
				reader.outputWriter(personnel);
			}
			else if (person.get(2).equals("CHIEF")) {
				Chief personnel = new Chief(person.get(0),person.get(1),person.get(2),Integer.parseInt(person.get(3)),0);
				ArrayList<String> onemonitor = new ArrayList<>();
				for (String hours : monitoringdata.get(personneldata.indexOf(a)).split("\t"))  {
					onemonitor.add(hours);
				}
				personnel.salaryCalculator(onemonitor);
				reader.outputWriter(personnel);
			}
			else if (person.get(2).equals("OFFICER")) {
				Officer personnel = new Officer(person.get(0),person.get(1),person.get(2),Integer.parseInt(person.get(3)),0);
				ArrayList<String> onemonitor = new ArrayList<>();
				for (String hours : monitoringdata.get(personneldata.indexOf(a)).split("\t"))  {
					onemonitor.add(hours);
				}
				personnel.salaryCalculator(onemonitor);
				reader.outputWriter(personnel);
			}
			else if (person.get(2).equals("SECURITY")) {
				Security personnel = new Security(person.get(0),person.get(1),person.get(2),Integer.parseInt(person.get(3)),0);
				ArrayList<String> onemonitor = new ArrayList<>();
				for (String hours : monitoringdata.get(personneldata.indexOf(a)).split("\t"))  {
					onemonitor.add(hours);
				}
				personnel.salaryCalculator(onemonitor);
				reader.outputWriter(personnel);
			}
			else if (person.get(2).equals("PARTTIME_EMPLOYEE")) {
				PartTimeEmployee personnel = new PartTimeEmployee(person.get(0),person.get(1),person.get(2),Integer.parseInt(person.get(3)),0);
				ArrayList<String> onemonitor = new ArrayList<>();
				for (String hours : monitoringdata.get(personneldata.indexOf(a)).split("\t"))  {
					onemonitor.add(hours);
				}
				personnel.salaryCalculator(onemonitor);
				reader.outputWriter(personnel);
			}
		}
	}
}

