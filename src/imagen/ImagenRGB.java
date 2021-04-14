package imagen;


public class ImagenRGB {
	ColorRGB imagen[][];
	ImagenRGB copia;
	
	public ImagenRGB(ImagenRGB o){
	
		this.copia = o;
		
	}
	
	public ImagenRGB(int ancho, int alto){
		
		ColorRGB colorBlanco = ColorRGB.WHITE;
		ColorRGB[][] imagen = new ColorRGB[ancho][alto];
		//ira llenando la imagen columna por columna
		for (int i = 0; i < imagen.length; i++) {
			for (int j = 0; j < imagen[i].length; j++) {
				 
				imagen[i][j] = colorBlanco;
				
			}
		}
		
		this.imagen = imagen;
	}
	
	public void setColor(int fila, int columna, ColorRGB color){
		
		
	
		imagen[columna][fila] = color;
		
	}
	
	public int getAncho(){
	
		
		return imagen.length;

	}
	
	public int getAlto(){
		
		return imagen[0].length;
		
	}
	
	public ColorRGB getColor(int fila, int columna){
		
		
		
		return imagen[columna][fila];
		
	}
	
	public String toString(){
		
		return "(" + imagen.length + "X" + imagen[0].length + ")";
		
	}

}
