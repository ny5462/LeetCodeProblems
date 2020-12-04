/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Done using topological sort. First we create an indegree and outdegree adjList using hashmap. Then we apply topological sort, if no edge has an indegree 0 or not all edges are traversed once, till the queue empties, then you cannot complete all courses. We use a varaible count to check if all the courses are traversed at least once 
TC-O(M+N)
**/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> out=new HashMap<>();			//outdegree adjList
        HashMap<Integer,ArrayList<Integer>> in=new HashMap<>();			// in degree adjList
        for(int i=0;i<numCourses;i++){
            out.put(i,new ArrayList<>());
            in.put(i,new ArrayList<>());
        }
        Queue<Integer> q=new LinkedList<>();						// creating queue.
        		
        for(int i=0;i<prerequisites.length;i++){					// create graph by filling adj lists
            out.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i:in.keySet()){							// finding elements with indegree 0 as start points
            if(in.get(i).size()==0){
                q.add(i);
            }
        }
        if(q.size()==0)return false;
        int count=q.size();
        while(!q.isEmpty()){		//start topo sort by getting edges from queue, traversing their neighbours, 
            int head=q.poll();	// removing the current edge info from their indegree, and if their indegreeList is 0 , we add to q
            List<Integer> deg=out.get(head);
            for(int i=0;i<deg.size();i++){
                int u=deg.get(i);
                in.get(u).remove(new Integer(head));
                if(in.get(u).size()==0){
                    q.add(u);
                    count++;
                }
            }
        }
        
        return count==numCourses?true:false;	//if no of elements added to q equals total courses, we can take all courses, else false
        
        
    }
}
