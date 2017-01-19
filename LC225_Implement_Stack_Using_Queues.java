/** Yunqiu Xu*/
/** just use one queue*/
class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public int pop() {
        int s = q.size();
        for(int i = 0; i < s - 1; i++){
            q.add(q.remove());
        }
        return q.remove();
    }

    // Get the top element.
    public int top() {
        int s = q.size();
        for(int i = 0; i < s - 1; i++){
            q.add(q.remove());
        }
        int result = q.remove();
        q.add(result);
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0;
    }
}
