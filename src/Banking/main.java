package Banking;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) throws Exception {
        // Création d'exemple
        Banque banque1 = new Banque(1, "Maroc");
        Client client1 = new Client(100, "Ahmed", "Belaid", "adresse1", "email1@example.com", "0612345678");
        String clientJson = client1.toJson();
        System.out.println("Client JSON: " + clientJson);

    }
}

