import java.util.Scanner;

public class ATM {
	
	private Account account;
	public ATM(Account account) {
		this.account = account;
	}

	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		User vv = new User(1234, "Veronica Vergara", "June 15, 2001","123 Main St., Scotch Plains, NJ 07076");
		Account act = new Account(0,vv);
		ATM atm = new ATM(act);		
		act.setAccountNumber(123456);
		boolean exit = false;
		boolean auth = false;
		long actnum = 0;
		double deposit = 0;
		double withdraw = 0;
		
		int pin = 0;
		do {
			System.out.println("\nEnter your account number: ");
			actnum = in.nextLong();
			System.out.println("Enter your pin: ");
			pin = in.nextInt();
			if(actnum == act.getAccountNumber() && pin == vv.getPIN()) {
				auth = true;
			}
			else {
				System.out.print("\nYour account number or pin is incorrect. Try again.\n");
			}
		} while(auth == false);
		
		do {
			System.out.println("\n\nPlease select an option from the menu:\n1: DEPOSIT\n2: WITHDRAW\n3: "
					+ "VIEW BALANCE\n4: EXIT");
			int option = in.nextInt();
			if(option == 1) { // deposit
				System.out.println("\nHow much would you like to depsoit?");
				deposit = in.nextDouble();
				if(deposit>0) {
					act.deposit(deposit);
					System.out.printf("\nYou deposited $%.2f",deposit);
					System.out.printf("\nYour balance is now $%.2f",act.getBalance());
				}
				else {
					System.out.println("Your input is invalid. Please try again.");
				}
			}
			else if(option ==2) { // withdraw
				System.out.println("\nHow much would you like to withdraw?");
				withdraw = in.nextDouble();
				if(withdraw>0 && act.getBalance()>=withdraw) {
					act.withdraw(withdraw);
					System.out.printf("\nYou withdrawed $%.2f",withdraw);
					System.out.printf("\nYour balance is now $%.2f",act.getBalance());
				}
				else {
					System.out.println("Either your input is invalid or your balance will be negative. Please try again.");
				}
			}
			else if(option == 3) { //view balance
				System.out.printf("\nYour balance is currently $%.2f",act.getBalance());
			}
			else if (option == 4) { //exit
				exit = true;
			}
			else {
				System.out.println("\nYou did not chose a valid option. Try again.");
			}
		} while(exit == false);
		System.out.println("\nThank you and have a great day!");
	}
}

/////////////////////////////////// INSTANCE METHODS ///////////////////////////////////

// TODO

// to complete the ATM class, you need to provide the following functionality:
//
// 		- prompt the user to enter an account number and pin
//		- validate that the accounut number and pin are valid
//		- display a menu with available options
//			+ deposit
//			+ withdraw
//			+ view balance
//			+ exit
//		- prompt the user to make a selection from the available menu options
//		- respond accordingly to the user's selection
//			+ this will involve calling methods of the BankAccount class