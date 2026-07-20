class Solution {
    public int maxValue(int n, int id, int sum) {

    int low= 1;
    int high= sum-(n-1);

    while(low<=high ){
        int mid= low+ (high-low)/2;

        long mysum= fun(mid, n, id);

        if(mysum<= (long) sum){
            low= mid+1;
        }

        else{
            high= mid-1;
        }



    }
    return high;

        
    }

    long fun(int max, int n, int id) {

    long sum = max;

    // Left side
    if (max > id) {
        // Doesn't reach 1
        sum += (long) id * ((max - 1L) + (max - id)) / 2;
    } else {
        // Reaches 1
        sum += (long) (max - 1) * max / 2;
        sum += id - (max - 1);
    }

    // Right side
    int right = n - id - 1;

    if (max > right) {
        // Doesn't reach 1
        sum += (long) right * ((max - 1L) + (max - right)) / 2;
    } else {
        // Reaches 1
        sum += (long) (max - 1) * max / 2;
        sum += right - (max - 1);
    }

    return sum;
}}