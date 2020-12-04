/** program to implement LRU Cache , a data structure in which the least recently used element is removed, it has a given positive capacity. Functions include put, and get. The element which was least recently used will be removed, when capacity exceeds. Done by using a hashmap and array deque.
TC- get O(N)
TC- put O(N)
**/
class LRUCache {
    int capacity;
    HashMap<Integer,Integer> map;
    ArrayDeque<Integer> deq;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        deq=new ArrayDeque<>();
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            deq.remove(key);
            deq.addLast(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deq.remove(key);
            deq.addLast(key);
        }
        else{
            deq.addLast(key);
        }
        if(deq.size()>capacity){
            int ele=deq.pollFirst();
            map.remove(ele);
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
 
 /** Alternative faster solution using LinkedHashMap, which has inbuilt ordering capability according to access order and insertion order, and also be given a capacity. Inherit the linkedHashMap class of java , also setting access order sorting in its constructor and overriding its removeEldestEntry function to removeEldest when size exceeds capacity.
 TC- get O(1)
 TC- put O(1)
 credits -https://leetcode.com/problems/lru-cache/solution/
 **/
 class LRUCache extends LinkedHashMap<Integer,Integer> {
    
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity,0.75F,true) ; //capacity,load factor,access order sorting
        this.capacity=capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key,value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
