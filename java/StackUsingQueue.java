/** program to implement stack using queue, done using single queue
push operation- O(N),else O(1)
**/
class MyStack {

    /** Initialize your data structure here. */
    private Queue<Integer> q=new LinkedList<>();
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(q.size()==0)q.add(x);
        else{
            q.add(x);
            while(q.peek()!=x){
                q.add(q.poll());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();  
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
