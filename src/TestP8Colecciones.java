import utilidades.UtilidadesImagen;
import imagen.ColorRGB;
import imagen.ImagenRGB;
import colecciones.EfectosList;
import colecciones.EfectosMap;
import colecciones.IEfectos;
import efecto.Efecto;
import efecto.EfectoBorde;
import efecto.EfectoEspejo;
import efecto.EfectoRotar;

public class TestP8Colecciones {

	/**
	 * Clase de Test de la práctica 8 de colecciones
	 *  
	 * @param args recibe como argumentos: el tipo de colección donde almacenar los efectos (mapa o lista), el fichero que contine la imagen a la que 
	 * aplicaremos los efectos y el fichero donde guardaremos la imagen resultado de aplicar los efectos.
	 */
	public static void main(String[] args) {
		
		if (args.length == 3 && ( args[0].equals("mapa") || args[0].equals("lista")) ) {
			//Declaración de variables y su inicialización
			
			final IEfectos   colEfectos; //manejador de la lista o mapa
			if (args[0].equals("mapa"))
				colEfectos = new EfectosMap();
			else 
				colEfectos = new EfectosList();
			
			final String ficheroSalida=args[2]; //fichero donde guardaremos la imagen aplicada los efectos
			final String ficheroEntrada=args[1];; //fichero que contiene la imagen original
			final ImagenRGB imgInicial= UtilidadesImagen.recuperarImagen(ficheroEntrada); 		
			
			//Pruebas
			
			boolean aserciones = false;
			assert aserciones = true;
			if (aserciones){
				System.out.println("Prueba de añadido de un efecto a "+args[0]);
				boolean res=colEfectos.addEfecto(new EfectoEspejo("EESPEJO"));
				String[] nombres=colEfectos.getNombresEfectos();
				assert (res && nombres.length==1 && nombres[0].equals("EESPEJO") && colEfectos.size()==1):"Error al añadir un efecto a "+ args[0];
				System.out.println("\tprueba pasada");
				
				System.out.println("Prueba de añadido de un efecto repetido a "+args[0]);
				res=colEfectos.addEfecto(new EfectoEspejo("EESPEJO"));
				assert (!res):"Error al añadir un efecto repetido a "+ args[0];
				System.out.println("\tprueba pasada");

				System.out.println("Prueba de borrado de un efecto de "+ args[0]);
				Efecto e=colEfectos.delEfecto("EESPEJO");
				assert (e!=null && e.getNombre().equals("EESPEJO")):"Error al borrar un efecto de "+ args[0];
				System.out.println("\tprueba pasada");
				
				
				System.out.println("Prueba de añadido de 3 efectos de "+ args[0]);
				res=colEfectos.addEfecto(new EfectoBorde("EBORDE",100, ColorRGB.BLUE));
				assert (res && colEfectos.size()==1):"Error al añadir el efecto "+ "EBORDE";
				res=colEfectos.addEfecto(new EfectoEspejo("EESPEJO"));
				assert (res && colEfectos.size()==2):"Error al añadir el efecto "+ "EESPEJO";
				res=colEfectos.addEfecto(new EfectoRotar("EROTAR",1));
				assert (res && colEfectos.size()==3):"Error al añadir el efecto "+ "EROTAR";
				System.out.println("\tprueba pasada");
			
				System.out.println("Prueba de obtención del array de efectos de "+ args[0]);
				Efecto[] efs =colEfectos.getEfectos(); //(new EfectoEspejo("EESPEJO"));
	
				assert (efs!=null && efs.length==3 && efs[0].getNombre().equals("EBORDE")
						&& efs[1].getNombre().equals("EESPEJO") && efs[2].getNombre().equals("EROTAR")
						):"Error al obtener los tres efectos.";
				System.out.println("\tprueba pasada");
				
				System.out.println("Prueba de obtención de efecto de "+ args[0]);
				Efecto efe =colEfectos.getEfecto("EBORDE"); 
				assert (efe !=null && efe.getNombre().equals("EBORDE")):"Error al obtener el efecto EBORDE.";
				efe =colEfectos.getEfecto("EESPEJO"); 
				assert (efe !=null && efe.getNombre().equals("EESPEJO")):"Error al obtener el efecto EESPEJO";
				efe =colEfectos.getEfecto("EROTAR"); 
				assert (efe !=null && efe.getNombre().equals("EROTAR")):"Error al obtener el efecto EROTAR.";
				System.out.println("\tprueba pasada");
				
				System.out.println("Prueba de aplicacón de efectos en secuencia y según orden de inserción de "+ args[0]);
				nombres = colEfectos.getNombresEfectos();
				
				int i=0;
				ImagenRGB imagenFinal= imgInicial;
				for (String nombre: nombres){
					efe=colEfectos.getEfecto(nombre);
					//if(efe.getNombre().equals("EROTAR"))
					imagenFinal=efe.aplicar(imagenFinal);
					i++;
				}
				assert (i==3):"Error, deberían aplicarse 3 efectos";
				
				UtilidadesImagen.visualizarImagen(imgInicial);
				UtilidadesImagen.visualizarImagen(imagenFinal);
				//guardar imagen resultado
				UtilidadesImagen.guardarImagen(ficheroSalida,imagenFinal);
				
				System.out.print("\nSe han aplicado: "+ i +" efectos: borde, espejo y rotacion de 90 grados");
				System.out.print("\nVerifique la imagen de salida a ver si se le han aplicado correctamente los 3 efectos en cascada");
				
			}else{
				System.out.println ("No tienes activadas las aserciones");
				System.out.print("Si no ejecuta este programa con -ea no funcionará correctamente");
				System.out.println(", por ejemplo:\n\t java TestP8Colecciones -ea");
				System.out.println("Con eclipse hay que ponerlo como argumento en la VM dentro de las propiedades del programa\n\n" );
			}
		}else
			System.out.println("Se requieren 3 argumentos: tipo colección (mapa o lista), fichero entrada y fichero de salida");
	}
}

