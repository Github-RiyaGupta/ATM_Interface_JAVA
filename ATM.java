//ATM Interface Task-1 BMS
import java.util.Scanner;
class BankAccount{
	private double balance;

	public BankAccount(double initialBalance)
	{
		balance=initialBalance;
	}
	public double getBalance()
	{
		return balance;
	}

	public void deposit(double amount){
		if(amount>0){
			balance=balance+amount;
			System.out.println("Money deposited:"+amount);
		}
		else{
			System.out.println("Invalid amount for deposit!");
		}
	}

	public void withdraw(double amount){
		if(amount>0 && amount<=balance){
			balance=balance-amount;
			System.out.println("Money withdrawn:"+amount);
		}
		else{
			System.out.println("Insufficient funds or invalid amount for withdrawal!");
		}
	}
}

class ATM{
	private BankAccount account;
	private Scanner sc;

	public ATM(BankAccount account){
		this.account=account;
		sc=new Scanner(System.in);
	}

	public void showMenu(){
		System.out.println("****MENU****\n");
		System.out.println("ATM Menu\n1. Check Balance\n2. Deposit Cash\n3. Withdraw Cash\n4. Exit\n ");
		
	}
	public void start(){
		int choice;
		do{
			showMenu();
			System.out.println("enter your choice:");
			choice=sc.nextInt();
			switch(choice){
				case 1:
					checkBalance();
					break;
				case 2:
					deposit();
					break;
				case 3:
					withdraw();
					break;
				case 4:
					System.out.println("Exiting ATM.thank you");
					break;			
			}
		}while(choice!=4);
	}
	private void checkBalance(){
		System.out.println("Current balance:"+account.getBalance());
	}
	private void deposit(){
		System.out.println("Enter deposit amount:");
		double amount=sc.nextDouble();
		account.deposit(amount);
	}
	private void withdraw(){
		System.out.println("Enter withdrawal amount:");
		double amount=sc.nextDouble();
		account.withdraw(amount);
	}
}
class TestMain{
	public static void main(String[] args){
		BankAccount userAccount=new BankAccount(10000);
		ATM atm=new ATM(userAccount);
		atm.start();
	}
}