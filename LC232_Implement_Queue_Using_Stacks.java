/** Yunqiu Xu*/
/** Method 1*/
class MyQueue {
    Stack<Integer> S = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        S.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        Stack<Integer> temp = new Stack<Integer>();
        while(S.size() != 1){
            temp.push(S.pop());
        }
        int result = S.pop();
        while(!temp.isEmpty()){
            S.push(temp.pop());
        }
        return result;
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> temp = new Stack<Integer>();
        while(S.size()!=1){
            temp.push(S.pop());
        }
        int result = S.pop();
        S.push(result);
        while(!temp.isEmpty()){
            S.push(temp.pop());
        }
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return S.isEmpty();
    }
}

/** Method 2*/
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    private void stack2ToStack1() {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }
    
    public void push(int number) {
        stack2.push(number);
    }

    public int pop() {
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int peek() {
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack2.isEmpty();
    }
}
