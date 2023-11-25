import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JuegoCachipun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion; int x;

        do {
            menu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                do {
                    ComputadorVsComputador();
                    System.out.println("Si desea repetir el juego oprima 5, para volver al menú oprima 0 ");
                    x = scanner.nextInt();
                } while (x==5);
                break;

                case 2:
                do {
                    ComputadorVsHumano();
                    System.out.println("Si desea repetir el juego oprima 5, para volver al menú oprima 0 ");
                    x = scanner.nextInt();
                } while (x==5);
                break;

                case 3:
                do {
                    HumanoVsHumano();;
                    System.out.println("Si desea repetir el juego oprima 5, para volver al menú oprima 0 ");
                    x = scanner.nextInt();
                } while (x==5);
                break;
                
                case 4:
                    System.out.println("Juego terminado");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 4);
        scanner.close();
    }

    public static void ComputadorVsComputador() {
        System.out.println(" \nComputador vs Computador");
        Cachipun Computador1 = new Cachipun(true); 
        Cachipun Computador2 = new Cachipun(true); 
        Ganador(Computador1, Computador2);
    }

    public static void ComputadorVsHumano() {
        System.out.println(" \nComputador vs Humano");
        Cachipun jugador2 = new Cachipun(false); 
        Cachipun Computador1 = new Cachipun(true);
        Ganador(jugador2, Computador1);
    }

    public static void HumanoVsHumano() {
        System.out.println(" \nHumano vs Humano");
        Cachipun jugador1 = new Cachipun(false); 
        Cachipun jugador2 = new Cachipun(false); 
        Ganador(jugador1, jugador2);
    }

    public static void Ganador(Cachipun jugador1, Cachipun jugador2) {
        System.out.println("Jugador 1: " + jugador1.getTurno());
        System.out.println("Jugador 2: " + jugador2.getTurno());

        int resultado = jugador1.comparar(jugador2);

        if (resultado == 0) {
            System.out.println("Empate");
        } else if (resultado > 0) {
            System.out.println("El ganador es el jugador 1");
        } else if (resultado < 0){
            System.out.println("El ganador es el jugador 2");
        }

        guardarResultado(jugador1, jugador2, resultado);
    }

    private static void guardarResultado(Cachipun jugador1, Cachipun jugador2, int resultado) {

        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fecha = data.format(formato);

        File archivo = new File("resultados.txt");
        PrintWriter output = null;
        try{
            output = new PrintWriter(new FileWriter(archivo, true));
            output.println("Fecha y hora: " + fecha);
            output.println("Jugador 1: " + jugador1.getTurno());
            output.println("Jugador 2: " + jugador2.getTurno());

            if (resultado == 0) {
                output.println("Resultado: Empate");
            } else if (resultado > 0) {
                output.println("Resultado: Jugador 1 gana");
            } else {
                output.println("Resultado: Jugador 2 gana");
            }
            output.println("------------------------------");

            System.out.println("Resultado guardado en el archivo.");
          }catch(Exception s){
            System.out.println(s.getMessage());
          }
          finally{
            if(output != null)
              output.close();
          }
     
    }

    public static void menu(){
        System.out.println("Menú:");
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1. Computador vs Computador");
        System.out.println("2. Computador vs Humano");
        System.out.println("3. Humano vs Humano");
        System.out.println("4. Terminar el juego");
        System.out.print("Seleccione una opción: ");     
    }
}
