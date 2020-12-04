/** program to find k closest points to origin. Done using euclidean distance calculation and sorting.
TC-O(nlogn)
**/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans=new int[K][2];
        int[] dist=new int[points.length];
        for(int i=0;i<points.length;i++){
            dist[i]=euclidean(points[i]);
        }
        Arrays.sort(dist);
        int index=0;
        int kdists=dist[K-1];
        for(int i=0;i<dist.length;i++){
            if(euclidean(points[i])<=kdists){
                ans[index++]=points[i];
            }
        }
        return ans;
        
    }
    public int euclidean(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}
