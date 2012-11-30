package croyale;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import croyale.rpc.ServerRPC;

public class Server
{
	public static void main(String[] args)
	{
		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(2020);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		try {
			Database dbf = new Database("connect");
			ServerRPC.init(dbf, registry);
		} catch( AlreadyBoundException abe ){
			System.out.println("Already bound");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
}