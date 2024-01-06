import java.util.Scanner;
import java.util.Arrays;
public class Perm{
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

        int[][] newSum = new int[20][Size]; 

        for(int i=0;i<Size;i++){
            for(int j=1;j<Size;j++){
                if(Coins[i]+Coins[j]==Sum){
                    
                }
            }
        }
    }

   // int[] combinations(int Size,int Sum,int[] Coins){

   // }
}