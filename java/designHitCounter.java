/**
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 
done by maintaining 2 arrays of size 300, one maintains the timestamp, the other maintains the no of hits for that timestamp.
we mod timestamp by 300, as we have to keep track of only previous 300 seconds of time and hits receivd duringt hat time.
so on receiving a timestamp, we mod by 300 to find index of timestamp, if a different stamp is there in that index, we replace it, and update hits for that timestamp as 1.
If we hit the same timestamp more than once during the past 300 secs, we keep on updating the hits for that index.
to calculate no of hits for past 300 secs, we check if timestamp for that corresponding index lies within previous 300 secs, if yes, we add its hits to the total.
TC-O(1) for timestamp update
TC-O(1) for hit count
**/
class HitCounter {

    /** Initialize your data structure here. */
    int [] time = new int[300];
    int [] hits=new int[300];
    public HitCounter() {
    
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index=timestamp%300;
        if(time[index]!=timestamp){
            time[index]=timestamp;
            hits[index]=1;
       
        }else{
            hits[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {

        int count=0;
        for(int i=0;i<300;i++){
            if(timestamp-time[i]<300){
                count+=hits[i];
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
