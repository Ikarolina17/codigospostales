package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EncontrarCodigo {
    private static final String archivo = "C:/Users/IrlaK/OneDrive - Universidad de Sonora/Documentos/UNISON/Vscode/git repositorio/codigospostales/codigos_postales.csv";

    public static void main(String[] args) {
        // Crear un mapa con códigos postales y asentamientos
        Map<String, String> codigosPostales = cargarCodigosPostales(archivo);

        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese los códigos postales separados por espacios (o 'salir' para terminar):");

        // Leer los códigos postales del usuario
        while (true) {
            System.out.print("Códigos Postales: ");
            String entrada = scanner.nextLine();

            // Verificar si el usuario quiere salir
            if (entrada.equalsIgnoreCase("salir")) {
                break;
            }

            // Dividir la entrada en códigos postales individuales
            String[] codigos = entrada.split("\\s+");

            // Buscar los asentamientos correspondientes a los códigos postales ingresados
            for (String codigo : codigos) {
                String asentamiento = codigosPostales.get(codigo.trim());
                if (asentamiento != null) {
                    System.out.println("Código Postal: " + codigo + " - Asentamiento: " + asentamiento);
                } else {
                    System.out.println("Código Postal: " + codigo + " no encontrado.");
                }
            }
        }

        // Cerrar el escáner
        scanner.close();
        System.out.println("Programa terminado.");
    }

    // Método para cargar códigos postales y asentamientos desde el archivo CSV
    private static Map<String, String> cargarCodigosPostales(String archivo) {
        Map<String, String> codigosPostales = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 2) {
                    String codigoPostal = columnas[0].trim();  // Primera columna: Código Postal
                    String asentamiento = columnas[2].trim();  // Segunda columna: Asentamiento
                    codigosPostales.put(codigoPostal, asentamiento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return codigosPostales;
    }
}
