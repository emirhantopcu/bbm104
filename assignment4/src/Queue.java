import java.util.ArrayList;

public class Queue {
    public Queue() {
        temp_list = new ArrayList<>();
    }

    private ArrayList<Integer> temp_list;

    public void offer(Integer i){
        temp_list.add(i);
    }

    public int poll(){
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

    public Queue clone(){
        Queue queue_clone = new Queue();
        queue_clone.temp_list = (ArrayList<Integer>) temp_list.clone();
        return queue_clone;
    }

    public String toString(){
        String result = "";
        for (Integer i : temp_list) {
            result += i+" ";
        }
        return result;
    }

}
