package entities;

public class SavingsAccount extends Account {

	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount (Integer number, String holder, Double balance, double interestRate) {
		super (number, holder, balance);
		this.interestRate = interestRate;
	}
	
	
	public void setInterestRate (Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public Double getInterestRate () {
		return interestRate;
	}
	
	@Override
	public void withdraw (Double amount) {
		balance -= amount;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
}
