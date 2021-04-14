package colecciones;


import java.util.LinkedHashMap;
import java.util.Map;

import efecto.Efecto;

	
	
public class EfectosMap implements IEfectos {
	
	private Map<String,Efecto> mapEfectos;
	
	
	public EfectosMap() {
	
		mapEfectos = new LinkedHashMap<String, Efecto>();
		
	} 		
		public boolean addEfecto(Efecto e) {
		
		boolean añadido = false;
		boolean repetido = false;
		
		if (mapEfectos.isEmpty()){
			
			mapEfectos.put(e.getNombre(), e);
			añadido = true;
		}else {
			
			for(String nombre : mapEfectos.keySet()) {
				
				if (nombre == e.getNombre()){
					
					repetido = true;		
				}
			}
			if (!repetido) {
				
				mapEfectos.put(e.getNombre(), e);
				añadido =  true;
			}
		}
		return añadido;
	}
	
	public Efecto getEfecto(String nombre){
		
		Efecto efectoRequerido = null;
		for (String nombreComponente : mapEfectos.keySet()) {
			if (nombreComponente == nombre) {
				
				efectoRequerido = mapEfectos.get(nombre);
			}
		}
		
		return efectoRequerido;
	}
	
	public Efecto delEfecto(String nombre) {
	
		Efecto efectoRequerido = null;
		boolean encontrado = false;
		for(String llaves:mapEfectos.keySet()) {
			if(llaves == nombre){
				
				efectoRequerido = mapEfectos.get(llaves);
				encontrado = true;
			}
		}
		if (encontrado) {
			
			mapEfectos.remove(nombre);
			
		}
		return efectoRequerido; 
	
	}
	
	public String[] getNombresEfectos() {
		
		String[] arrayNombresEfectos = new String[mapEfectos.size()];
		arrayNombresEfectos = mapEfectos.keySet().toArray(arrayNombresEfectos);
				
		return arrayNombresEfectos;
	}
	
	public Efecto[] getEfectos() {
	
		Efecto[] arrayEfectos = new Efecto[mapEfectos.size()];
		arrayEfectos = mapEfectos.values().toArray(arrayEfectos);
	
		return arrayEfectos;
	}
	public int size() {
		
		int numEfectos = 0;
		if (mapEfectos.size() > 0) {
			
			numEfectos = mapEfectos.size();
		}
		
		return numEfectos;
	}

}
