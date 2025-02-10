public class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin){
        this.balance = balance;
        this.pin = pin;
    }

    public void dislayMenu(){
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");
        System.out.println("5. Exit");
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        if(balance < amount){
            System.out.println("Insufficient Funds");
            return;
        }
        balance -= amount;
    }

    public int getBalance(){
        return balance;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public void changePin(int newPin){
        pin = newPin;
    }

    public static void main(String[] args) {
        //System.out.println("Hello World");
        ATM atm = new ATM(100000, 234765);
        System.out.println("Enter PIN");
        int pin = Integer.parseInt(System.console().readLine());
        if(!atm.validatePin(pin)) {
            System.out.println("Your pin is failed");
            System.out.println("Enter PIN");
            pin = Integer.parseInt(System.console().readLine());
        }

        if(atm.validatePin(pin)){
            int option = 0;
            while (option != 5){
                atm.dislayMenu();
                option = Integer.parseInt(System.console().readLine());
                switch (option){
                    case 1:
                        System.out.println("Balance: " + atm.getBalance());
                        break;
                    case 2:
                        System.out.println("Enter Amount");
                        int amount = Integer.parseInt(System.console().readLine());
                        atm.deposit(amount);
                        break;
                    case 3:
                        System.out.println("Enter Amount");
                        amount = Integer.parseInt(System.console().readLine());
                        atm.withdraw(amount);
                        break;
                    case 4:
                        System.out.println("Enter New Pin");
                        int newPin = Integer.parseInt(System.console().readLine());
                        atm.changePin(newPin);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
