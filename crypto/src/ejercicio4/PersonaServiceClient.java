package ejercicio4;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

import ejercicio4.model.Persona;
import ejercicio4.rmi.PersonaService;

/**
 * -Djavax.net.ssl.keyStore=stores/keystore-cliente.jks -Djavax.net.ssl.keyStorePassword=123456
 * -Djavax.net.ssl.trustStore=stores/truststore-cliente.ts -Djavax.net.ssl.trustStorePassword=123456 
 */
public class PersonaServiceClient {
	private Scanner scanner;
	private PersonaService personaService;
	
	public PersonaServiceClient() throws Exception {
		scanner = new Scanner(System.in);

		Registry registry = LocateRegistry.getRegistry();
		personaService = (PersonaService)registry.lookup("PersonaService");

		iniciar();
	}
	
	private void iniciar() throws RemoteException {
		while(true) {
			System.out.println();
			System.out.println("1. Agregar");
			System.out.println("2. Listar");
			System.out.print("?");
			
			String opcion = scanner.nextLine();
			if (opcion.equals("1")) 
				agregar();
			else if (opcion.equals("2"))
				listar();
				
		}
	}

	private void listar() throws RemoteException {
		List<Persona> personas = personaService.obtenerPersonas();
		if (personas != null) for (Persona p : personas)
			System.out.println(p);
	}

	private void agregar() throws RemoteException {
		Persona p = new Persona();
		System.out.print("Nombre? ");
		p.setNombre(scanner.nextLine());
		System.out.print("Apellido? ");
		p.setApellido(scanner.nextLine());
		
		personaService.agregarPersona(p);
	}

	public static void main(String[] args) throws Exception {
		new PersonaServiceClient();
	}
	
	
}
