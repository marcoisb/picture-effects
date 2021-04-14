package efecto;

import imagen.ImagenRGB;

public abstract class Efecto {
	
	protected String nombre;
	public Efecto(String nombre) {
		
		if (nombre == null) {

			throw new IllegalArgumentException("En constructor: parametro de entrada nulo");
			
		}	
		this.nombre = nombre;
	}
	
	public abstract ImagenRGB aplicar(ImagenRGB img)throws IllegalArgumentException ;
	
	public String getNombre() {
		
		return nombre;
	}
	
	public String toString() {
		
		return "Efecto=" + nombre;
	}
	public boolean equals(Efecto e) {
		boolean equals =  false;
		if (e != null && !(e instanceof Efecto)) {
			equals = e.getNombre() == nombre? true:false;
		}
		return equals;
	}
	
	
}
