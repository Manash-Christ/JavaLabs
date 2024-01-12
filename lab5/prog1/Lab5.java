import java.util.Scanner;

// bankINTF
interface bankINTF {
    double gBAL();
    double gIR();
}

// Bank A
class BankA implements bankINTF {
    

    private double bal;
    private double intr;
    BankA(){
        this.bal=1000;
        this.intr=0.07;
    }
    BankA(int bal, int intr){
        this.bal = bal;
        this.intr = intr;
    }
    
    public double gBAL() {
        return bal;
    }

    
    public double gIR() {
        return intr; // 7%
    }
    public String getInfo(){
        return "Bank A Details {"+"balance: "+bal+", interest: "+intr+ ", return: " + bal*intr+"}"; 
    }
}

// Bank B
class BankB implements bankINTF {
    private double bal;
    private double intr;
    BankB(){
        this.bal=30000;
        this.intr=0.074;
    }
    BankB(int bal, int intr){
        this.bal = bal;
        this.intr = intr;
    }
    public double gBAL() {
        return bal;
    }

    
    public double gIR() {
        return .074; // 7.4%0
    }
}

// Bank C
class BankC implements bankINTF {
    private double bal = 200000;

    //BankC(int balance);

    
    public double gBAL() {
        return bal;
    }

    
    public double gIR() {
        return 0.079; // 7.9%
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 'own' to input balance or 'none' for default results...");
        String choice = sc.nextLine();
       // System.out.println(choice);
        switch (choice) {
            case "none":
            BankA bA = new BankA();
            BankB bB = new BankB();
            BankC bC = new BankC();
    
            // Display BankA details
            System.out.println("Bank A bal: $" + bA.gBAL());
            System.out.println("Bank A Interest Rate: " + bA.gIR() * 100 + "%");
            System.out.println("The deposit amount will give back: $" + bA.gBAL()*bA.gIR() + " in a year.");
            System.out.println();
    
            // Display BankB details
            System.out.println("Bank B bal: $" + bB.gBAL());
            System.out.println("Bank B Interest Rate: " + bB.gIR() * 100 + "%");
            System.out.println("The deposit amount will give back: $" + bB.gBAL()*bB.gIR() + " in a year.");
    
            System.out.println();
    
            // Display BankC details
            System.out.println("Bank C bal: $" + bC.gBAL());
            System.out.println("Bank C Interest Rate: " + bC.gIR() * 100 + "%");
            System.out.println("The deposit amount will give back: $" + bC.gBAL()*bC.gIR() + " in a year.");
            break;
        

            case "own":
            System.out.println("Enter Bank name (A,B,C)");
            String choice2 = sc.nextLine();
            switch (choice2.toLowerCase()) {
                case "a":
                    System.out.println("Enter balance: ");
                    int Bal1 = sc.nextInt();
                    System.out.println("Enter Interest rate");
                    int intr1 = sc.nextInt();
                    BankA b1 = new BankA(Bal1, intr1);
                    System.out.println(b1.getInfo());
                    break;
                
                case "b":
                    System.out.println("Enter balance: ");
                    int Bal2 = sc.nextInt();
                    System.out.println("Enter Interest rate");
                    int intr2 = sc.nextInt();
                    BankA b2 = new BankA(Bal2, intr2);
                    System.out.println(b2.getInfo());
                    break;

                case "c":
                    System.out.println("Enter balance: ");
                    int Bal3 = sc.nextInt();
                    System.out.println("Enter Interest rate");
                    int intr3 = sc.nextInt();
                    BankA b3 = new BankA(Bal3, intr3);
                    System.out.println(b3.getInfo());
                    break;
            
                default:
                    break;
            }


            default:
           // System.out.println("Enter correct");
                break;
        
        
        
            

        }

    }
}
