/**
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

    Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
    C_1 is at location (0, 0) (ie. has value grid[0][0])
    C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
    If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).

Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

Done by using bfs and maintaining a seen matrix and checking 8 directionally for every grid slot
TC-O(V+E)
edges here are 8 for every edge
TC-O(m*m)
**/
class Solution {
    class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i=i;
            this.j=j;
        }
        
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean [][]seen=new boolean[grid.length][grid[0].length];
        if(grid[0][0]==1 ||grid[grid.length-1][grid[0].length-1]==1)return -1;
        if(grid[0][0]==0 && grid.length==1)return 1;
        Point start=new Point(0,0);
        Queue<Point> q=new LinkedList<>();
        seen[0][0]=true;
        int dist=1;
        q.add(new Point(0,0));
        while(!q.isEmpty() && seen[grid.length-1][grid[0].length-1]==false){
              int size=q.size();
            for(int x=0;x<size;x++){
                Point p=q.poll();
                  if(p.i+1<grid.length&&grid[p.i+1][p.j]==0&&seen[p.i+1][p.j]==false){
                      q.add(new Point(p.i+1,p.j));
                      seen[p.i+1][p.j]=true;
                      if(p.i+1==grid.length-1 &&p.j==grid[0].length-1)return dist+1;
                      
                  }
                  if(p.i-1>=0&&grid[p.i-1][p.j]==0&&seen[p.i-1][p.j]==false){
                      q.add(new Point(p.i-1,p.j));
                      seen[p.i-1][p.j]=true;
                      
                  }
                if(p.j-1>=0&&grid[p.i][p.j-1]==0&&seen[p.i][p.j-1]==false){
                      q.add(new Point(p.i,p.j-1));
                      seen[p.i][p.j-1]=true;
                  }
                if(p.j+1<grid[0].length&&grid[p.i][p.j+1]==0&&seen[p.i][p.j+1]==false){
                      q.add(new Point(p.i,p.j+1));
                      seen[p.i][p.j+1]=true;
                      if(p.i==grid.length-1 &&p.j+1==grid[0].length-1)return dist+1;
                  }
                if(p.i-1>=0&&p.j-1>=0&&grid[p.i-1][p.j-1]==0&&seen[p.i-1][p.j-1]==false){
                    q.add(new Point(p.i-1,p.j-1));
                    seen[p.i-1][p.j-1]=true;
                }
                if(p.i+1<grid.length&&p.j-1>=0&&grid[p.i+1][p.j-1]==0&&seen[p.i+1][p.j-1]==false){
                    q.add(new Point(p.i+1,p.j-1));
                    seen[p.i+1][p.j-1]=true;
                }
                if(p.i-1>=0&&p.j+1<grid[0].length&&grid[p.i-1][p.j+1]==0&&seen[p.i-1][p.j+1]==false){
                    q.add(new Point(p.i-1,p.j+1));
                    seen[p.i-1][p.j+1]=true;
                }
                if(p.i+1<grid.length&&p.j+1<grid[0].length&&grid[p.i+1][p.j+1]==0&&seen[p.i+1][p.j+1]==false){
                    q.add(new Point(p.i+1,p.j+1));
                    seen[p.i+1][p.j+1]=true;
                    if(p.i+1==grid.length-1 &&p.j+1==grid[0].length-1)return dist+1;
                }
        }dist++;
        }
        return -1;
    }
}
