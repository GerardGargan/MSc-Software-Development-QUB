package bankaccount;

public class MoneyMatters {

	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount();
		BankAccount gerardsAcct = new BankAccount();
		BankAccount otherAcct = new BankAccount();
		myAccount.setName("Matthews Acc");
		gerardsAcct.setName("A very large one");
		gerardsAcct.deposit(99);
		myAccount.deposit(2);
		
		
		System.out.println("My account name: "+myAccount.getName());
		System.out.println("Gerards account name: "+gerardsAcct.getName());
		System.out.println("Gerards account name: "+otherAcct.getName());
		
		System.out.println("my account balance: "+myAccount.getBalance());
		
		myAccount.withdraw(5000.22);
		System.out.println(gerardsAcct.getBalance());
		myAccount.transfer(gerardsAcct, 1000);
		System.out.println(gerardsAcct.getBalance());
		

	}

}
