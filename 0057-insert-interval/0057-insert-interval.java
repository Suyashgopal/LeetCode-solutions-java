class Solution {
    public int[][] insert(int[][] intervals, int[] ni) {
        int n= intervals.length;
        int st= ni[0];
        int end= ni[1];
        List<int[]> li = new ArrayList<>();
        int i=0;
        while(i<n && intervals[i][1]<st ){
            li.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0]<= end){
            st= Math.min(intervals[i][0] ,st);
            end=Math.max(intervals[i][1],end);
            i++;
        }
        ni[0]= st;
        ni[1]= end;
        li.add(ni);
        while(i<n){
            li.add(intervals[i]);
            i++;
        }
     int[][] mat = li.toArray(new int[li.size()][]);
     return mat;
    }
}