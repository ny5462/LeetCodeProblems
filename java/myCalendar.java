/** from to create a class of calendar which craetes bookings, only if it doesn't clash with other schedule. Done by creating a class Interval, and storing a list of intervals, and then checking for conflicts.
O(N^2)
**/
class MyCalendar {
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    static List<Interval> intervals;
    public MyCalendar() {
        intervals=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(intervals.size()==0){
            intervals.add(new Interval(start,end));
        }else{
            for(Interval i:intervals){
                if((i.start>=start &&i.end<=end)||(i.start>start && i.start < end)||
                   (i.start<=start && i.end>start)||(i.start>=start && i.end<=end)){
                       return false;
                   }
        }
            intervals.add(new Interval(start,end));
        }
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
 
 /** faster approach with tree map where you store compare the next bigger start value from current interval and next smaller start value from interval, and if these two intervals don't clash with input interval, we put them in the treemap. Treemap key is start date, and value is end date.
 TC-O(nlogn)
 creedits- https://leetcode.com/problems/my-calendar-i/solution/
 **/
 class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
