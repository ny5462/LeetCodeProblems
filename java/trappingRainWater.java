/**
given heights of buildings we have to find how much water can be trapped between them.
done using 2 pointers, we first move from l2r to find highest building encountered so far, and store in an array l2r.
then we move from r2l , calculate highest buulding so far, and we then store minimum of l2r and r2l for that height as it is bounded by both directions to find the minimum boundary on either side. then we calculate the max height water can take for the index - height of building on that index and sum it up for all indices.
TC-O(N)
SC-O(N)
**/
class Solution {
    public int trap(int[] height) {
        int[] l2r =new int[height.length];
        int prevMax=0;
        // left to right pass
        for(int i=0;i<height.length;i++){
            if(height[i]>prevMax){
                prevMax=height[i];
            }
            l2r[i]=prevMax;
        }
        prevMax=0; // checks highest building seen so far in that pass
        int water=0; // total water that can be trapped
        // right to left pass and see the minimum of 2 passes and calculate water that can be stored in that index
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>prevMax){
                prevMax=height[i];
            }
            l2r[i]=Math.min(l2r[i],prevMax);		// stores minimum of highest building in both the passes
            water+=l2r[i]-height[i];			// trapped water in that index
        }
        return water;
}
}
