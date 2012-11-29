package croyale;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import croyale.rpc.ServerRPC;

public class Server
{
	public static void main(String[] args)
	{
		try {
			LocateRegistry.createRegistry(2020);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Database dbf = new Database("connect");
			ServerRPC.init(dbf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
}