package croyale.rpc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ServerHost extends UnicastRemoteObject implements ServerHostInterface
{
	public ServerHost() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double getUserBalance() throws RemoteException
	{
		double ret = 0;
		
		System.out.println("Called get user balance method");
		
		return ret;
	}
}