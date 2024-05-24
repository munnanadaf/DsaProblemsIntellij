package stacks;

import java.util.Stack;

class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> dummyStack;

    public MinStack() {
        mainStack = new Stack<>();
        dummyStack= new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(!dummyStack.isEmpty())
        {
            int min = Math.min(dummyStack.peek(),val);
            dummyStack.push(min);
        }
        else
            dummyStack.push(val);
    }
    
    public void pop() {
        mainStack.pop();
        dummyStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return dummyStack.peek();
    }
}