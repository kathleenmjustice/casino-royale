package croyale.rpc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRPC implements Constants
{
	private static ServerHostInterface shi;
	
	public static ServerHostInterface getServerInterface() throws MalformedURLException, RemoteException, NotBoundException
	{
		if( shi == null )
		{
			//shi = (ServerHostInterface)Naming.lookup("//10.219.111.136:2020/ITLAPTOP");
			
			Registry registry = LocateRegistry.getRegistry("76.241.64.118", 2020);
//			shi = (ServerHostInterface)registry.lookup("rmi://" + "10.219.111.136:2020" + "/CasinoRoyaleServer");
			
			shi = (ServerHostInterface)registry.lookup(SERVER_NAME);
			
			shi.checkPlayer("michael", "password");
		}
		
		return shi;
	}
}