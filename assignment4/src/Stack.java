import java.awt.*;
import java.util.ArrayList;

public class Stack {
    public Stack() {
        temp_list = new ArrayList<>();
    }

    private ArrayList<Integer> temp_list;

    public void push(Integer i){
        if(temp_list.isEmpty()){
            temp_list.add(i);
        }else{
            temp_list.add(0,i);
        }
    }

    public int pop(){
        if(!temp_list.isEmpty()){
            int value = temp_list.get(0);
            temp_list.remove(0);
            return value;
        }else{
            return -999;
        }
    }

    public int peek(){
        if(!temp_list.isEmpty()){
            return temp_list.get(0);
        }else{
            return -999;
        }
    }

    public int size(){
        return temp_list.size();
    }

    public boolean isEmpty(){
        if (temp_list.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    public void monitor(){
        System.out.println(temp_list);
    }

    public Stack clone(){
        Stack stack_clone = new Stack();
        stack_clone.temp_list = (ArrayList<Integer>) temp_list.clone();
        return stack_clone;
    }

    public String toString(){
        String result = "";
        for (Integer i : temp_list) {
            result += i+" ";
        }
        return result;
    }

}
