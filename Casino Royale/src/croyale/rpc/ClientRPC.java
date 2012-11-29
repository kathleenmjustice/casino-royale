package croyale.rpc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientRPC implements Constants
{
	private static ServerHostInterface shi;
	
	public static ServerHostInterface getServerInterface() throws MalformedURLException, RemoteException, NotBoundException
	{
		if( shi == null )
		{
			shi = (ServerHostInterface)Naming.lookup(SERVER_NAME);
		}
		
		return shi;
	}
}