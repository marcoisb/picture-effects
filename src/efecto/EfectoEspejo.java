package efecto;

import imagen.ImagenRGB;

public class EfectoEspejo extends Efecto{
	
	public EfectoEspejo(String nombre) {
		
		super(nombre);
		
	}


	public ImagenRGB aplicar(ImagenRGB img) {

		if (img == null) {
			
			throw new IllegalArgumentException("En metodo aplicar de Efecto Espejo: parametro de entrada nulo");
		}
		
		ImagenRGB nuevaImagen = new ImagenRGB(img.getAncho(),img.getAlto());
		
		for (int i = 0; i < img.getAncho(); i++) {
			for (int j = 0; j < img.getAlto(); j++){
				
				 nuevaImagen.setColor(j, i, img.getColor(j, (img.getAncho()-1) - i));

			}
			
		}
		return nuevaImagen;
	}


}
