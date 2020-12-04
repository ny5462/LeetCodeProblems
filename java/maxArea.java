/** Find the max area between the 2 points, limit of height at the index,
distance between the indices.
TC- O(n^2)
**/
class Solution {
    public int maxArea(int[] height) {
        int max;
        if(height[0]>height[1])max=height[1];
        else max=height[0];
        int vol;
        for(int i=0;i<height.length;i++){
            for (int j=1;j<height.length;j++){
            if(height[j]<=height[i]){
                vol=(j-i)*height[j];
                if(vol>max){
                    max=vol;
                }
            }else{
                vol=(j-i)*height[i];
                if(vol>max){
                    max=vol;
                }
            }
        }
        }
        return max;
    }
}

/**
TC- O(n) single pass
**/
class Solution{
	public int maxArea(int [] height){
		int max =0;
		for(int i=0,j=height.length-1;i<j;){
			max=Math.max(max,(j-i)*Math.min(height[i],height[j]));
			if(height[i]>height[j])j--;
			else i++;

		}
		return max;
		}
	}
