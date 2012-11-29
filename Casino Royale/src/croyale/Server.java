package croyale;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import croyale.rpc.ServerRPC;

public class Server
{
	public static void main(String[] args)
	{
		try {
			ServerRPC.init();
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
}