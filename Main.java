import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;

    public ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } else if (amount > this.balance) {
            System.out.println("Insufficient Balance!");
        } else {
            this.balance -= amount;
            System.out.println("Please collect your cash!");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM(5000.0, 1234);

        System.out.println("******** Welcome to ATM ********");
        
        int attempts = 0;
        boolean isAuthenticated = false;

        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            int enteredPin = sc.nextInt();

            if (atm.verifyPin(enteredPin)) {
                isAuthenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN! Attempts left: " + (3 - attempts));
            }
        }

        if (!isAuthenticated) {
            System.out.println("3 incorrect attempts! Your account is locked.");
            return;
        }

        int option;
        do {
            System.out.println("\n========= ATM MENU =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Your Balance: ₹" + atm.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depAmt = sc.nextDouble();
                    atm.deposit(depAmt);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wAmt = sc.nextDouble();
                    atm.withdraw(wAmt);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid Option! Try again.");
            }

        } while(option != 4);

        sc.close();
    }
}


