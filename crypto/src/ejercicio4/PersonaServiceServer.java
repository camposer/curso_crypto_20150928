package ejercicio4;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ejercicio4.rmi.PersonaServiceServant;

public class PersonaServiceServer {
	private static final int PUERTO = 1099;

	public static void main(String[] args) throws Exception {
		Registry registry = 
				LocateRegistry.createRegistry(PUERTO);
		System.out.println("Enlazando PersonaService...");
		registry.rebind("PersonaService", new PersonaServiceServant());
	}
}
