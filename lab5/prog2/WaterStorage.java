import java.util.Arrays;
import java.util.Scanner;

public class WaterStorage {

    public static void main(String[] args) {
        
        //TAKE INPUT FOR CITY HEIGHTS
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter length: ");
        int len = scan.nextInt();
        int[] haits = new int[len];
        for(int t=0;t<len;t++){
            System.out.println("enter height at " + (t+1));
            haits[t] = scan.nextInt();
            
        }

        // PRINT THE CITY SCAPE
        System.out.println("City scape: "+Arrays.toString(haits));
        for(int k=0;k<len;k++){
            for(int l=0;l<haits[k];l++)
            System.out.print("#");
            System.out.println("");
        }

        //INITIATE LEFT ARRAY
        int left[] = new int[haits.length];

        //INITIATE RIGHT ARRAY
        int right[] = new int[haits.length];
 
        //INITIATE WATER STORAGE VARIABLE
        int waterStored = 0;

        //INITIATE LEFT ARRAY AS FIRST ARRAY OF HEIGHTS ARRAY AND LOOP THORUGH THE ARRAY TO FIND LEFT MAX
        left[0] = haits[0];
        for(int i=1;i<haits.length;i++) left[i] = Math.max(left[i-1], haits[i]);
        System.out.println(Arrays.toString(left));

        //INITIATE RIGHT ARRAY AS LAST ELEMENT OF HEIGHTS ARRAT AND LOOP BACKWARDS TO FIND
        right[haits.length-1] = haits[haits.length-1];
        for(int i=haits.length-2; i>=0;i--) right[i] = Math.max(right[i+1], haits[i]);
        System.out.println(Arrays.toString(right));

        //ITIRATE THROUGH THE LOOP AND ADD WATER STORED AS THE MINIMUM OF LEFT AND RIGHT MINUS THE HEIGHT OF THE INDEX
        for (int i = 0; i < haits.length; i++) waterStored += Math.min(left[i], right[i]) - haits[i];


        //PRINT AMOUNT OF WATER STORED
        System.out.println("The amount of water stored is: " + waterStored);
    }
}

