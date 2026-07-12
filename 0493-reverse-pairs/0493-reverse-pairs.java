class Solution {
    public int reversePairs(int[] arr) {
        int n= arr.length;

   return   divide(0, n-1, arr);   
    } 
    
    int divide(int l, int r, int[] arr){
        if(l>=r){return 0;}
            int mid= l+(r-l)/2;
          int  left= divide(l,mid, arr);
          int right= divide(mid+1, r,arr);
           int m=  merge(l,mid, r, arr);
        
                 return left+right+m;


    }

 int merge(int l, int mid, int r, int[] arr){
    int count=0;
   int j = mid + 1;

for (int i = l; i <= mid; i++) {
    while (j <= r && (long) arr[i] > 2L * arr[j]) {
        j++;
    }
    count += j - (mid + 1);
}




    int n1= l;
    int n2= mid+1;
    int[] copy= new int[r-l+1];
    int x1=0;
    while(n1<= mid && n2<= r){
        if(arr[n1]<=arr[n2]){
            copy[x1]= arr[n1];
            n1++;
            x1++;
        
        }
        else{
            copy[x1]= arr[n2];
            n2++;
            x1++;
        }
    }

    while(n1<=mid){
        copy[x1]= arr[n1];
        x1++;
        n1++;
    }
    while(n2<=r){
        copy[x1]=arr[n2];
        x1++;
        n2++;
    }
    for (int i = l; i <= r; i++) {
    arr[i] = copy[i - l];
}

return count;
    
 }


}