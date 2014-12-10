import java.util.*;

/*
 * Min Stack Total Accepted: 7681 Total Submissions: 51502 My Submissions Question Solution 
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
	/*class MinObj {
		int value;
		int count;
		MinObj(int v) {
			value = v;
			count = 1;
		}
	}
	Stack<Integer> s = new Stack<Integer>();
	Stack<MinObj> mins = new Stack<MinObj>();
	
	public void push(int x) {
	    s.push(x);
	    if (mins.size() > 0 && mins.peek().value>x || mins.size()==0)
	    	mins.push(new MinObj(x));
	    else if (mins.size() > 0 && mins.peek().value == x)
	    	mins.peek().count++;
	    
	}

	public void pop() {
	    int o = s.pop();
	    if (mins.peek().value == o) {
	    	mins.peek().count--;
	    }
    	if (mins.peek().count == 0)
    		mins.pop();

	}

	public int top() {
	    return s.peek();
	}

	public int getMin() {
        return mins.peek().value;
	}
	  */
	private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		ms.push(0);
		ms.push(1);
		ms.push(0);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());

	}

}
