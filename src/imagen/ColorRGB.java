package imagen;

public class ColorRGB {
	
	public static final ColorRGB BLACK = new ColorRGB(0,0,0);
	public static final ColorRGB BLUE = new ColorRGB(0,0,255);
	public static final ColorRGB GREEN = new ColorRGB(0,255,0);
	public static final ColorRGB RED = new ColorRGB(255,0,0);
	public static final ColorRGB WHITE = new ColorRGB(255,255,255);
	final int r;
	final int g;
	final int b;
	
	public ColorRGB(int r, int g, int b) {

		if(r>255){ this.r = 255;}
		else if(r<0){ this.r = 0;}
		else{ this.r = r;}
		
		if(g>255){ this.g = 255;}
		else if(g<0){ this.g = 255;}
		else{ this.g = g;}
		
		if(b > 255){ this.b = 255;}
		else if(b < 0){ this.b = 0;}
		else{ this.b = b;}
	
	}
	
	
	public int getRed(){
		
		return r;
		
	}
	
	public int getGreen(){
		
		return g;
	}
	
	public int getBlue(){
		
		return b;
		
	}
	
	public String toString(){
		String color = null;
		
		return color;
		
	}

}
