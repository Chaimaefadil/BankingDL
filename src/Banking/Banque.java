package Banking;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Banque {
	private int id;
	private String pays;
	private List<Compte> Accounts;
	private List <Client> Clients;

	public Banque(int id,String pays) {
		this.id=id;this.pays=pays;
		this.Accounts= new ArrayList<>();
		this.Clients=new ArrayList<>();
		}
	public void  AjouterCompte(Compte c) {
		if(!Accounts.contains(c)) {
			Accounts.add(c);
		}
  }
	public void AjouterClient(Client client) {
		if(!Clients.contains(client)) {
			Clients.add(client);}
		
	}
	public Client RechercherClient(int numclient) {
		for(Client clients:Clients) {
			if(clients.getNumClient()==numclient) {
				return clients;
				
			}
			
		}
		return null;
		
	}
	 @Override
	    public String toString() {
	        return "Banque{" + "id=" + id + ", pays='" + pays + '\'' + '}';
	    }
	

}
