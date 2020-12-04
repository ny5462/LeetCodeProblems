/**The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"
Done by 2 approaches. First naive approach by me , calculates no of cols that wil be needed for the task by iterating through the string and given no of rows, then it iterates the string again storing in a char array all the appropriate characters acc to their index and zig zag rules. Then it iterates the char array to fill the stringbuilder.
TC-O(N) multiple passes, 3 passes.
SC-O(numRows*cols)
**/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        int midIter=numRows-2;int n=s.length(); int cols=0,i=0;
        while(i<n){
            i+=numRows;
            cols++;
            int x=0;
            while(i<n&&x<midIter){
                i+=1;
                cols++;
                x++;
            }
        }
        char [][] c=new char[numRows][cols];
        int col=0, index=0;int x=0;i=0;
        while(col<cols && index<n){
            if(x==0){
                while(i<numRows && index<n){
                    c[i++][col]=s.charAt(index++);
                }
                x++;
                col++;
                i=numRows-x-1;
                if(x>midIter){
                    x=0;
                    i=0;
                }
            }else if(x<=midIter){
                c[i][col]=s.charAt(index++);
                x++;
                col++;
                i=numRows-x-1;
                if(x>midIter){
                    x=0;
                    i=0;
                }
            }
        }
        StringBuilder sb =new StringBuilder();
        for(i=0;i<numRows;i++){
            for(int j=0;j<cols;j++){
            
                if(c[i][j]!='\u0000'){
                    sb.append(c[i][j]);
                }
            }         
        }
        return sb.toString();       
    }    
}


///much better and faster approach credits- https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution
//TC-O(N), SC-O(N) . made an array of string buffers and kept on adding in while loop to specific index specific characters.
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        int len=s.length();
        char []c =s.toCharArray();
        StringBuffer [] sb= new StringBuffer[numRows];
        for(int i=0;i<numRows;i++)sb[i]=new StringBuffer();
        
        int i=0;
        while (i<len){
            for(int idx=0;i<len && idx<numRows;idx++){
                sb[idx].append(c[i++]);
            }
            for(int idx=numRows-2; i<len&&idx>=1;idx--){
                sb[idx].append(c[i++]);
            }
        }
        for(int idx=1;idx<numRows;idx++){
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
}
}

