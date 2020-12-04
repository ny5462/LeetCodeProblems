/** program to return the kth largest element in an array. Done using priority queue and min heap
TC-O(logk)
credits- https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/343774/Java-Solution-%2B-Example-using-Heap
**/
class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    int largest;
    public KthLargest(int k, int[] nums) {
        this.largest=k;
        for(int i:nums){
            add(i);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()==largest+1){
            pq.remove();
        }
        return pq.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/**
Simpler solution using heap since this is a min heap, everytime you exceed the kth element you can remove the smallest element, so that way, after the entire array is traversed, the element at the top is the kth largest with the largest element somewhere in the bottom, as min heap property is followed**/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:nums){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

