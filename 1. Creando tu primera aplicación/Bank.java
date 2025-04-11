import java.util.Scanner;

public class Bank {

    static int option = 0;
    static Scanner sca = new Scanner(System.in);

    // Datos del cliente
    static String name = "Daniel Baena";
    static String tipoCuenta = "Corriente";
    static double saldo = 1000;

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("BIENVENIDO AL BANCO VIRTUAL");
        System.out.println("====================================\n");

        System.out.println("Titular: " + name);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
        System.out.printf("Saldo disponible: $%.2f%n", saldo);

        System.out.println("\n====================================");

        do {
            option = menu();

            switch (option) {
                case 1:
                    mostrarMensaje(consulta());
                    break;
                case 2:
                    System.out.print("\nIngresa la cantidad a retirar: ");
                    double retiro = sca.nextDouble();
                    mostrarMensaje(retirarDinero(retiro));
                    mostrarMensaje(consulta());
                    break;
                case 3:
                    System.out.print("\nIngresa la cantidad a depositar: ");
                    double deposito = sca.nextDouble();
                    mostrarMensaje(depositarDinero(deposito));
                    mostrarMensaje(consulta());
                    break;
                case 4:
                    System.out.println("\n====================================");
                    System.out.println("Gracias por tu visita. ¡Hasta luego!");
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intenta de nuevo.");
            }

        } while (option != 4);

        sca.close(); // Cierra el Scanner al finalizar
    }

    public static int menu() {
        System.out.println("\nMENÚ DE OPCIONES");
        System.out.println("====================================");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("\nIngresa la opción que deseas: ");
        return sca.nextInt();
    }

    public static String consulta() {
        return String.format("Tu saldo actual es de: $%.2f", saldo);
    }

    public static String retirarDinero(double retiro) {
        if (retiro <= 0) {
            return "El monto a retirar debe ser mayor que 0.";
        }
        if (retiro > saldo) {
            return "Fondos insuficientes.";
        }
        saldo -= retiro;
        return "Retiro exitoso.";
    }

    public static String depositarDinero(double deposito) {
        if (deposito <= 0) {
            return "El monto a depositar debe ser mayor que 0.";
        }
        saldo += deposito;
        return "Depósito realizado con éxito.";
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println("\n====================================");
        System.out.println(mensaje);
        System.out.println("====================================");
    }
}
