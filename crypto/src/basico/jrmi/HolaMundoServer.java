package basico.jrmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HolaMundoServer {
	private static final int PUERTO = 1099;

	public static void main(String[] args) throws Exception {
		Registry registry = 
				LocateRegistry.createRegistry(PUERTO);
		System.out.println("Iniciado HolaMundoServer...");
		registry.rebind("HolaMundo", new HolaMundoServant());
	}
}
