/** determine smallest angle between hour and minutes needle with given time
TC-O(1)
**/
class Solution {
    public double angleClock(int hour, int minutes) {
       double hour_angle =(360/12)*(hour%12);
       double min=(360/60)*minutes;
       double hour_dev=(min*30)/360;
       double angle=hour_angle+hour_dev<min?min-(hour_angle+hour_dev):hour_angle+hour_dev-min;
       return Math.min(angle,360-angle);
    }
}
