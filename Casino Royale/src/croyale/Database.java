package croyale;

public class Database {
	public static final boolean SUCCESS = false;
	public static final boolean FAILURE = true;

	public static boolean createAccount(String name, String usrname, String pwd){
		
		return SUCCESS;
	}
	
	public static boolean doesExist(String usrname){
		
		return false;
	}
	
	public static boolean updateAddress(String usrname, String address){
		
		return SUCCESS;
	}
	
	public static boolean updateBalance(String usrname, int balance){
		
		return SUCCESS;
	}
	
	public static boolean updatePhone(String usrname, String phone){
		
		return SUCCESS;
	}
	
	public static boolean updateEmail(String usrname, String email){
		
		return SUCCESS;
	}
	
	public static int getBalance(String usrname){
		
		return 0;
	}
}
