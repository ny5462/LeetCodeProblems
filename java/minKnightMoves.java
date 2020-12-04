/**In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

Done by using BFS and limiting the problem to one quadrant as knight starts from origin to avoid TLE. We convert co-ordinates to positive,
which reduces our search space to one quadrant. However, we allow the knight to move one row or one col or both away from current quadrant to allow certain positions to be reached in faster manner.
TC-O(X*Y)
**/
class Solution {
    public int minKnightMoves(int x, int y) {
    	// if origin is to be reached
        if(x==0&&y==0)return 0;
        // valid knight directions
        int[][] dir={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        // limiting search to one quadrant
        x=Math.abs(x);
        y=Math.abs(y);
        //storing visited grids as string
        HashSet<String> set= new HashSet<>();
        // adding bfs grids for a round 
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        set.add("0,0");
        // counts no of moves needed
        int moves=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                //fetches the grid and loops over possible co-ordinates from this starting position
                int[]val=q.poll();
                
                for(int [] pos:dir){
                    int row=val[0]+pos[0];
                    int col=val[1]+pos[1];
                    // if grid is found we return no of moves to reach it
                    if(row==x &&col==y)return moves;
                    // if already traversed grid, we don't process it else we add it to queue
                    else if(!set.contains(row+","+col) && row>=-1 &&col>=-1){
                        set.add(row+","+col);
                        q.add(new int[]{row,col});          
                   }else{
                        continue;
                    }
                }
            }
            // increments no of moves after each round
            moves++;
            
        }
        return moves;
    }
}
