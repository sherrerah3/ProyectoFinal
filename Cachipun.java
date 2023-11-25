import java.util.Random;
import java.util.Scanner;

public class Cachipun {
    private String turno; 
    private boolean automatico; 

    public Cachipun(boolean automatico) {
        if (automatico) {
            turnoAutomatico();
        } else {
            turnoHumano();
        }
    }

    public String getTurno() {
        return turno;
    }

    private void turnoAutomatico() {
        Random random = new Random();
        int numero = random.nextInt(3) + 1 ; 

        switch (numero) {
            case 1:
                turno = "Piedra";
                break;
            case 2:
                turno = "Papel";
                break;
            case 3:
                turno = "Tijera";
                break;
        }
    }

    private void turnoHumano() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese A para Piedra, B para Papel, C para Tijera: ");
        char opc = scanner.next().toUpperCase().charAt(0);
        
        switch (opc) {
            case 'A':
                turno = "Piedra";
                break;
            case 'B':
                turno = "Papel";
                break;
            case 'C':
                turno = "Tijera";
                break;
            default:
                System.out.println("Opción no válida");
        }

        // Verificar entrada
        while (opc != 'A' && opc != 'B' && opc != 'C' ) {
            System.out.println("Inténtelo de nuevo.");
            System.out.print("Ingrese A para Piedra, B para Papel, C para Tijera: ");
            opc = scanner.next().toUpperCase().charAt(0);
            switch (opc) {
                case 'A':
                    turno = "Piedra";
                    break;
                case 'B':
                    turno = "Papel";
                    break;
                case 'C':
                    turno = "Tijera";
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public int comparar(Cachipun otro) {  
        if (this.turno.equalsIgnoreCase(otro.turno)) {
            return 0; // Empate
        } else if ((this.turno.equalsIgnoreCase("Piedra") && otro.turno.equalsIgnoreCase("Tijera"))
                || (this.turno.equalsIgnoreCase("Tijera") && otro.turno.equalsIgnoreCase("Papel"))
                || (this.turno.equalsIgnoreCase("Papel") && otro.turno.equalsIgnoreCase("Piedra"))) {
            return 1; // Este gana
        } else {
            return -1; // Otro gana
        }
    }
}
