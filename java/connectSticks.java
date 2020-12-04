/** You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.
Done using min heap which returns the smallest combinations at every go.
TC-O(NlogN)
**/

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int ans=0;
        for(int i:sticks){
            pq.add(i);
        }
        while(pq.size()>1){
            int cost=pq.poll()+pq.poll();
            ans+=cost;
            pq.add(cost);
        }
        return ans;
    }
}

