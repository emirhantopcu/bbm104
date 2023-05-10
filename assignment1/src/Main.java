import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;




public class Main {
    public static void main(String[] args) {
        DateComparer comparer = new DateComparer();
        ReadFromFile reader = new ReadFromFile();
        File output = new File("output.txt");
        Path file = Paths.get("output.txt");
        try {
            output.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] lines = reader.readFile(args[1]);
        ArrayList<Price> priceList = new ArrayList<Price>();
        for (String line : lines) {
            line = line.replace(" ", "-");      //takes each price in a list
            line = line.replace("\t","-");
            ArrayList<String> words = new ArrayList<String>();
            for (String a : line.split("-")) {
                words.add(a);
                words.remove("");
            }
            Price price = new Price(words.get(0), words.get(1), words.get(2), words.get(3), words.get(4));
            priceList.add(price);
        }
        String[] lines2 = reader.readFile(args[0]);
        ArrayList<String> outputLines = new ArrayList<>();
        for (String line : lines2) {
            line = line.replace(" ", "-");      //takes every purchase on the shopping list
            line = line.replace("\t", "-");     //and calculates the right price
            ArrayList<String> customer = new ArrayList<String>();
            for (String a : line.split("-")) {
                customer.add(a);
                customer.remove("");
            }
            ArrayList<String> productList = new ArrayList<>(customer.subList(4,customer.size()));
            float total = 0;
            outputLines.add("---"+customer.get(0)+" "+customer.get(1)+"---");
            for (String a : productList){
                for (Price b : priceList){
                    if(comparer.isBetween(b.getStartDate(), b.getEndDate(), customer.get(3)) && productList.indexOf(a) % 2 == 0){
                        if(customer.get(2).equals(b.getMembershipType()) && b.getProduct().equals(a)){
                            int piece = Integer.parseInt(productList.get(productList.indexOf(a)+1));
                            float price = Float.parseFloat(b.getValue());
                            price = price * piece;
                            total = total + price;
                            outputLines.add(b.getProduct()+"\t"+b.getValue()+"\t"+String.valueOf(piece)+"\t"+String.valueOf(price));
                        }
                    }
                }
            }
            outputLines.add("Total\t"+String.valueOf(total));
        }
        try{
            Files.write(file, outputLines);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}