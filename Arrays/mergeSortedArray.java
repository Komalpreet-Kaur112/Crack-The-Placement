package Arrays;

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = nums1.length - 1;
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[end1] = nums1[m-1];
                m--;
            }
            else{
                nums1[end1] = nums2[n-1];
                n--;
            }
            end1--;
        }
        while(n>0){
            nums1[end1] = nums2[n-1];
            n--;
            end1--;
        }
    }
}
