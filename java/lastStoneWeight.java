/** program to find the last remaining stone in an array of stones, where the two biggest stones collide, and the difference in their masses remain at every iteration.
TC-O(NlogN)
**/
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==0)return 0;
        Arrays.sort(stones);
        List<Integer> list=new ArrayList<>();
        for(int num:stones)list.add(num);
        while(list.size()>=1){
            if(list.size()==1)return list.get(0);
            int s1=list.remove(list.size()-1);
            int s2=list.remove(list.size()-1);
            if(s1==s2)continue;
            else{
                list.add(Math.abs(s1-s2));
                Collections.sort(list);
            }
            
        }
        return 0;
    }
}

/** using priority queue**/
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==0)return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones){
            pq.add(num);
        }
        while(pq.size()>1){
            int s1=pq.poll();
            int s2=pq.poll();
            if(s1!=s2){
                pq.add(s1-s2);
            }
        }
        if(!pq.isEmpty())return pq.poll();
        return 0;
    }}
