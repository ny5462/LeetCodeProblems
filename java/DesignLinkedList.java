/** program to design linked list. create head and tail pointers and node class and size variable
**/
class MyLinkedList {
    class Node{
        int val;
        Node next=null;
        public Node(int val){
            this.val=val;
        }
    }
    /** Initialize your data structure here. */
    Node head=null;
    Node tail=null;
    int size=0;
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>size-1)return -1;
        Node temp=head;
        int i=0;
        while(i!=index){
            temp=temp.next;
            i++;
        }
        return temp.val;
    }
    
    
     public Node getNode(int index) {
        if(index>size-1)throw null;
        Node temp=head;
        int i=0;
        while(i!=index){
            temp=temp.next;
            i++;
        }
        return temp;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newhead=new Node(val);
        if(size==0){
            head=newhead;
            tail=newhead;
        }
        else{
        newhead.next=head;
        head=newhead;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newTail=new Node(val);
        if(size==0){
            tail=newTail;
            head=newTail;
        }
        else{
        tail.next=newTail;
        tail=newTail;
        }
        size++;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size)return;
        Node newNode=new Node(val);
        if(index==0){
            addAtHead(val);
        }
        else if(index==size){
            addAtTail(val);
        }
        else{
            Node prev=getNode(index-1);
            Node curr=getNode(index);
            newNode.next=prev.next;
            prev.next=newNode;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=size)return;
        if(index==0){
            head=head.next;
            size--;
        }
       else if(index==size-1){
            Node t=getNode(size-2);
            t.next=null;
            tail=t;
           size--;
        }
        else{
            Node prev=getNode(index-1);
            Node curr=getNode(index);
            prev.next=curr.next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
