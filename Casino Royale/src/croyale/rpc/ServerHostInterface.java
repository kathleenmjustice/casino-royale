package croyale.rpc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerHostInterface extends Remote
{
	public double getUserBalance() throws RemoteException;
}