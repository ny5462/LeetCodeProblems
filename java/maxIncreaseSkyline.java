/** program to fit the skyline according to their nearest tallest row or column max value.
In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased?
Done using HashMap(slow approach) and Arrays.
TC-O(N^2)
**/
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int [] rowMax=new int[grid.length];
        int [] colMax=new int[grid[0].length];
         for(int i=0;i<grid.length;i++){ 
             for(int j=0;j<grid[0].length;j++){
                 rowMax[i]=Math.max(grid[i][j],rowMax[i]);
                 colMax[j]=Math.max(grid[i][j],colMax[j]);
         }
         }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans+=Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        return ans;
    }
}

/** hashmap approach**/
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        HashMap<String,Integer> map=new HashMap<>();
         for(int i=0;i<grid.length;i++){ 
             for(int j=0;j<grid[0].length;j++){
                 String rowKey="row"+i;
                 String colKey="col"+j;
                 if(map.containsKey(rowKey)){
                     map.put(rowKey,Math.max(grid[i][j],map.get(rowKey)));
                 }else map.put(rowKey,grid[i][j]);
                  if(map.containsKey(colKey)){
                     map.put(colKey,Math.max(grid[i][j],map.get(colKey)));
                 }else map.put(colKey,grid[i][j]);
             }
         }
        
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans+=Math.min(map.get("row"+i),map.get("col"+j))-grid[i][j];
            }
        }
        return ans;
    }
}
