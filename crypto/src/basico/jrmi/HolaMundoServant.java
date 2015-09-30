package basico.jrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Sus objetos serán objetos remotos
 * 1. Extiende de UnicastRemoteObject
 * 2. Implementa la interfaz remota
 */
public class HolaMundoServant
		extends UnicastRemoteObject
		implements HolaMundo {

	private static final long serialVersionUID = -1598333638570076623L;

	public HolaMundoServant() throws RemoteException {
		super();
	}

	@Override
	public String saludar(String nombre) throws RemoteException {
		return "Hola " + nombre;
	}

}
