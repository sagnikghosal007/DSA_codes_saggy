class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1=a.length;
        int n2=b.length;
        int n=n1+n2;
        int i=0;
        int j=0;
        int cnt=0;
        int ind2=n/2;
        int ind1=ind2-1;
        int ind1el=-1;
        int ind2el=-1;
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                if(cnt==ind1) ind1el=a[i];
                if(cnt==ind2) ind2el=a[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==ind1) ind1el=b[j];
                if(cnt==ind2) ind2el=b[j];
                cnt++;
                j++;
            }  
        }
        while(i<n1){
            if(cnt==ind1) ind1el=a[i];
            if(cnt==ind2) ind2el=a[i];
            cnt++;
            i++;

        }
        while(j<n2){
            if(cnt==ind1) ind1el=b[j];
            if(cnt==ind2) ind2el=b[j];
            cnt++;
            j++;
        }
         // If the total length is even, return the average of the two middle elements
        if (n % 2 == 0) {
            return (ind1el + ind2el) / 2.0;
        }

        // If the total length is odd, return the middle element
        return ind2el;   
    }
}

//Brute Force Solution :-
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         // Get the sizes of both input arrays.
//         int n = nums1.length;
//         int m = nums2.length;

//         // Merge the arrays into a single sorted array.
//         int[] merged = new int[n + m];
//         int k = 0;
//         for (int i = 0; i < n; i++) {
//             merged[k++] = nums1[i];
//         }
//         for (int i = 0; i < m; i++) {
//             merged[k++] = nums2[i];
//         }

//         // Sort the merged array.
//         Arrays.sort(merged);

//         // Calculate the total number of elements in the merged array.
//         int total = merged.length;

//         if (total % 2 == 1) {
//             // If the total number of elements is odd, return the middle element as the median.
//             return (double) merged[total / 2];
//         } else {
//             // If the total number of elements is even, calculate the average of the two middle elements as the median.
//             int middle1 = merged[total / 2 - 1];
//             int middle2 = merged[total / 2];
//             return ((double) middle1 + (double) middle2) / 2.0;
//         }
//     }
// }
