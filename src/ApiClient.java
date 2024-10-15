import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.Scanner;

public class ApiClient {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    public static void main(String[] args) {
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir la respuesta en formato JSON
            System.out.println(response.body());

            // Parsear la respuesta JSON a objeto usando Gson
            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);
            Scanner scanner = new Scanner(System.in);

            // Acceder a los datos del objeto
            System.out.println("1) Dolar a peso argentino");
            System.out.println("2) Dolar a Real brasileño");
            System.out.println("3) Dolar a Peso colombiano");
            System.out.println("4) Dolar a Peso mexicano");

            System.out.println("Ingrese una opcion");
            int i= scanner.nextInt();
          switch (i){
                case 1:
                    System.out.println("1) Dolar a peso argentino");
                    System.out.println("Ingrese la cantidad de USD: ");
                    double usd=scanner.nextInt();
                    double cambio= apiResponse.getRates().get("ARS");
                    System.out.println("Tasa de cambio USD: "+usd+"-> Peso argentino: " +(usd*cambio));
                    break;

              case 2:
                  System.out.println("1) Dolar a peso argentino");
                  System.out.println("Ingrese la cantidad de USD: ");
                  usd=scanner.nextInt();
                  cambio= apiResponse.getRates().get("BRL");
                  System.out.println("Tasa de cambio USD: "+"-> Real brasileño: " + usd*cambio);
                  break;
              case 3:
                  System.out.println("1) Dolar a peso argentino");
                  System.out.println("Ingrese la cantidad de USD: ");
                  usd=scanner.nextInt();
                  cambio= apiResponse.getRates().get("COP");
                  System.out.println("Tasa de cambio USD: "+"-> Peso colombiano: " + usd*cambio);
                  break;
              case 4:
                  System.out.println("1) Dolar a peso argentino");
                  System.out.println("Ingrese la cantidad de USD: ");
                  usd=scanner.nextInt();
                  cambio= apiResponse.getRates().get("ARS");
                  System.out.println("Tasa de cambio USD: "+"-> Peso mexicano: " + usd*cambio);
                  break;



          }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
