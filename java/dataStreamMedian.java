/**
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

TC-O(logN)
**/
class MedianFinder {

    /** initialize your data structure here. */
     boolean even=true;
     PriorityQueue<Integer> min = new PriorityQueue<>();
     PriorityQueue<Integer> max= new PriorityQueue<>((a,b) -> b-a);
        
    public MedianFinder() {
         this.min = new PriorityQueue<>();
         this.max= new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
    	// if first no comes or even no of elements the smaller section has that extra element.
        if(even){
            min.offer(num);
            max.offer(min.poll());
        }
        // if odd number is present and new no makes it even, it first goes to smaller size gets the biggest no there and transfers it to
        // the bigger section 
        else{
            max.offer(num);
            min.offer(max.poll());
        }even=!even;
    }
    
    public double findMedian() {
        if(even)return (max.peek()+min.peek())/2.0;
        else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
