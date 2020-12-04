/**You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
    void add(int value) insert value to the queue.

Done by maintaining a hashmap and an array List as queue, since there is no removal, it works fine.
add- O(1)
showFirstUnique(O(N))
**/
class FirstUnique {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> q;
    int start;
    public FirstUnique(int[] nums) {
        this.map=new HashMap<>();
        this.q=new ArrayList<>();
        for(int i:nums){
            add(i);
        }
        this.start=0;
    }
    
    public int showFirstUnique() {
        int i=start;
        boolean found =false;
        while(i<q.size()){
            if(map.get(q.get(i))==1){
               found=true;
               break;
            }
            i++;
        }
        start=i;
        return found==false?-1:q.get(i);
    }
    
    public void add(int value) {
        map.put(value,map.getOrDefault(value,0)+1);
        q.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
