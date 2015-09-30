package basico.jrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz remota
 * 1. Debe extender de java.rmi.Remote
 * 2. Todos los métodos deben poder lanzar la excepción java.rmi.RemoteException
 */
public interface HolaMundo extends Remote {
	String saludar(String nombre) throws RemoteException;
}
