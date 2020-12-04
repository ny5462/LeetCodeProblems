/** program to return a list of pascal triangle upto given rows. Done by maintaining a counter, upto row count, creating a temporary list at every iteration. for first and second row, 1 and 1,1 is added respectively. From 3 onwards, the last entry to list of list is retrieved, iterated and the entry for current row is created and added on the list of list.
TC-O(1x1+1x2+1x3+...1xN),i.e N(N+1)/2 in short - O(N^2)
**/
class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans=new ArrayList<>();
      return eval(ans,numRows);
    }
    public List<List<Integer>> eval(List<List<Integer>> ans,int row){
        if(row==0)return ans;
        List<Integer> temp=new ArrayList<>();
        int count=1;
        if(ans.size()==0){
            temp.add(1);
            ans.add(temp);
        }
        if(row==1)return ans;
        else{
            while(count!=row){
                List<Integer> temp1=new ArrayList<>();
                count++;
                if(count==2){
                    temp1.add(1);
                    temp1.add(1);
                    ans.add(temp1);
            
                }else{
                    List<Integer> retrieve=ans.get(ans.size()-1);
                 //   System.out.println(retrieve);
                    temp1.add(1);
                    for(int i=0;i<(count-2);i++){
                      //  System.out.println(retrieve.get(0));
                       temp1.add(retrieve.get(i)+retrieve.get(i+1));
                    }
                    temp1.add(1);
                    ans.add(temp1);
                }
            }
        }
    return ans;
    }
}
