package croyale;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import croyale.rpc.Constants;
import croyale.rpc.ServerHost;

public class Server implements Constants
{
	public static void main(String[] args)
	{
		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(2020);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				registry = LocateRegistry.getRegistry(2020);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Database dbf = new Database("connect");
//			ServerRPC.init(dbf, registry);
			
			registry.rebind(SERVER_NAME, new ServerHost(dbf));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
}