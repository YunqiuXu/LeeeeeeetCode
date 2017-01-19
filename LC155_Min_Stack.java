/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

/** Yunqiu Xu*/
public class MinStack {
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();  
        min = Integer.MAX_VALUE;
    }
    
    /** If x will be the new min
     * push old min, then change min to x
     * then push x
     * E.G. [-2,0,4,-3,2,-4,5] --> [MAX(old),-2,0,4,-2(old),-3,2,-3(old),-4(new),5]
     */
    public void push(int x) {
        if(x <= min){          
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    /** If we pop the min element
     * we need to pop twice 
     * then set the second pop as min
     * E.G. when pop(-4), min=-4 --> pop(-3) --> min=-3 --> [MAX,-2,0,4,-2,-3,2]
     */
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        } 
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
