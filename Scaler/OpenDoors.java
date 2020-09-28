public class OpenDoors {
    // naive only perfect squares have odd numbers of factors hence left open. 
    int countOpenDoors(int n) {
        int doors = 0;
        for (int i=1; i<=n; i++) {
            int root = (int)Math.sqrt(i);
            if (root*root == i) doors++;
        }
        return doors;
    }

    // O(1) approach
    int countOpenDoorsFast(int n) {
        return (int)Math.sqrt(n);
    }
}