package arrays;
class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if(len % 2 == 0){
            double left =  (double)findKthHelper(nums1, 0, nums2, 0, len/2);
            double right =  (double)findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
            return (double)(left + right)/2;
        }else{
            return findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
        }
    }
    private int findKthHelper(int[] A, int aStart, int[] B, int bStart, int k){
        if(aStart >= A.length){
            return B[bStart + k - 1];
        }
        if(bStart >= B.length){
            return A[aStart + k - 1];
        }
        if(k == 1){
            return Math.min(A[aStart], B[bStart]);
        }
        int aMid = aStart + k/2 - 1;
        int bMid = bStart + k/2 - 1;
        int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
        int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];
        if(aVal <= bVal){
            return findKthHelper(A, aMid + 1, B, bStart, k - k/2);
        }else{
            return findKthHelper(A, aStart, B, bMid + 1, k - k/2);
        }
    }
    
    
    
//    int kth(int a[], int m, int b[], int n, int k) {
//        if (m < n) return kth(b,n,a,m,k);
//        if (n==0) return a[k-1];
//        if (k==1) return min(a[0],b[0]);
//
//        int j = min(n,k/2);
//        int i = k-j;
//        if (a[i-1] > b[j-1]) return kth(a,i,b+j,n-j,k-j);
//        return kth(a+i,m-i,b,j,k-i);
//    }
//
//    double findMedianSortedArrays(int a[], int m, int b[], int n) {
//        int k = (m+n)/2;
//        int m1 = kth(a,m,b,n,k+1);
//        if ((m+n)%2==0) {
//            int m2 = kth(a,m,b,n,k);
//            return ((double)m1+m2)/2.0;
//        }
//        return m1;
//    }
}