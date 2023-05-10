import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Reader reader = new Reader();
        ArrayList<String> inputlines = reader.readFile(args[0]);
        Comparator<Contact> comparator = new LastNameComparator();
        ArrayList<Contact> contactsArrayList = new ArrayList<>();
        HashSet<Contact> contactsHashSet = new HashSet<>();
        TreeSet<Contact> contactsTreeSet = new TreeSet<>();
        TreeSet<Contact> contactsTreeSetSorted = new TreeSet<>(comparator);
        HashMap<String, Contact> contactsHashMap = new HashMap<>();
        for (String line : inputlines) {
            String[] splittedline = line.split(" ");
            Contact contact = new Contact(splittedline[0], splittedline[1], splittedline[2], splittedline[3]);
            contactsArrayList.add(contact);
            contactsHashSet.add(contact);
            contactsTreeSet.add(contact);
            contactsTreeSetSorted.add(contact);
            contactsHashMap.put(splittedline[0], contact);
        }
        File file1 = new File("contactsArrayList.txt");
        for (Contact c: contactsArrayList) {
            reader.appendFile(file1,c.toString());
        }
        File file2 = new File("contactsArrayListOrderByLastName.txt");
        ArrayList<Contact> contactsArrayListSorted = (ArrayList<Contact>) contactsArrayList.clone();
        contactsArrayListSorted.sort(comparator);
        for (Contact c: contactsArrayListSorted) {
            reader.appendFile(file2,c.toString());
        }
        File file3 = new File("contactsHashSet.txt");
        for (Contact c: contactsHashSet) {
            reader.appendFile(file3,c.toString());
        }
        File file4 = new File("contactsTreeSet.txt");
        for (Contact c: contactsTreeSet) {
            reader.appendFile(file4,c.toString());
        }
        File file5 = new File("contactsTreeSetOrderByLastName.txt");
        for (Contact c: contactsTreeSetSorted) {
            reader.appendFile(file5,c.toString());
        }
        File file6 = new File("contactsHashMap.txt");
        for (Contact c: contactsHashMap.values()) {
            reader.appendFile(file6,c.toString());
        }
    }
}
