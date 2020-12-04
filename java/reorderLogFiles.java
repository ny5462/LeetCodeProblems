/** program to reorder log files, where first word is the identifier, and there are two types of logs, digit logs, which are to be present in the order they are inputted, and there are letter logs , which are to be sorted lexicographically, and in case of ties, the identifier is used.
Done using custom merge sort, where the comparator is tuned.
O(A log A)
**/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        return mergeSort(logs);
        
    }
    
    public String[] mergeSort(String[] logs){
           
        if(logs.length>1){
            int mid=(logs.length)/2;
            String [] l=new String[mid];
            String [] r=new String[logs.length-mid];
            for(int i=0;i<mid;i++){
                l[i]=logs[i];
            }
            for(int i=0,j=mid;j<logs.length;i++,j++){
                r[i]=logs[j];
            }
            mergeSort(l);
            mergeSort(r);
            int i=0;
            int j=0;
            int k=0;

            while(i<l.length&&j<r.length){
                if(compare(l[i],r[j])==l[i]){
                    logs[k++]=l[i++];
                }else if(compare(l[i],r[j])==r[j]){
                    logs[k++]=r[j++];
                }
            }
            
            while(i<l.length){
                logs[k++]=l[i++];
            }
            while(j<r.length){
                logs[k++]=r[j++];
            }
            
        }
        return logs;
    }
    
    public String compare(String a,String b){
        String[] ac=a.split(" ",2);
        String[] bc=b.split(" ",2);
        boolean isDigitA=Character.isDigit(ac[1].charAt(0));
        boolean isDigitB=Character.isDigit(bc[1].charAt(0));
        if(!isDigitA&&!isDigitB){
            System.out.println(ac[1]);
            if(ac[1].compareTo(bc[1])>0)return b;
            else if(ac[1].compareTo(bc[1])<0)return a;
            else if(ac[1].compareTo(bc[1])==0){
                if(ac[0].compareTo(bc[0])>0)return b;
                else return a;
            }
        }
        
        else if(!isDigitA &&isDigitB)return a;
        else if(isDigitA && !isDigitB)return b;
        return a;
        
        
        
    }
}
