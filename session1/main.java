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
	private static String ruta = "C:\\\\Users\\\\Serrano\\\\eclipse-workspace\\\\HITO1\\\\src\\\\session1\\\\";
	public static void main(String[] args) {
		int opcion = elegiropcion();
		long tiempoinicial = 0, tiempofinal = 0, ttotal = 0;
		String nombre = "";
		eliminarArchivo();
		List<String> rutas_originales = new ArrayList<>();
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\320x214.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\640x360.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\640x427.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\1024x1024.png");
		rutas_originales.add("C:\\Users\\Serrano\\eclipse-workspace\\HITO1\\src\\session1\\Imagenes\\1536x1536.png");
		


    	escribirArchivo("Imagen; GenImaGrises; Histograma; OrdenadorBurbuja; OrdenadorQuicksort\n");
		for (String ruta_original : rutas_originales) {
		    try {
		    	nombre = ruta_original.replaceAll("C:\\\\Users\\\\Serrano\\\\eclipse-workspace\\\\HITO1\\\\src\\\\session1\\\\Imagenes\\\\", "");
		    	escribirArchivo(nombre + ";");
		    	tiempoinicial = calculartiempo(opcion);
		    	// Generar Grises
		    	Auxiliar.GenerarImagenGrises(ruta_original, ruta_original.replaceAll(".png", "_g.png")); // Genera Grises
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo(Long.toString(ttotal)+ ";");
		        System.out.println("El tiempo de Generar Grises es en " + ruta_original + " es de " + ttotal);
		        //Histograma
		        Auxiliar.ImprimeHistograma(Auxiliar.HistogramaImagen(ruta_original));
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo(Long.toString(ttotal)+ ";");
		        System.out.println("El tiempo de impresion es en " + ruta_original + " es de " + ttotal);
		        tiempoinicial = calculartiempo(opcion);
		        //Burbuja
		        Auxiliar.GenerarImagenOrdenandoColumnas(ruta_original, ruta_original.replaceAll(".png", "_b.png"), 0); // Usa la burbuja para ordenarla por columnas
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo(Long.toString(ttotal)+ ";");
		        System.out.println("El tiempo de Butbuja es en " + ruta_original + " es de " + ttotal);
		        tiempoinicial = calculartiempo(opcion);
		        //Quicksort
		        Auxiliar.GenerarImagenOrdenandoColumnas(ruta_original, ruta_original.replaceAll(".png", "_q.png"), 1);// Usa la quick sort para ordenarla por columnas
		        tiempofinal = calculartiempo(opcion);
		        ttotal = tiempofinal - tiempoinicial;
		        escribirArchivo(Long.toString(ttotal)+ "\n");
		        System.out.println("El tiempo de QuickSort es en " + ruta_original + " es de " + ttotal);
		        tiempoinicial = calculartiempo(opcion);
		    } catch (IOException | InterruptedException e) {
		        e.printStackTrace();
		    }
		    System.out.println("Ejecutado! " + ruta_original);
		    
		}
	}
	
	public static void escribirArchivo(String escribir) {
		try {
            File fichero = new File (ruta,"fichero.csv");
            // Si el archivo no existe es creado
            if (!fichero.exists()) {
            	fichero.createNewFile();
            }
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(escribir);
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
	 private static void eliminarArchivo() {
		 File archivo = new File(ruta + "fichero.csv");
	        
	        if (archivo.delete()) {
	            System.out.println("Archivo eliminado exitosamente.");
	        } else {
	            System.out.println("No se pudo eliminar el archivo.");
	        }
	 }

}
