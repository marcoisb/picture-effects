package efecto;

import imagen.ImagenRGB;

public class EfectoRotar extends Efecto{
	
	private int  giros;
	
	public EfectoRotar(String nombre, int numGiros) {
		
		super(nombre);
		if(numGiros < 0) {
			
			throw new IllegalArgumentException("En contructor de Efecto Rotar: parametro de entrada nulo");
		}
		
		this.giros = numGiros; 
	}
	
	public ImagenRGB aplicar(ImagenRGB img) {
		
		if (img == null) {
	
			throw new IllegalArgumentException("En metodo aplicar de Efecto Rotar: parametro de entrada nulo");
		}
		
		ImagenRGB nuevaImagen = img;
		
		for (int i = 0; i < giros; i++) {
			
			nuevaImagen = rotar90(nuevaImagen);
		}
	
		return nuevaImagen;
	}
	
	public String toString() {
		
		return "Efecto=" + nombre + ", Giros=" + giros;
		
	}
	
	
	public ImagenRGB rotar90(ImagenRGB ImagenOriginal) {
		
		ImagenRGB ImagenSalida = new ImagenRGB(ImagenOriginal.getAlto(), ImagenOriginal.getAncho());
		for(int i = 0, j = ImagenOriginal.getAlto()-1 ; i < ImagenOriginal.getAlto() ; i++, j--) {
			for(int k = 0 ; k < ImagenOriginal.getAncho() ; k++) {

				ImagenSalida.setColor(k, j,ImagenOriginal.getColor(i,k)); 

			}
		}

		return ImagenSalida;
	}
	


}
