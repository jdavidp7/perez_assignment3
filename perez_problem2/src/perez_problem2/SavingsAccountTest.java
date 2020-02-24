package perez_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		int month = 1;
		SavingsAccount account1 = new SavingsAccount();
		SavingsAccount account2 = new SavingsAccount();
		
		account1.setSavingsBalance(2000);
		account2.setSavingsBalance(5000);
		
		SavingsAccount.annualInterestRate = 0.04;
		System.out.printf(" \t|\tAccount1\t|\tAccount2\t|\n");
		System.out.printf("________|_______________________|_______________________|\n");
		for (int i = 0; i < 12; i++) {
			account1.calculateMonthlyInterest();
			account2.calculateMonthlyInterest();
			System.out.printf("|%d\t|\t%.2f\t\t|\t%.2f\t\t|\n", month, account1.getSavingsBalance(), account2.getSavingsBalance());
			month++;
			

		}
		month = 1;
		System.out.printf("\n\n");
		SavingsAccount.annualInterestRate = 0.05;
		System.out.printf(" \t|\tAccount1\t|\tAccount2\t|\n");
		System.out.printf("________|_______________________|_______________________|\n");
		for (int i = 0; i < 12; i++) {
			account1.calculateMonthlyInterest();
			account2.calculateMonthlyInterest();
			System.out.printf("|%d\t|\t%.2f\t\t|\t%.2f\t\t|\n", month, account1.getSavingsBalance(), account2.getSavingsBalance());
			month++;
			

		}
	}

}
