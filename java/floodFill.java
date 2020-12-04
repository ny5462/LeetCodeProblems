/**
 An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image. 
Done using dfs , maintaining a boolean array for seen elements, 
TC-O(m*n)
**/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int col=image[sr][sc];
        boolean[][]seen=new boolean[image.length][image[0].length];
        dfs(image,sr,sc,newColor,col,seen);
        return image;
    }
    
    public void dfs(int[][]image, int sr, int sc, int newColor, int oldColor,boolean[][] seen){
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||image[sr][sc]!=oldColor||seen[sr][sc]==true){
            return;
        }
        image[sr][sc]=newColor;
        seen[sr][sc]=true;
        dfs(image,sr+1,sc,newColor,oldColor,seen);
        dfs(image,sr-1,sc,newColor,oldColor,seen);
        dfs(image,sr,sc+1,newColor,oldColor,seen);
        dfs(image,sr,sc-1,newColor,oldColor,seen);
    }
}
