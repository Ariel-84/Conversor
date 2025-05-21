import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Conversor {
    public static void main(String[] args) {
        ApiCliente api = new ApiCliente();
        String json = api.obtenerTasas("USD");

        if (json != null) {
            Gson gson = new Gson();

            // Mostramos solo la tasa para ARS (por ejemplo)
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonObject tasas = jsonObject.getAsJsonObject("conversion_rates");

            double tasaARS = tasas.get("ARS").getAsDouble();

            System.out.println("Tasa USD => ARS: " + tasaARS);
        }
    }
}
