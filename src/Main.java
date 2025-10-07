import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            welcome();
            System.out.print("ESCOGE UNA OPCIÓN: ");
            option = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.print("Nombre del archivo: ");
                    String nombreArchivo = sc.nextLine();
                    System.out.print("Contenido del texto: ");
                    String contenidoArchivo = sc.nextLine();

                    writeFile(nombreArchivo, contenidoArchivo);
                    break;

                case 2:
                    System.out.println("Nombre del archivo)");
                    String archivoLeer = sc.nextLine();
                    readFile(archivoLeer);

                    break;

                case 3:
                    System.out.print("Nombre del archivo a borrar: ");
                    String borrarArchivo = sc.nextLine();
                    deleteFile(borrarArchivo);
                    break;


                case 4:
                    System.out.println("Función para listar ficheros (pendiente)");
                    break;

                case 5:
                    System.out.println("Función para establecer directorio (pendiente)");
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción incorrecta. Intenta de nuevo.");
            }

        } while (option != 0);

        sc.close();
        System.out.println("Programa finalizado.");
    }

    public static void writeFile(String fileName, String message) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(message);
            System.out.println("Archivo '" + fileName + "' escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }
    }
    public static void readFile(String fileName) {
        File archivo = new File(fileName);

        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            System.out.println("Contenido del archivo '" + fileName + "':");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public static void deleteFile(String filename) {
        File archivo = new File(filename);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("El archivo '" + filename + "' se ha borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el archivo '" + filename + "'.");
            }
        } else {
            System.out.println("El archivo '" + filename + "' no se ha encontrado.");
        }
    }

    public static void directorio {}





    public static void welcome() {
        System.out.println();
        System.out.println("############ Writer ############");
        System.out.println("################################");
        System.out.println("1 . Escribir en un archivo");
        System.out.println("2 . Leer un archivo");
        System.out.println("3 . Borrar un archivo");
        System.out.println("4 . Listar ficheros de un directorio");
        System.out.println("5 . Establecer directorio de trabajo");
        System.out.println("0 . Salir");
        System.out.println("################################");
    }
}
