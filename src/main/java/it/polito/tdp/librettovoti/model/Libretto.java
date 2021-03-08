package it.polito.tdp.librettovoti.model;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
	}

	public void add(Voto v) {
		this.voti.add(v);
	}
	
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
}
