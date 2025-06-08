import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiCliente api = new ApiCliente();
        Gson gson = new Gson();
        List<String> historial = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        int opcion = 0;

        // Menu.
        while (opcion != 9) {
            System.out.println(
                    "****************************************************\n" +
                            "Sea bienvenido/a al conversor de monedas =]\n\n" +
                            "1) Dólar ==> Peso argentino\n" +
                            "2) Peso argentino ==> Dólar\n" +
                            "3) Dólar ==> Real brasileño\n" +
                            "4) Real brasileño ==> Dólar\n" +
                            "5) Euro ==> Peso argentino\n" +
                            "6) Peso argentino ==> Euro\n" +
                            "7) Peso mexicano ==> Dolar\n" +
                            "8) Mostrar historial \n" +
                            "9) Salir\n\n" +
                            "Elija una opción válida:\n" +
                            "****************************************************"
            );

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 7) {
                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();

                // Inicializamos con null, no tiene valor aún.
                String monedaBase = null;
                String monedaDestino = null;


                // Tipos de cambio.
                switch (opcion) {
                    case 1 -> { monedaBase = "USD"; monedaDestino = "ARS"; }
                    case 2 -> { monedaBase = "ARS"; monedaDestino = "USD"; }
                    case 3 -> { monedaBase = "USD"; monedaDestino = "BRL"; }
                    case 4 -> { monedaBase = "BRL"; monedaDestino = "USD"; }
                    case 5 -> { monedaBase = "EUR"; monedaDestino = "ARS"; }
                    case 6 -> { monedaBase = "ARS"; monedaDestino = "EUR"; }
                    case 7 -> { monedaBase = "MXN"; monedaDestino = "USD"; }
                }

                // Obtiene datos y conversor.
                String json = api.obtenerTasas(monedaBase);
                JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
                JsonObject tasas = jsonObject.getAsJsonObject("conversion_rates");

                double tasa = tasas.get(monedaDestino).getAsDouble();
                double resultado = monto * tasa;

                // Datos del tiempo y registro.
                String tiempo = LocalDateTime.now().format(formatter);
                String registro = String.format("[%s] %.2f %s => %.2f %s", tiempo, monto, monedaBase, resultado, monedaDestino);
                historial.add(registro);

                System.out.println("Resultado: " + monto + " " + monedaBase + " = " + resultado + " " + monedaDestino);

            }  else if (opcion == 8) {
                System.out.println("\n Historial de conversiones:");
                if (historial.isEmpty()) {
                    System.out.println("Aún no se han realizado conversiones.");
                } else {
                    historial.forEach(System.out::println);
                }
            }
            else if (opcion != 9) {
                System.out.println("Opción no válida. Por favor, elija entre 1 y 8 o 9 para salir.");
            }
        }

        System.out.println("¡Gracias por usar el conversor!");
        scanner.close();
    }
}

