package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class lectorcsv {
    private String archivo;

    public lectorcsv(String archivo) {
        this.archivo = archivo;
    }

    // Método para contar asentamientos rurales y urbanos
    public int[] contarAsentamientos() {
        int urbanos = 0;
        int rurales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 3) {
                    String tipo = columnas[2].trim();  // Tercera columna: Urbano o Rural
                    if (tipo.equalsIgnoreCase("Urbano")) {
                        urbanos++;
                    } else if (tipo.equalsIgnoreCase("Rural")) {
                        rurales++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new int[]{rurales, urbanos};
    }
}