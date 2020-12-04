/** sort top k integers according to their frequency/ Done using map and queue.
TC-O(NlogK)
**/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int i:map.keySet()){
            pq.add(i);
            if(pq.size()>k)pq.poll();
        }
        while(!pq.isEmpty())list.add(pq.poll());
        Collections.reverse(list);
        return list;
        
    }
}

/** adding to an array instead without reverse condition**/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int i:map.keySet()){
            pq.add(i);
            if(pq.size()>k)pq.poll();
        }
        int [] ans=new int[k];
        int count=0;
        while(!pq.isEmpty()){
            ans[count++]=pq.poll();
        }
        return ans;
    }
}
