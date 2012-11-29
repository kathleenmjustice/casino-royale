package croyale;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import croyale.rpc.ClientRPC;
import croyale.rpc.ServerHostInterface;

public class Client
{
	public static void main(String[] args)
	{
		try {
			ServerHostInterface shi = ClientRPC.getServerInterface();
			LoginWindow.init();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}