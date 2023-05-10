import java.util.ArrayList;

public class MyStack{
    private ArrayList<Integer> templist;
    private int topOfStack = -1;
    public MyStack() {
        templist = new ArrayList<>();
    }

    public void push(Integer input){
        if (!isFull()){
            topOfStack++;
            templist.add(input);
        }
    }

    public Integer pop(){
        if(!isEmpty()){
            int popValue = templist.get(topOfStack);
            templist.remove(topOfStack);
            topOfStack--;
            return popValue;
        }
        return null;
    }

    public Integer top(){
        return templist.get(topOfStack);
    }

    private boolean isFull(){
        if(templist.size() == 10){
            return true;
        }
        return false;
    }

    private boolean isEmpty(){
        if (templist.size() == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return templist.size();
    }

}
