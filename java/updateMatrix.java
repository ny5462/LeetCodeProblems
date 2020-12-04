/** Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Done using BFS where we add in the queue all the grid positions who have a zero, the we perform bfs on all 4 valid directions by polling elements from queue, and if we haven't seen the grid before, we add its parent's value with 1, and enqueue it.
credits -https://leetcode.com/problems/01-matrix/solution/
TC-O(m*n)
**/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q=new LinkedList<>();
        boolean[][]seen=new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                    seen[i][j]=true;
                }
            }
        }
        int[][]dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] val=q.poll();
            for(int i[]:dir){
                int row=val[0]+i[0];
                int col=val[1]+i[1];
                if(row<0||row>=matrix.length||col<0||col>=matrix[0].length||seen[row][col]){
                    continue;
                }
                seen[row][col]=true;
                matrix[row][col]=matrix[val[0]][val[1]]+1;
                q.add(new int[]{row,col});
            }
        }
        return matrix;
    }
}
