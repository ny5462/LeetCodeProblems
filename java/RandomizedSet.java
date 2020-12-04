/** program to design randomized set,, O(1) insert, O(1) remove, O(1) random get.
Done using hashmap and arraylist, arraylist elements swapped with last element during remove, hashmap stores, val and its index as key and val resp.
credtts- https://leetcode.com/problems/insert-delete-getrandom-o1/solution/
**/
class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random=new Random();
    public RandomizedSet() {
       map=new HashMap<>();
       list=new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        int index=map.get(val);
        list.set(index,list.get(list.size()-1));
        map.put(list.get(list.size()-1),index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
       return list.get(random.nextInt(list.size()));
}
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
