import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiCliente api = new ApiCliente();
        Gson gson = new Gson();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println(
                    "****************************************************\n" +
                            "Sea bienvenido/a al conversor de monedas =]\n\n" +
                            "1) Dólar ==> Peso argentino\n" +
                            "2) Peso argentino ==> Dólar\n" +
                            "3) Dólar ==> Real brasileño\n" +
                            "4) Real brasileño ==> Dólar\n" +
                            "7) Salir\n\n" +
                            "Elija una opción válida:\n" +
                            "****************************************************"
            );

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();

                // Inicializamos con null para que sea claro que no tiene valor aún
                String monedaBase = null;
                String monedaDestino = null;

                switch (opcion) {
                    case 1 -> { monedaBase = "USD"; monedaDestino = "ARS"; }
                    case 2 -> { monedaBase = "ARS"; monedaDestino = "USD"; }
                    case 3 -> { monedaBase = "USD"; monedaDestino = "BRL"; }
                    case 4 -> { monedaBase = "BRL"; monedaDestino = "USD"; }
                }

                String json = api.obtenerTasas(monedaBase);
                JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
                JsonObject tasas = jsonObject.getAsJsonObject("conversion_rates");

                double tasa = tasas.get(monedaDestino).getAsDouble();
                double resultado = monto * tasa;
                System.out.println("Resultado: " + monto + " " + monedaBase + " = " + resultado + " " + monedaDestino);


            } else if (opcion != 7) {
                System.out.println("Opción no válida. Por favor, elija entre 1 y 4 o 7 para salir.");
            }
        }

        System.out.println("¡Gracias por usar el conversor!");
        scanner.close();
    }
}

