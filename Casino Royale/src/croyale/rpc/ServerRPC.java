package croyale.rpc;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import croyale.Database;

public class ServerRPC implements Constants
{
	// Bind a remote object to be used for RPC with clients
	public static void init(Database db, Registry registry) throws RemoteException, MalformedURLException, UnknownHostException, AlreadyBoundException
	{
		String name = InetAddress.getLocalHost().getHostName();
		String addr = InetAddress.getLocalHost().getHostAddress();
		
		//System.out.println("//" + addr + ":2020/" + name);
		
		//Naming.rebind("//" + addr + ":2020/" + SERVER_NAME, new ServerHost(db));
		registry.rebind(SERVER_NAME, new ServerHost(db));
	}
}