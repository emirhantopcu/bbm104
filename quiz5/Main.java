import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        ArrayList<String> inputLines = fileManager.readFile(args[0]);
        ArrayList<String> outputLines = new ArrayList<>();
        for (String line : inputLines) {
            MyStack octalNumbers = new MyStack();
            int dividend = Integer.parseInt(line);
            while(!(dividend == 0)){
                octalNumbers.push(dividend%8);
                dividend = dividend/8;
            }
            String octalNumber = "";
            int stackSize = octalNumbers.size();
            for (int i = 0; i < stackSize; i++) {
                octalNumber += (octalNumbers.pop());
            }
            outputLines.add(octalNumber);
        }
        fileManager.writeFile(Paths.get("octal.txt"), outputLines);
    }
}
