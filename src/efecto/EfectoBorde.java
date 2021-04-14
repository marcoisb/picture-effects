package efecto;

import imagen.ColorRGB;
import imagen.ImagenRGB;

public class EfectoBorde extends Efecto {
	
	private int ancho;
	private ColorRGB color;
	
	public EfectoBorde(String nombre, int anchoBorde, ColorRGB color) {
		
		
		super(nombre);
		if (anchoBorde < 0 || color == null) {
			
			throw new IllegalArgumentException("En constructor de Efecto Borde: parametros incorrectos o nulos");
			
		}
		this.ancho = anchoBorde;
		this.color = color;
		
	}
	public ImagenRGB aplicar(ImagenRGB img) {
		
		if (img == null) {
			
			throw new IllegalArgumentException("En metodo aplicar: parametro de entrada nulo");
		}
		ImagenRGB nuevaImagen = new ImagenRGB(img.getAncho(),img.getAlto());
		
		for (int i = 0; i < nuevaImagen.getAncho(); i++) {
			for (int j = 0; j < nuevaImagen.getAlto(); j++) {
				
				if((i >= ancho) && (i <= nuevaImagen.getAncho()-ancho) && 
					(j >= ancho) && (j <= nuevaImagen.getAlto()-ancho)) {
					
						nuevaImagen.setColor(j, i, img.getColor(j, i)); 
						
				}else{
					
						nuevaImagen.setColor(j, i, color);
					
				}
			}
		}
	
		return nuevaImagen;
	}
	
	public String toString() {
		
		return "Efecto=" + nombre+", Ancho=" + ancho+", Color="+ color;
		
	}

	
}
