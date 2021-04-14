package colecciones;

import efecto.Efecto;

public interface IEfectos {
	
	abstract boolean addEfecto(Efecto e);
	abstract Efecto getEfecto(String nombre);
	abstract Efecto delEfecto(String nombre);
	abstract String[] getNombresEfectos();
	abstract Efecto[] getEfectos();
	abstract int size();
	
}
