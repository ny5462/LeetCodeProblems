/**There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
Done using Topological sort via Kahn's algorithm. in a bfs approach. First made map of courses numbers and adjList, i.e a course and which other courses depend on it, and another count map for a course and how many courses are its prerequisite. Then applying kahn's algorithm by removing after every iteration from q those courses which have indegree 0, and iterating its dependent courses.
L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edge

while S is not empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S

if graph has edges then
    return error   (graph has at least one cycle)
else 
    return L   (a topologically sorted order)
    
Credits- https://en.wikipedia.org/wiki/Topological_sorting
TC-O(V+E)
**/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>> adjList=new HashMap<>();
        Map<Integer,Integer> counts=new HashMap<>();
        
        for(int i=0;i<numCourses;i++){
            adjList.put(i,new ArrayList<>());
            counts.put(i,0);
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            counts.put(prerequisites[i][0],counts.get(prerequisites[i][0])+1);
        }
        
        int[] ans=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for(int i:counts.keySet()){
            if(counts.get(i)==0){
                queue.add(i);
            } 
        }
        int i=0;
        while(!queue.isEmpty()){
            ans[i]=queue.poll();
            for(int val:adjList.get(ans[i])){
                counts.put(val,counts.get(val)-1);
                if(counts.get(val)==0){
                    queue.add(val);
                }
            }
            i++;
        }
        if(i<numCourses){
            return new int[]{};
        }
        return ans;
    }
}
