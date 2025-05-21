public class Conversor {

    public static void main(String[] args) {
        ApiCliente api = new ApiCliente();
        String json = api.obtenerTasas("USD"); // Base USD

        System.out.println("Respuesta de la API:");
        System.out.println(json);
    }

}
