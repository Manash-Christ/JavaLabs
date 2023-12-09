import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

abstract class Robber{
    void RobbingClass(){
        System.out.println("MScAI&ML");
    }
    abstract int RowHouses(int[] Array);
    abstract int RoundHouses(int[] Array);
    //abstract int SquareHouse(int[] Array);
    abstract int RectangleHouse(int[] Array);
    void MachineLearning(){
        System.out.print("I love ML");
    }
}

class JAVAprofessionalRobber extends Robber{
    int RowHouses(int[] Array){
        int maxProfitLeft=0;
        int maxProfitRight=0;
        int maxProfitExt=0;
        for(int i=0;i<Array.length;i++){

            if(i%2==0){
              maxProfitLeft+=Array[i];
            }
        
            if(i%2==1){
              maxProfitRight+=Array[i];
            }       
        }
        maxProfitExt = Array[0] + Array[Array.length-1];
        //int[] max =  new int[4];
        Integer max[] = {maxProfitLeft,maxProfitRight,maxProfitExt};
        return Collections.max(Arrays.asList(max));
        }

    int RoundHouses(int[] Array){
        int maxProfitLeft=0;
        int maxProfitRight=0;
        //int maxProfitExt=0;
        for(int i=0;i<Array.length;i++){

            if(i%2==0){
              maxProfitLeft+=Array[i];
            }
        
            if(i%2==1){
              maxProfitRight+=Array[i];
            }       
        }
        //maxProfitExt = Array[0] + Array[Array.length-1];
        Integer max[] = {maxProfitLeft,maxProfitRight};
        return Collections.max(Arrays.asList(max));
    }

    int RectangleHouse(int[] Array){
        int maxProfitLeft,maxProfitRight,maxProfitExtLeft,maxProfitExtRight;
        maxProfitLeft = Array[0] + Array[2] + Array[4];
        maxProfitRight = Array[1] + Array[3] + Array[5];
        maxProfitExtLeft = Array[0] + Array[3];
        maxProfitExtRight = Array[2] + Array[5];
        Integer max[] = {maxProfitLeft,maxProfitRight,maxProfitExtLeft,maxProfitExtRight};
        //int[4] max = {maxProfitLeft,maxProfitRight,maxProfitExtLeft,maxProfitExtRight};
        return Collections.max(Arrays.asList(max));
    }    
            
    }

class Main{
    public static void main (String args[]){
        // Test Case 
        JAVAprofessionalRobber ob1 = new JAVAprofessionalRobber();
        Scanner scaninput = new Scanner(System.in);
        System.out.println("Enter (1) for row house, (2) for round/square house, and (3) multihouse.");
        int answer  = scaninput.nextInt();
        if(answer == 1){
            int[] rowAmounts = new int[4];
            for(int i=0;i<4;i++){
                System.out.println("Enter the amount " +i+" for row house: ");
                rowAmounts[i] = scaninput.nextInt();
            }
            System.out.println("TOTAL STOLEN: " + ob1.RowHouses(rowAmounts));
            
        }
        if(answer == 2){
            int[] rowAmounts = new int[4];
            for(int i=0;i<4;i++){
                System.out.println("Enter the amount " + i + " for row house: ");
                rowAmounts[i] = scaninput.nextInt();
            }
            System.out.println("TOTAL STOLEN: " + ob1.RoundHouses(rowAmounts));
            
        }
        if(answer == 3){
            int[] rowAmounts = new int[6];
            for(int i=0;i<6;i++){
                System.out.println("Enter the amount "+ i + " for row house: ");
                rowAmounts[i] = scaninput.nextInt();
            }
            System.out.println("TOTAL STOLEN: " + ob1.RectangleHouse(rowAmounts));
            
        }
    }
}
