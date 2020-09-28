import java.util.Arrays;

public class LongestSubArrayBySum {
    static int[] findSubArray(int[] A, int sum) {
        int left=0, right=0;
        int[] res = {-1, -1};
        int currSum = 0;
        int currLen = 0;
        while (left <= right && right < A.length) {
            boolean flag = false;
            if (currSum <= sum) {
                currSum += A[right];
                flag = true;
            }
            else if (currSum > sum) {
                currSum -= A[left++];
            }
            if (currSum == sum && currLen <= right - left) {
                res[0] = left;
                res[1] = right;
                currLen = right - left;
            }
            if (flag) right++;
            // System.out.println("left: "+left+", right: "+right+", sum: " + currSum);
        }

        if (res[1] != -1) return res;
        return new int[] {-1};
    }

    public static void main(String[] args) {
        int[] arr = {15, 2, -5, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10};
        int sum = 12;
        int[] res = findSubArray(arr, sum);
        System.out.println(Arrays.toString(res));
    }
    
}