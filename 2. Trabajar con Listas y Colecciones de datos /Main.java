import com.java.listas.colecciones.models.CreditCard;
import com.java.listas.colecciones.models.Purchase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        CreditCard creditCard = new CreditCard(1000, "Baena");

        System.out.println("💳-------------------------------💳");
        System.out.println("¡Bienvenido/a, " + creditCard.getTitular() + "!");
        System.out.println("Tu limite es: " + creditCard.getLimitCredit());
        System.out.println("💳-------------------------------💳");

        int option;

        do {
            System.out.println("\n-------------------------------");
            System.out.println("📋 MENÚ DE OPCIONES 📋");
            System.out.println("1️⃣  Realizar una compra");
            System.out.println("2️⃣  Revisar mi saldo");
            System.out.println("3️⃣  Salir");
            System.out.println("-------------------------------");
            System.out.print("\n👉 Ingresa tu opción: ");
            option = sca.nextInt();


            switch (option) {
                case 1:
                    Purchase purchase = new Purchase();
                    System.out.println("\n🛒----- NUEVA COMPRA -----🛒");

                    sca.nextLine();
                    System.out.print("📦 Nombre del producto: ");
                    String name = sca.nextLine();

                    System.out.print("💰 Precio del producto: ");
                    double price = sca.nextDouble();

                    purchase.setName(name);
                    purchase.setPrice(price);

                    int done = creditCard.buy(purchase);

                    if (done == 1) {
                        System.out.println("-------------------------------");
                        System.out.println("\n✅ ¡Compra realizada con éxito!");
                        System.out.println("🧾 Producto: " + name);
                        System.out.println("💲 Precio: $" + String.format("%.2f", price));
                    }
                    else if (done == 0){
                        System.out.println("-------------------------------");
                        System.out.println("❌ Compra rechazada: El precio es negativo? Enserio?.");
                        System.out.println("-------------------------------");


                    }
                    else {
                        System.out.println("-------------------------------");
                        System.out.println("❌ Compra rechazada: excede el límite de crédito.");
                        System.out.println("-------------------------------");

                    }

                    break;

                case 2:
                    System.out.println("\n💼----- ESTADO DE CUENTA -----💼");
                    System.out.println("\n👤 Titular: " + creditCard.getTitular());
                    System.out.println("💳 Crédito disponible: $" + creditCard.getBalance());
                    System.out.println("🛍️ Total de compras: " + creditCard.getPurchasesList().size());
                    break;

                case 3:
                    System.out.print("-- ¿Estás segur@ que deseas salir? (S/N): ");
                    sca.nextLine();
                    String confirm = sca.nextLine().trim().toUpperCase();
                    if (!confirm.equals("S")) {
                        option = 0;
                        continue;
                    }

                    System.out.println("-------------------------------");

                    System.out.println("\n👋 ¡Gracias por tu visita, " + creditCard.getTitular() + "!");
                    System.out.println("\n🧾 Historial de compras:");
                    int count = 1;
                    for (Purchase p : creditCard.getPurchasesList()) {
                        System.out.println("🧾 " + count + " " + p.getName() + " -> $" + p.getPrice());
                        count++;
                    }
                    System.out.println("💳 Crédito final disponible: $" + String.format("%.2f", creditCard.getBalance()));
                    System.out.println("\nHasta pronto ✨");
                    System.out.println("-------------------------------");

                    break;

                default:
                    System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
                    break;
            }

        } while (option != 3);
    }
}
