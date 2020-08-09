import java.io.IOException;
import java.util.Stack;

//剑指09
class CQueue {
    private  Stack<Integer> aa;//Stack 继承 Vector 因此若使用Deque中LinkedList的pop和push，效率更高
    private  Stack<Integer> bb;

    public CQueue() {
        aa = new Stack();
        bb = new Stack();

    }

    public void appendTail(int value) {

        while(aa.size() > 0){
            int temp = aa.pop();
            bb.push(temp);
        }
        bb.push(value);

    }

    public int deleteHead() {
        while(bb.size() > 0){
            int temp = bb.pop();
            aa.push(temp);
        }
        if(aa.size() == 0){
            return -1;
        }else{
            return aa.pop();
        }

    }

    public static void main(String[] args) throws IOException{
        CQueue a = new CQueue();
        a.appendTail(5);
        a.appendTail(2);
        System.out.println(a.deleteHead());
        System.out.println(a.deleteHead());
    }
}
