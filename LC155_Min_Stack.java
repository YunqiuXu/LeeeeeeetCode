/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack {
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();  
        min=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        //E.G. [-2,0,4,-3,2,-4,5]-->[MAX,-2,0,4,-2,-3,2,-3,-4,5]
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        //E.G. when pop(-4), min=-4 --> pop(-3) --> min=-3 --> [MAX,-2,0,4,-2,-3,2]
        if(stack.pop() == min) min=stack.pop();
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
