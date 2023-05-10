import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        ArrayList<String> STACK_INPUT = fileManager.readFile("stack.txt");
        ArrayList<String> QUEUE_INPUT = fileManager.readFile("queue.txt");
        ArrayList<Integer> stack_arraylist = new ArrayList<>();
        for(String number: STACK_INPUT.get(0).split(" ")){
            stack_arraylist.add(Integer.parseInt(number));
        }
        Collections.reverse(stack_arraylist);
        Stack stack = new Stack();
        for (Integer j : stack_arraylist) {
            stack.push(j);
        }
        Queue queue = new Queue();
        for (String number : QUEUE_INPUT.get(0).split(" ")){
            queue.offer(Integer.parseInt(number));
        }
        ArrayList<String> COMMAND_INPUT = fileManager.readFile(args[0]);
        File stack_out = new File("stackOut.txt");
        File queue_out = new File("queueOut.txt");
        String output_line = "";
        Path stackfile = Paths.get("stack.txt");
        Path queuefile = Paths.get("queue.txt");
        for (String line : COMMAND_INPUT) {
            if (line.split(" ")[0].equals("S")){
                switch (line.split(" ")[1]) {
                    case "removeGreater":
                        int value = Integer.parseInt(line.split(" ")[2]);
                        Stack temporary_stack = new Stack();
                        while(!stack.isEmpty())
                            if(stack.peek() <= value){
                                temporary_stack.push(stack.pop());
                            }else{
                                stack.pop();
                            }
                        while(!temporary_stack.isEmpty()){
                            stack.push(temporary_stack.pop());
                        }
                        output_line = "After " + String.join(" ",line.split(" ")[1],line.split(" ")[2])+":";
                        fileManager.appendFile(stack_out, output_line);
                        fileManager.appendFile(stack_out, stack.toString());
                        fileManager.writeFile(stackfile, new ArrayList<>(Arrays.asList(stack.toString())));
                        break;
                    case "calculateDistance":
                        int distance = 0;
                        Stack stack_clone = stack.clone();
                        while(stack_clone.size()>0){
                            int current_val = stack_clone.pop();
                            Stack stack_clone2 = stack_clone.clone();
                            while(!stack_clone2.isEmpty()){
                                int sum = Math.abs(current_val - stack_clone2.pop());
                                distance += sum;
                            }
                        }
                        output_line = "After " + line.split(" ")[1]+":";
                        fileManager.appendFile(stack_out, output_line);
                        fileManager.appendFile(stack_out, "Total distance="+distance);
                        fileManager.writeFile(stackfile, new ArrayList<>(Arrays.asList(stack.toString())));
                        break;
                    case "addOrRemove":
                        if (Integer.parseInt(line.split(" ")[2]) < 0){
                            for (int i = 0; i < Math.abs(Integer.parseInt(line.split(" ")[2])); i++){
                                stack.pop();
                            }
                        }else if(Integer.parseInt(line.split(" ")[2]) > 0){
                            for (int i = 0; i < Math.abs(Integer.parseInt(line.split(" ")[2])); i++){
                                Random random = new Random();
                                stack.push(random.nextInt(50));
                            }
                        }
                        output_line = "After " + String.join(" ",line.split(" ")[1],line.split(" ")[2])+":";
                        fileManager.appendFile(stack_out, output_line);
                        fileManager.appendFile(stack_out, stack.toString());
                        fileManager.writeFile(stackfile, new ArrayList<>(Arrays.asList(stack.toString())));
                        break;
                    case "reverse":
                        int reverse_value = Integer.parseInt(line.split(" ")[2]);
                        Queue temporary_queue = new Queue();
                        for (int i = 0; i < reverse_value; i++) {
                            temporary_queue.offer(stack.pop());
                        }
                        while (!temporary_queue.isEmpty()){
                            stack.push(temporary_queue.poll());
                        }
                        output_line = "After " + String.join(" ",line.split(" ")[1],line.split(" ")[2])+":";
                        fileManager.appendFile(stack_out, output_line);
                        fileManager.appendFile(stack_out, stack.toString());
                        fileManager.writeFile(stackfile, new ArrayList<>(Arrays.asList(stack.toString())));
                        break;
                    case "sortElements":
                        Stack stack_sort = new Stack();
                        while (!stack.isEmpty()){
                            int val = stack.pop();
                            while(!stack_sort.isEmpty() && stack_sort.peek()>val){
                                stack.push(stack_sort.pop());
                            }
                            stack_sort.push(val);
                        }
                        while(!stack_sort.isEmpty()){
                            stack.push(stack_sort.pop());
                        }
                        output_line = "After " + line.split(" ")[1]+":";
                        fileManager.appendFile(stack_out, output_line);
                        fileManager.appendFile(stack_out, stack.toString());
                        fileManager.writeFile(stackfile, new ArrayList<>(Arrays.asList(stack.toString())));
                        break;
                    case "distinctElements":
                        int indistinct = 0;
                        Stack stack_distinct = stack.clone();
                        while(stack_distinct.size()>0){
                            int current_val = stack_distinct.pop();
                            Stack stack_distinct2 = stack_distinct.clone();
                            while(!stack_distinct2.isEmpty()){
                                if (current_val == stack_distinct2.pop()){
                                    indistinct++;
                                }
                            }
                        }
                        int distinct = stack.size() - indistinct;
                        output_line = "After " + line.split(" ")[1]+":";
                        fileManager.appendFile(stack_out, output_line);
                        fileManager.appendFile(stack_out, "Total distinct element="+distinct);
                        fileManager.writeFile(stackfile, new ArrayList<>(Arrays.asList(stack.toString())));
                        break;
                }
            }else{
                switch (line.split(" ")[1]) {
                    case "removeGreater":
                        int value = Integer.parseInt(line.split(" ")[2]);
                        Queue temporary_queue = new Queue();
                        while(!queue.isEmpty()){
                            if (queue.peek() <= value){
                                temporary_queue.offer(queue.poll());
                            }else{
                                queue.poll();
                            }
                        }
                        while(!temporary_queue.isEmpty()){
                            queue.offer(temporary_queue.poll());
                        }
                        output_line = "After " + String.join(" ",line.split(" ")[1],line.split(" ")[2])+":";
                        fileManager.appendFile(queue_out, output_line);
                        fileManager.appendFile(queue_out, queue.toString());
                        fileManager.writeFile(queuefile, new ArrayList<>(Arrays.asList(queue.toString())));
                        break;
                    case "calculateDistance":
                        int distance = 0;
                        Queue queue_clone = queue.clone();
                        while(queue_clone.size()>0){
                            int current_val = queue_clone.poll();
                            Queue queue_clone2 = queue_clone.clone();
                            while(!queue_clone2.isEmpty()){
                                int sum = Math.abs(current_val - queue_clone2.poll());
                                distance += sum;
                            }
                        }
                        output_line = "After " + line.split(" ")[1]+":";
                        fileManager.appendFile(queue_out, output_line);
                        fileManager.appendFile(queue_out, "Total distance="+distance);
                        fileManager.writeFile(queuefile, new ArrayList<>(Arrays.asList(queue.toString())));
                        break;
                    case "addOrRemove":
                        if (Integer.parseInt(line.split(" ")[2]) < 0){
                            for (int i = 0; i < Math.abs(Integer.parseInt(line.split(" ")[2])); i++){
                                queue.poll();
                            }
                        }else if(Integer.parseInt(line.split(" ")[2]) > 0){
                            for (int i = 0; i < Math.abs(Integer.parseInt(line.split(" ")[2])); i++){
                                Random random = new Random();
                                queue.offer(random.nextInt(50));
                            }
                        }
                        output_line = "After " + String.join(" ",line.split(" ")[1],line.split(" ")[2])+":";
                        fileManager.appendFile(queue_out, output_line);
                        fileManager.appendFile(queue_out, queue.toString());
                        fileManager.writeFile(queuefile, new ArrayList<>(Arrays.asList(queue.toString())));
                        break;
                    case "reverse":
                        Queue temporary_queue_reverse = new Queue();
                        Stack temporary_stack_reverse = new Stack();
                        int value_reverse = Integer.parseInt(line.split(" ")[2]);
                        for (int i = 0; i < value_reverse; i++) {
                            temporary_stack_reverse.push(queue.poll());
                        }
                        while(!queue.isEmpty()){
                            temporary_queue_reverse.offer(queue.poll());
                        }
                        while(!temporary_stack_reverse.isEmpty()){
                            queue.offer(temporary_stack_reverse.pop());
                        }
                        while(!temporary_queue_reverse.isEmpty()){
                            queue.offer(temporary_queue_reverse.poll());
                        }
                        output_line = "After " + String.join(" ",line.split(" ")[1],line.split(" ")[2])+":";
                        fileManager.appendFile(queue_out, output_line);
                        fileManager.appendFile(queue_out, queue.toString());
                        fileManager.writeFile(queuefile, new ArrayList<>(Arrays.asList(queue.toString())));
                        break;
                    case "sortElements":
                        Stack queue_sort_stack1 = new Stack();
                        while(!queue.isEmpty()){                            //I used the same sort algorithm i used for
                            queue_sort_stack1.push(queue.poll());           //stacks. It takes the values in the queue file
                        }                                                   //to a temporary stack and applies the algorithm.
                        Stack queue_sort_stack2 = new Stack();
                        while (!queue_sort_stack1.isEmpty()){
                            int val = queue_sort_stack1.pop();
                            while(!queue_sort_stack2.isEmpty() && queue_sort_stack2.peek()>val){
                                queue_sort_stack1.push(queue_sort_stack2.pop());
                            }
                            queue_sort_stack2.push(val);
                        }
                        while(!queue_sort_stack2.isEmpty()){
                            queue_sort_stack1.push(queue_sort_stack2.pop());
                        }
                        while(!queue_sort_stack1.isEmpty()){
                            queue.offer(queue_sort_stack1.pop());
                        }
                        output_line = "After " + line.split(" ")[1]+":";
                        fileManager.appendFile(queue_out, output_line);
                        fileManager.appendFile(queue_out, queue.toString());
                        fileManager.writeFile(queuefile, new ArrayList<>(Arrays.asList(queue.toString())));
                        break;
                    case "distinctElements":
                        int indistinct = 0;
                        Queue queue_distinct = queue.clone();
                        while(queue_distinct.size()>0){
                            int current_val = queue_distinct.poll();
                            Queue queue_distinct2 = queue_distinct.clone();
                            while(!queue_distinct2.isEmpty()){
                                if (current_val == queue_distinct2.poll()){
                                    indistinct++;
                                }
                            }
                        }
                        int distinct = queue.size() - indistinct;
                        output_line = "After " + line.split(" ")[1]+":";
                        fileManager.appendFile(queue_out, output_line);
                        fileManager.appendFile(queue_out, "Total distinct element="+distinct);
                        fileManager.writeFile(queuefile, new ArrayList<>(Arrays.asList(queue.toString())));
                        break;
                }
            }
        }
    }
}
