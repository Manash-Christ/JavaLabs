import java.util.Scanner;
import java.util.Arrays;
public class Perm{



   public static int findCombinationsCount(int sum, int vals[]) {
        if (sum < 0) {
            return 0;
        }
        if (vals == null || vals.length == 0) {
            return 0;
        }

        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < vals.length; ++i) {
            for (int j = vals[i]; j <= sum; ++j) {
                dp[j] += dp[j - vals[i]];
            }
        }
        return dp[sum];
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int Size,Sum;
        System.out.println("Enter the size of the aray");
        Size = s.nextInt();

        System.out.println("Enter the sum of the combinations");
        Sum  = s.nextInt();

        
        int[] Coins = new int[Size];
        for(int i=0;i<Size;i++){
            System.out.println("Enter element"+i+" into array");
            Coins[i] = s.nextInt();
        } 
        System.out.println("Size: "+Size);
        System.out.println("Sum: "+Sum);
        System.out.println(Arrays.toString(Coins));

        System.out.println(findCombinationsCount(Sum, Coins));

        
    }

   // int[] combinations(int Size,int Sum,int[] Coins){

   // }
}