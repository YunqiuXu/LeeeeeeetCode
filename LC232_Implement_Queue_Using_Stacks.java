class MyQueue {
    Stack<Integer> S = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        S.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> temp = new Stack<Integer>();
        while(S.size()!=1){
            temp.push(S.pop());
        }
        S.pop();
        while(!temp.isEmpty()){
            S.push(temp.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> temp = new Stack<Integer>();
        while(S.size()!=1){
            temp.push(S.pop());
        }
        int result=S.pop();
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
