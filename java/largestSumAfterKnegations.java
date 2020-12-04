/** program to return max sum of an array, after performing K negations on an array.
Done by doing the negation of the smallest integer in the array, after every negation.
Which involves sorting at every iteration of K, hence a priority queue is used.
TC-(NlogN)
**/
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:A){
            pq.add(i);
            sum+=i;
        }
        while(K>0){
            int rem=pq.poll();
            pq.add(-rem);
            sum+=(-2*rem);
            K--;
        }
      
        return sum;
    }
}
