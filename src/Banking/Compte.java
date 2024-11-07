package Banking;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Compte {
private int NumCompte;
private LocalDate datecreation;
private LocalDate dateupdate;
private String Devise;
private Client client;
private List<Transaction> Transaction;
private Banque banque;
public Compte (@JsonProperty("numCompte")int numcompte,@JsonProperty("datecrea")LocalDate datecrea,@JsonProperty("Devise")String Devise,@JsonProperty("client")Client client,@JsonProperty("b")Banque b) {
	this.NumCompte=numcompte;
	this.datecreation=datecrea;
	this.dateupdate=datecrea;
	this.Devise=Devise;
	this.client=client;
	this.Transaction=new ArrayList<>();
	this.banque=b;
	 client.AjouterCompte(this);
	}
public Client getproprietaire() {
	return client;
}
public Banque getBanque() {
    return banque;
}

public void Ajoutertransaction(Transaction transaction) {
	if(!Transaction.contains(transaction)) {
		Transaction.add(transaction);}
	
}
@Override
public String toString() {
    return "Compte{" + "numCompte=" + NumCompte + ", devise='" + Devise + '\'' + '}';
}
public String toJson() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(this);
}

}
