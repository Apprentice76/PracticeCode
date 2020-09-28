public class TwoDArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max=Integer.MIN_VALUE; 
        int sum=0;
        for (int j=0; j<4; j++) {
            for (int i=0; i<4; i++) {
                sum=arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]
                   +arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}