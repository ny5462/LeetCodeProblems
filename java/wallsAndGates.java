/** given gates and empty spaces in a matrix as 0 and INF resp, and walls as -1, find if possible dist of each empty room from its nearest gate, if its reachable.
Done using BFS using a queue, by maintaining a dist counter
TC-O(row*col)
**/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        int dist=1;
        int max=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[]gate=q.poll();
                int row=gate[0];
                int col=gate[1];
                
                if(row>0&&rooms[row-1][col]==max){
                   rooms[row-1][col]=dist;
                   q.add(new int[]{row-1,col});
                }
                if(row<rooms.length-1&&rooms[row+1][col]==max){
                    rooms[row+1][col]=dist;
                    q.add(new int[]{row+1,col});
                }
                if(col>0&&rooms[row][col-1]==max){
                    rooms[row][col-1]=dist;
                    q.add(new int[]{row,col-1});
                }
                if(col<rooms[0].length-1&&rooms[row][col+1]==max){
                    rooms[row][col+1]=dist;
                    q.add(new int[]{row,col+1});
                }   
            }
            dist++;
        }
        
    }
}
