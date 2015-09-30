package ejercicio4.service;

import java.util.ArrayList;
import java.util.List;

import ejercicio4.model.Persona;

class PersonaServiceImpl implements PersonaService {
	private List<Persona> personas = new ArrayList<>();
	private int contador = 1;

	@Override
	public void agregarPersona(Persona p) {
		p.setId(contador++);
		personas.add(p);
	}

	private int buscarPos(Integer id) {
		for (int i = 0; i < personas.size(); i++) 
			if (personas.get(i).getId().equals(id)) 
				return i;
		
		return -1;
	}
	
	@Override
	public void modificarPersona(Persona p) {
		int pos = buscarPos(p.getId());
		if (pos > 0)
			personas.set(pos, p);
	}

	@Override
	public void eliminarPersona(Integer id) {
		int pos = buscarPos(id);
		if (pos > 0)
			personas.remove(pos);
	}

	@Override
	public Persona obtenerPersona(Integer id) {
		int pos = buscarPos(id);
		if (pos > 0)
			return personas.get(pos);
		else
			return null;
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return personas;
	}

}
