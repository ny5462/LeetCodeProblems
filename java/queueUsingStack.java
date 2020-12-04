/** program to create queue using only stacks
TC -O(N)
**/
class MyQueue {

    /** Initialize your data structure here. */
     Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    public MyQueue() {
       
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.empty()&& s2.empty()==false){
            while(!s2.empty()){
                s1.push(s2.pop());
            }s1.push(x);
            while(!s1.empty()){
                s2.push(s1.pop());
            }   
        }
        else if(s1.empty()&&s2.empty()){
            s2.push(x);
        }else{
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.empty()){
            return -1;
        }
        else{
            return s2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (s2.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
