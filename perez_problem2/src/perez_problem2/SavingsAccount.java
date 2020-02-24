package perez_problem2;

public class SavingsAccount {
	static double annualInterestRate;
	private double savingsBalance;
	
	public void calculateMonthlyInterest() {
		// Calculate monthly interest by multiplying savingsBalance by annualInterestRate divided by 12
		double newSavingsBalance;
		newSavingsBalance = getSavingsBalance() + (getSavingsBalance() * annualInterestRate) / 12.0;
		// add interest to savingsBalance
		setSavingsBalance(newSavingsBalance);
	}
	public static void modifyInterestRate(double newAnnualInterestRate) {
		// sets the annualInterestRate to a new value
		annualInterestRate = newAnnualInterestRate;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
}
