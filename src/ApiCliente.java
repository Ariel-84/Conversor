import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCliente {
    private static final String API_KEY = "d6ab6dd8a714614b72466e73";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public String obtenerTasas(String base) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + API_KEY + "/latest/" + base))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificamos el código de estado.
            if (response.statusCode() == 200) {
                return response.body(); // Devuelve el JSON
            } else {
                System.out.println("Error HTTP: " + response.statusCode());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la solicitud: " + e.getMessage());
            return null;
        }
    }
}
