package croyale.rpc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerRPC implements Constants
{
	// Bind a remote object to be used for RPC with clients
	public static void init() throws RemoteException, MalformedURLException
	{
		Naming.rebind(SERVER_NAME, new ServerHost());
	}
}