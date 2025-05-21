public class Conversor {
    public static void main(String[] args) {
        ApiCliente api = new ApiCliente();
        String json = api.obtenerTasas("USD");

        if (json != null) {
            System.out.println("Respuesta JSON de la API:");
            System.out.println(json);
        } else {
            System.out.println("No se pudo obtener la respuesta.");
        }
    }
}
