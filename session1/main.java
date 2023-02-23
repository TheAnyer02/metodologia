package session1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
	private static final Scanner TECLADO=new Scanner(System.in);
	public static void main(String[] args) {
		int opcion = elegiropcion();
		long tiempoinicial = 0, tiempofinal = 0, ttotal = 0;
		
		List<String> rutas_originales = new ArrayList<>();
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\1536x1536.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\1024x1024.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\640x427.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\640x360.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\320x214.png");


		for (String ruta_original : rutas_originales) {
		    try {
		    	escribirArchivo("Para la ruta " + (String) ruta_original);
		    	tiempoinicial = calculartiempo(opcion);
		    	Auxiliar.GenerarImagenGrises(ruta_original, ruta_original.replaceAll(".png", "_g.png")); // Genera Grises
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo("Generar Grises: " + Long.toString(ttotal));
		        System.out.println("El tiempo de Generar Grises es en " + ruta_original + " es de " + ttotal);
		        tiempoinicial = calculartiempo(opcion);
		        Auxiliar.GenerarImagenOrdenandoColumnas(ruta_original, ruta_original.replaceAll(".png", "_b.png"), 0); // Usa la burbuja para ordenarla por columnas
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo("Tiempo Burbuja: " + Long.toString(ttotal));
		        System.out.println("El tiempo de Butbuja es en " + ruta_original + " es de " + ttotal);
		        tiempoinicial = calculartiempo(opcion);
		        Auxiliar.GenerarImagenOrdenandoColumnas(ruta_original, ruta_original.replaceAll(".png", "_q.png"), 1);// Usa la quick sort para ordenarla por columnas
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo("Tiempo QuickSort: " + Long.toString(ttotal));
		        System.out.println("El tiempo de QuickSort es en " + ruta_original + " es de " + ttotal);
		        tiempoinicial = calculartiempo(opcion);
		        Auxiliar.ImprimeHistograma(Auxiliar.HistogramaImagen(ruta_original));
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo("Tiempo Histograma: " + Long.toString(ttotal));
		        System.out.println("El tiempo de impresion es en " + ruta_original + " es de " + ttotal);
		    } catch (IOException | InterruptedException e) {
		        e.printStackTrace();
		    }
		    System.out.println("Ejecutado! " + ruta_original);
		    
		}
	}
	
	public static void escribirArchivo(String escribir) {
		try {
            File fichero = new File ("C:\\\\Users\\\\Serrano\\\\eclipse-workspace\\\\HITO1\\\\src\\\\session1\\\\","fichero.csv");
            // Si el archivo no existe es creado
            if (!fichero.exists()) {
            	fichero.createNewFile();
            }
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(escribir + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
	}
	
	
	private static long calculartiempo(int opcion) {
		long tiempo = 0;
		if(opcion == 1) { // NS
			tiempo = System.nanoTime();
		}else {
			tiempo = System.currentTimeMillis();
		
		}
		return tiempo;
	}
	
	 private static int elegiropcion() {
		System.out.println("¿Como desea expresar el tiempo? (1 - NS / 2 - MS)");
		int opcion = leer.entero();
		while(opcion < 1 || opcion > 2) {
			System.out.println("¿Como desea expresar el tiempo? (1 - NS / 2 - MS)");
			opcion = TECLADO.nextInt();
		}
		return opcion;
		
		
	}

}
