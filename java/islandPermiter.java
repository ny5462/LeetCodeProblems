/**program to find perimeter of island in arrays.
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.


TC-O(N), N is no of elements
**/
class Solution {
    public int islandPerimeter(int[][] grid) {
       int row= grid.length;
        int col= grid[0].length;
        int perimeter=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                   int current = 0;
                    
                    // top
                    if (i == 0) current++;    
                    if (i != 0 && grid[i - 1][j] == 0) current++;
                    
                    // left
                    if (j == 0) current++;
                    if (j != 0 && grid[i][j - 1] == 0) current++;
                    
                    // bottom
                    if (i == grid.length - 1) current++;
                    if (i != grid.length - 1 && grid[i + 1][j] == 0) current++;
                    
                    // right
                    if (j == grid[i].length - 1) current++;
                    if (j != grid[i].length - 1 && grid[i][j + 1] == 0) current++;
                    
                    perimeter += current;
                }
            }
        }
        return perimeter;
    }
}
