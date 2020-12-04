/** We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)

Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.

Done using 2 hashmaps and a list of lists.
Credits -https://leetcode.com/problems/analyze-user-website-visit-pattern/discuss/355626/Java-Solution-with-2-HashMap
TC- O(n^3)
**/

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        int n=timestamp.length;
        // storing in lists of list in input pattern each entry ,i.e user, time, website
        List<List<String>> sessions = new ArrayList<>();
        for(int i=0;i<n;i++){
            sessions.add(new ArrayList<>());
            sessions.get(i).add(username[i]);
            sessions.get(i).add(""+timestamp[i]);
            sessions.get(i).add(website[i]);
        }
        //sorting the list of lists according to timestamp
        sessions.sort((a,b)->Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1)));
        
        //map to store per user the website entries they visited
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        
        //filling the user website map
        for(int i=0;i<sessions.size();i++){
            map.putIfAbsent(sessions.get(i).get(0),new ArrayList<>());
            map.get(sessions.get(i).get(0)).add(sessions.get(i).get(2));
         }
                    
        // count map to see which seq has most counts
        HashMap<String,Integer> sequence=new HashMap<>();
        int maxCount=0;			//count of maximum occuring sequence
        String maxSeq="";			// max occuring sequence
        
        // iterating user sequence list
        for(String user:map.keySet()){
            List<String> list=map.get(user);
            if(list.size() < 3)continue;
            // creating all possible 3 sequences of a user and storing it in a set
            Set<String> seq3=sequences(list);
            // iterating the set and storing in sequence count map
            for(String seq:seq3){
                sequence.put(seq,sequence.getOrDefault(seq,0)+1);
                if(sequence.get(seq)>maxCount){
                    maxCount=sequence.get(seq);
                    maxSeq=seq;
                }
                // if maxcount matches current sequence count , it is compared lexicographically
                else if(sequence.get(seq)==maxCount && seq.compareTo(maxSeq)<0){
                    maxSeq=seq;
                }
            }
                     
        }
        // storing max sequence in list
        String [] str=maxSeq.split(",");
        return Arrays.asList(str);
        
    }
        
        public Set<String> sequences(List<String> seq){
            Set<String> set=new HashSet<>();
            int n=seq.size();
            for(int i=0;i<n-2;i++){
                for(int j=i+1;j<n-1;j++){
                    for(int k=j+1;k<n;k++){
                        set.add(seq.get(i)+","+seq.get(j)+","+seq.get(k));
                        
                    }
                }
            }
            return set;
        }
}
