/**
find least number of unique integer in an array after removing k elements.
Done by removing the least frequent elements first, done by maintaining a hashmap of frequencies, and a min heap sorted by frequencies
TC-O(nlogn)
**/
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();      
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }      
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int i:map.keySet()){
            pq.add(i);
        }
        
        while(k>0 && !pq.isEmpty()){
            k-=map.get(pq.poll());
        }
        return k<0 ? pq.size()+1:pq.size();
    }
}
