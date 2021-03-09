package it.polito.tdp.librettovoti.model;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
	}

	public void add(Voto v) {
		if(ricercaCorso(v.getNome()) == null)
			this.voti.add(v);
	}
	
	/*public boolean contiene(Voto v) {
		for(Voto vi : voti) {
			if(vi.getNome().equals(v.getNome()) && vi.getVoto()==v.getVoto())
				return true;
		}
		return false;
	}*/
	
	public String toString() {
		String s = "";
		for(Voto vi : voti) {
			s += vi.toString()+"\n";
		}
		return s;
	}
	
	public List<Voto> listaVotiUguali(int punteggio){
		List<Voto> risultato = new ArrayList<>();
		for(Voto vi : this.voti) {
			if(vi.getVoto()==punteggio) {
				risultato.add(vi);
			}
		}
		return risultato;
	}
	
	public Libretto votiUguali(int punteggio){
		Libretto risultato = new Libretto();
		for(Voto vi : this.voti) {
			if(vi.getVoto()==punteggio) {
				risultato.add(vi);
			}
		}
		return risultato;
	}
	
	/**
	 * ricerca di un corso per nome
	 * Se il corso non esiste, restituisce null
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		Voto risultato = null;
		for(Voto vi : this.voti) {
			if(vi.getNome().equals(nomeCorso)) {
				risultato = vi;
				break;
			}
		}
		return risultato;
	}
	
	public String esiste(String corso, int voto) {
		String s = "Corso non esistente";
		if(ricercaCorso(corso)!=null && ricercaCorso(corso).getVoto()==voto) {
			s = "Valutazione esistente nel libretto con stesso voto";
		}
		if(ricercaCorso(corso)!=null && ricercaCorso(corso).getVoto()!=voto) {
			s = "Conflitto! Valutazione esistente nel libretto con diverso voto";
		}
		return s;
	}
	
	public Libretto librettoMigliorato() {
		Libretto lM = new Libretto();
		for(Voto vi : this.voti) {
			if(vi.getVoto()>=18 && vi.getVoto()<24)
				lM.add(new Voto(vi.getNome(), vi.getVoto()+1, vi.getData()));
			else if(vi.getVoto()>=24 && vi.getVoto()<29)
				lM.add(new Voto(vi.getNome(), vi.getVoto()+2, vi.getData()));
			else
				lM.add(new Voto(vi.getNome(), 30, vi.getData()));
		}
		return lM;
	}
	
	/*public String ordina() {
		Collections.comparing
	}*/
}
