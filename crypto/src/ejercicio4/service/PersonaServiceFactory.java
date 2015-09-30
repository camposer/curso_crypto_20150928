package ejercicio4.service;

public abstract class PersonaServiceFactory {
	private static PersonaService INSTANCE = new PersonaServiceImpl();

	public static PersonaService createPersonaService() {
		return INSTANCE;
	}
}
