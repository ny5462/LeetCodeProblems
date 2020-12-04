/** longest palindromic substring, done using DP where we first check length1 palindromes, then length 2, then higher lengths, where we derive information whether 2 length smaller palindrome was possible before, if we can build on to it by character matching.
credits- https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
**/

class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int max=0;
        int n=s.length();
        boolean[][] b=new boolean[n][n];
        
        //filling diagonal,i.e length 1 palindromes
        for(int i=0;i<n;i++){
            b[i][i]=true;
            start=i;
            max=1;
        }
        
        //checking for length 2 palindromes ,i.e repeated
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                b[i][i+1]=true;
                start=i;
                max=2;               
            }
        }
        
        //for length>2 
        for(int k=3;k<=n;k++){
            // finding appropriate starting and ending index for given k
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1; //ending index
                
                //if 1 lesser length palindrome was found and current and starting index match
                // we can add 2 more lengths to palindrome
             //  System.out.println(s.substring(i,i+k));
                if(b[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
                    //make true whenever palindrome is found
                    b[i][j]=true;
                    //if palindrome found is longest, substitute values
                    if(k>max){
                    start=i;
                    max=k;
                    }
                }
                
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(b[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(start+":"+max);
        return s.substring(start,start+max);
        
    }
}


