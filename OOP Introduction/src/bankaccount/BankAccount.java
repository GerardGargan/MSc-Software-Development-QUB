package bankaccount;

/**
 * 
 * @author ggargan
 *
 */
public class BankAccount {
	private String name;
	private double balance;
	private String accNo;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the accNo
	 */
	public String getAccNo() {
		return accNo;
	}
	/**
	 * @param accNo the accNo to set
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Update balance by adding deposit amount
	 * @param amount - the value to be deposited
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public double withdraw(double amount) {
		if(balance>=amount) {
			this.balance -= amount;
			return amount;
		} else {
			System.err.println("Insufficient funds in "+getName());
			return -1;
		}
		
	}
	
	/**
	 * Transfer money from this account to the reciever (toAcoount)
	 * @param toAccount - the account to transfer to
	 * @param amount - the amount to transfer
	 */
	public void transfer(BankAccount toAccount, double amount) {
		double withdraw = this.withdraw(amount);
		if(withdraw != -1) {
			toAccount.deposit(amount);
		} else {
			System.out.println("Not enough funds available");
		}
	}
	
	
}
