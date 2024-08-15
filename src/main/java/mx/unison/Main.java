package mx.unison;

public class Main {
    public static void main(String[] args) {
        // Ruta al archivo CSV
        String archivo = "C:/Users/IrlaK/OneDrive - Universidad de Sonora/Documentos/UNISON/Vscode/git repositorio/codigospostales/codigos_postales.csv";
        
        // Crear una instancia de LectorCSV
        lectorcsv lector = new lectorcsv(archivo);

        // Contar los asentamientos rurales y urbanos
        int[] cuenta = lector.contarAsentamientos();
        System.out.println("Rurales = " + cuenta[0]);
        System.out.println("Urbanos = " + cuenta[1]);
    }
}
