package croyale;

public class Player {
	String name;
	int balance;
	String usrname;
	String pwd;
	String email;
	String phone;
	String address;

	public int getBalance(){
		balance  = Database.getBalance(usrname);
		return balance;
	}
}

