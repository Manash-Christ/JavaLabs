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
        System.out.println(choice);
        if(choice.toLowerCase().equals("none")){
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
        }
        if (choice.toLowerCase() == "own"){
            System.out.println("Enter Bank A balance");

        }

    }
}
