package colecciones;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import efecto.Efecto;

public class EfectosList implements IEfectos{
	 private List<Efecto> listaEfectos;
	 
	public EfectosList() {
		
		listaEfectos =  new ArrayList<Efecto>();
		
	}
	public boolean addEfecto(Efecto e) {
		boolean añadido = false;
		boolean repetido = false;
		Iterator<Efecto> iterador = listaEfectos.iterator();
		if (listaEfectos.isEmpty()) {
			
			listaEfectos.add(e);
			añadido = true;
		}else {
		
			while(iterador.hasNext()) {
				
				repetido = iterador.next().equals(e)? true:false;		
			}
			if (!repetido) {

				listaEfectos.add(e);
				añadido = true;
			}
		}
			
		return añadido;
	}
	public Efecto getEfecto(String nombre){
		
		Efecto efectoRequerido = null;
		Iterator<Efecto> iterator = listaEfectos.iterator();
		boolean encontrado =  false;
		if(listaEfectos.size()>0){
			
			while(iterator.hasNext() && !encontrado) {
					
				efectoRequerido = iterator.next();
				encontrado = efectoRequerido.getNombre() == nombre? true:false;
		
			}		
		}
		
		return efectoRequerido;
		
	}
	
	public Efecto delEfecto(String nombre) {
		Efecto efectoRequerido = null;
		Iterator<Efecto> iterador = listaEfectos.iterator();
		boolean encontrador = false;
		if (listaEfectos.size() > 0) {
			while(iterador.hasNext() && !encontrador) {
				
				efectoRequerido = iterador.next();
				encontrador = efectoRequerido.getNombre() == nombre? true:false;				
				
			}
			if (encontrador) {
				
				listaEfectos.remove(efectoRequerido);
			}else {
				
				efectoRequerido = null;
			}
		}
		
		return efectoRequerido; 
	}
	public String[] getNombresEfectos() {
		
		String[] arrayNombresEfectos = new String[listaEfectos.size()];
		int i = 0;
		if (listaEfectos.size() > 0){
			for(Efecto efecto:listaEfectos) {
				
				arrayNombresEfectos[i] = efecto.getNombre();
				i= i+1;
			}
		}
		
		return arrayNombresEfectos;
		
	}
	
	public Efecto[] getEfectos() {
		
		Efecto[] arrayEfectos = new Efecto[listaEfectos.size()];
		int i = 0;
		if (listaEfectos.size() > 0) {
			for (Efecto efecto : listaEfectos) {
				
				arrayEfectos[i] = efecto;
				i = i + 1;
			}		
		}
		return arrayEfectos;
	}
	public int size() {
		
		return listaEfectos.size();
		
	}

}
