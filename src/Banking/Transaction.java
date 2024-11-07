package Banking;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
public class Transaction {
	public enum TypeTransaction{
		VIRINT,VIREST,VIRMULTIA,VIRCHAC;
		
	}
	private TypeTransaction type;
	private String Reference;
	private LocalDateTime timestamp;
	private List<Compte> Accounts;
	  
	  public Transaction (@JsonProperty("reference")String reference,@JsonProperty("timeStamp")LocalDateTime timestamp,@JsonProperty("comptes") List<Compte> comptes) {
		  this.Reference=reference;
		  this.timestamp=timestamp;
		  this.Accounts=new ArrayList<>();
		  AjouterCompte(comptes.get(0));
		  AjouterCompte(comptes.get(0));
		  this.type=CalculerTypeTransaction(comptes.get(0), comptes.get(1));
		  
		  
		  }
	  public void  AjouterCompte(Compte c) {
			if(!Accounts.contains(c)) {
				Accounts.add(c);
				c.Ajoutertransaction(this);
			}
	  }
	  public TypeTransaction CalculerTypeTransaction(Compte c1,Compte c2) {
		  boolean memeBanque = c1.getBanque().equals(c2.getBanque());
	        boolean memePays = c1.getproprietaire().getpays().equals(c2.getproprietaire().getpays());

	        if (memeBanque && memePays) {
	            return TypeTransaction.VIRINT;
	        } else if (!memeBanque && !memePays) {
	            return TypeTransaction.VIRCHAC;
	        } else if (memeBanque) {
	            return TypeTransaction.VIRMULTIA;
	        } else {
	            return TypeTransaction.VIREST;
	        }
	  }
	  @Override
	    public String toString() {
	        return "Transaction{" + "type=" + type + ", reference='" + Reference + '\'' + '}';
	    }
	    public String toJson() throws Exception {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(this);
	    }
	  

}
