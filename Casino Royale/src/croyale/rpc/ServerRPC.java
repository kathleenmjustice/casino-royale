package croyale.rpc;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import croyale.Database;

public class ServerRPC implements Constants
{
	// Bind a remote object to be used for RPC with clients
	public static void init(Database db) throws RemoteException, MalformedURLException, UnknownHostException
	{
		String name = InetAddress.getLocalHost().getHostName();
		String addr = InetAddress.getLocalHost().getHostAddress();
		
		System.out.println(name + " " + addr);
		Naming.rebind("//" + addr + ":2020/" + name, new ServerHost(db));
	}
}