package croyale.rpc;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;

public interface ServerHostInterface extends Remote
{
	public double getUserBalance(int user_id) throws RemoteException;
	public int checkPlayer(String user_id, String password) throws RemoteException;
	public void setBalance(int user_id, String balance) throws RemoteException;
	public void setPlayer(int id, String firstname, String lastname, String user_id, String password, String address, String phone, String email, String balance) throws RemoteException;
	public ResultSet getPlayer(int id) throws RemoteException;
}