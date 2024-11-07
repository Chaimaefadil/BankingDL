package Banking;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

public class Client {
    private int num;
	private String Nom;
	private String prenom;
	private String adresse;
	private String email;
	private String phone;
	private String pays;
	private List<Compte> Accounts;
	
	
public Client(@JsonProperty("num")int num,@JsonProperty("Nom")String Nom,@JsonProperty("prenom")String prenom,@JsonProperty("adresse")String adresse,@JsonProperty("email")String email,@JsonProperty("phone") String phone) {
		this.num=num;
		this.Nom=Nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.email=email;
		this.phone=phone;
		this.Accounts=new ArrayList<>();
		
	}
	public int getNumClient() {
		return num;
	}
	public String getpays() {
		return pays;
	}
	 public void AjouterCompte(Compte compte) {
	        if (!Accounts.contains(compte)) {
	            Accounts.add(compte);
	        }
	    }
	 @Override
	    public String toString() {
	        return "Client{" +
	                "numClient=" + num +
	                ", nom='" + Nom + '\'' +
	                ", prenom='" + prenom + '\'' +
	                ", adresse='" + adresse + '\'' +
	                ", email='" + email + '\'' +
	                ", phone='" + phone + '\'' +
	                '}';
	    }
	 public String toJson() throws Exception {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(this);
	    }

}
