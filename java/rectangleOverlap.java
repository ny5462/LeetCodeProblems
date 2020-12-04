/** program to check whether 2 rectangles overlap, i.e whether their is a positive area of intersection. Done by breaking the given input into vertices of rectangles, and created an intersection function to check whether a given vertical segment intersects with a given horizontal segment, and applied to all possible 8 cases, few of them being redundant as in case of intersections, there will be 2 possible intersections. There is also a function to check whether a given rectangle is completely inscribed in another rectangle.
TC-O(1) as there is no loop involved, we just handle all 9 cases.
**/
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int []topleftrec1=new int[2];
        int [] bottomleftrec1=new int[2];
        int []toprightrec1= new int[2];
        int []bottomrightrec1=new int[2];
        
        int []topleftrec2=new int[2];
        int [] bottomleftrec2=new int[2];
        int [] toprightrec2=new int[2];
        int []bottomrightrec2= new int[2];
        topleftrec1[0]=rec1[0];
        topleftrec1[1]=rec1[3];
        bottomrightrec1[0]=rec1[2];
        bottomrightrec1[1]=rec1[1];
        bottomleftrec1[0]=rec1[0];
        bottomleftrec1[1]=rec1[1];
        toprightrec1[0]=rec1[2];
        toprightrec1[1]=rec1[3];
        
        topleftrec2[0]=rec2[0];
        topleftrec2[1]=rec2[3];
        bottomleftrec2[0]=rec2[0];
        bottomleftrec2[1]=rec2[1];
        toprightrec2[0]=rec2[2];
        toprightrec2[1]=rec2[3];
        bottomrightrec2[0]=rec2[2];
        bottomrightrec2[1]=rec2[1];
        
        return intersect(topleftrec1,bottomleftrec1,topleftrec2,toprightrec2)||	     				intersect(topleftrec1,bottomleftrec1,bottomleftrec2,bottomrightrec2)||                                    intersect(toprightrec1,bottomrightrec1,topleftrec2,toprightrec2)||
		 intersect(toprightrec1,bottomrightrec1,bottomleftrec2,bottomrightrec2)||
		 intersect(topleftrec2,bottomleftrec2,topleftrec1,toprightrec1)||                                   intersect(topleftrec2,bottomleftrec2,bottomleftrec1,bottomrightrec1)||
		 intersect(toprightrec2,bottomrightrec2,topleftrec1,toprightrec1)||
		     intersect(toprightrec2,bottomrightrec2,bottomleftrec1,bottomrightrec1)||
		     inscribed(rec1,rec2);
              
    }
    
    public boolean intersect(int[]topleft1, int[]bottomleft1,int[]topleft2,int[]topright2){
        int x=topleft1[0];
        int y=topright2[1];
        if(y>bottomleft1[1]&&y<topleft1[1]){
            if(topleft2[0]<x&&topright2[0]>x){
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean inscribed(int[] rec1,int[]rec2){
        if(rec1[0]<rec2[0]&&rec1[1]<rec2[1]&&rec1[2]>rec2[2]&&rec1[3]>rec2[3]){
            return true;
        }
        if(rec2[0]<rec1[0]&&rec2[1]<rec1[1]&&rec2[2]>rec1[2]&&rec2[3]>rec1[3]){
            return true;
        }
        return false;
    }
}
