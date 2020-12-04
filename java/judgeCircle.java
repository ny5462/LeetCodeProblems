/** program to check in a 2D , whether a robot has returned to Origin(0,0), Given a 
String of Moves. i.e Up, Down, Left ,Right.
TC-O(N)
**/
class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        for(char c:moves.toCharArray()){
            if(c=='U')y+=1;
            else if(c=='D')y-=1;
            else if(c=='L')x-=1;
            else x+=1;
        }
        return x==0&&y==0;
    }
}

