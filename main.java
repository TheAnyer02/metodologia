package session1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
	
	public static void main(String[] args) {
		
		List<String> rutas_originales = new ArrayList<>();
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\1536x1536.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\1024x1024.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\640x427.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\640x360.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\320x214.png");


		for (String ruta_original : rutas_originales) {
		    try {
		        Auxiliar.GenerarImagenGrises(ruta_original, ruta_original.replaceAll(".png", "_g.png")); // Genera Grises
		        Auxiliar.GenerarImagenOrdenandoColumnas(ruta_original, ruta_original.replaceAll(".png", "_b.png"), 0); // Usa la burbuja para ordenarla por columnas
		        Auxiliar.GenerarImagenOrdenandoColumnas(ruta_original, ruta_original.replaceAll(".png", "_q.png"), 1);// Usa la quick sort para ordenarla por columnas
		        Auxiliar.ImprimeHistograma(Auxiliar.HistogramaImagen(ruta_original));
		    } catch (IOException | InterruptedException e) {
		        e.printStackTrace();
		    }
		    System.out.println("Ejecutado! " + ruta_original);
		    
		}

		
	}

}
