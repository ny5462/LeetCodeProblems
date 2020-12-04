/** program to find minimum no of meeting rooms required given starting and ending time of each meetings. Done using priority queue, by first sorting meetings by starting time, and the min heap acts like a set of ongoing meetings, and its size as meeting rooms, if current meeting starting time, exceeds top of heap ending value ,we add it to heap, otherwise we remove elements from heap, till its ending time exceeds start time of current meeting.
T_O(NlogN)
**/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int max=0;
        int current=0;
        for(int i=0;i<intervals.length;i++){
            if(pq.isEmpty()){
                pq.add(intervals[i][1]);
                current=pq.size();
                max=Math.max(current,max);
            }
            else if(pq.peek()<=intervals[i][0]){
                while(true){
                    if(!pq.isEmpty()){
                        if(pq.peek()<=intervals[i][0])
                            pq.poll();
                            break;
                    }if(pq.isEmpty())break;
                    
                    
                }
                pq.add(intervals[i][1]);
                current=pq.size();
                max=Math.max(current,max);
            }
            else if(pq.peek()>intervals[i][0]){
                pq.add(intervals[i][1]);
                current=pq.size();
                max=Math.max(current,max);
            }
        }
        return max;
    }
}
