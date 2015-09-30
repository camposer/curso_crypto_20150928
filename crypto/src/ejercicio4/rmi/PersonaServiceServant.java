package ejercicio4.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

import ejercicio4.model.Persona;
import ejercicio4.service.PersonaServiceFactory;

/**
 * -Djavax.net.ssl.keyStore=stores/keystore-servidor.jks -Djavax.net.ssl.keyStorePassword=123456
 * -Djavax.net.ssl.trustStore=stores/truststore-servidor.ts -Djavax.net.ssl.trustStorePassword=123456 
 */
public class PersonaServiceServant 
		extends UnicastRemoteObject
		implements PersonaService {
	private static final long serialVersionUID = 1804166210627809748L;

	private ejercicio4.service.PersonaService personaService;
	
	public PersonaServiceServant() throws RemoteException {
		//super(); 
		//super(0, new SslRMIClientSocketFactory(), new SslRMIServerSocketFactory()); // SSL 1-way
		super(0, new SslRMIClientSocketFactory(), 
				new SslRMIServerSocketFactory(null, null, true)); // SSL 2-way
		personaService = PersonaServiceFactory.createPersonaService();
	}

	@Override
	public void agregarPersona(Persona p) throws RemoteException {
		personaService.agregarPersona(p);
	}

	@Override
	public void modificarPersona(Persona p) throws RemoteException {
		personaService.modificarPersona(p);
	}

	@Override
	public void eliminarPersona(Integer id) throws RemoteException {
		personaService.eliminarPersona(id);
	}

	@Override
	public Persona obtenerPersona(Integer id) throws RemoteException {
		return personaService.obtenerPersona(id);
	}

	@Override
	public List<Persona> obtenerPersonas() throws RemoteException {
		return personaService.obtenerPersonas();
	}

}
