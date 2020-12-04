/**
There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Done by maintaining a hashmap that stores cumulative sum of each bricks in each row, that will tell us at what distances the gaps exist,
and for every row. While doing that, if a gap reoccurs, we calculate its frequency. The gap distance with highest count will give us the easiest path through the brick wall.
TC-O(N)
**/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(List<Integer> l :wall){
            int sum=0;
            for(int i=0;i<l.size()-1;i++){
                sum+=l.get(i);
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                }else{
                    map.put(sum,1);
                }
                max=Math.max(max,map.get(sum));
            }
        }
        return wall.size()-max;
    }
}
