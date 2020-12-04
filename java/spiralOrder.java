/** program to traverse matrix in spiral order. Done by maintaining a boolean 2d array which keeps check of visited nodes and traversing using 2 pointers along the 4 edges of the matrix.
Credits- excellent solution by https://leetcode.com/problems/spiral-matrix/discuss/348120/Java-Traverse-solution-0ms-beat-100
TC-O(N)
**/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list=new ArrayList<>();
         if(matrix==null||matrix.length==0)return list;
        int row=matrix.length;
        int col=matrix[0].length;
        int x=0,y=0;
        boolean[][] visited=new boolean[row][col];
        while(list.size()<row*col){
            while(y<col&&!visited[x][y]){
                list.add(matrix[x][y]);
                visited[x][y]=true;
                y++;                    
            }
            x++;
            y--;
            while(x<row&&!visited[x][y]){
                list.add(matrix[x][y]);
                visited[x][y]=true;
                x++;
            }
            x--;
            y--;
            while(y>=0&&!visited[x][y]){
                list.add(matrix[x][y]);
                visited[x][y]=true;
                y--;
            }
            x--;
            y++;
            while(x>=0&&!visited[x][y]){
                list.add(matrix[x][y]);
                visited[x][y]=true;
                x--;
            }
            x++;
            y++;
        }
        return list;
}
}
