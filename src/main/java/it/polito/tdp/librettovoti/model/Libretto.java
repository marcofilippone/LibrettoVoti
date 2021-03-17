package it.polito.tdp.librettovoti.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.*;

public class Libretto {
	
	private List<Voto> voti;
	private Map<String, Voto> votiMap; // identity map: nome esame->oggetto Voto
	
	public Libretto() {
		this.voti = new ArrayList<>();
		this.votiMap = new HashMap<String, Voto>();
	}

	public void add(Voto v) {
		if(ricercaCorso(v.getNome()) == null) {
			this.voti.add(v);
			this.votiMap.put(v.getNome(), v);
		}
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
		/*Voto risultato = null;
		for(Voto vi : this.voti) {
			if(vi.getNome().equals(nomeCorso)) {
				risultato = vi;
				break;
			}
		}
		return risultato;*/
		return this.votiMap.get(nomeCorso);
	}
	
	public boolean esisteDuplicato(Voto v) {
		/*boolean trovato = false;
		for(Voto vi : this.voti) {
			if(vi.getNome().equals(v.getNome()) && vi.getVoto()==v.getVoto() && vi.getData().isEqual(v.getData())) {
				trovato = true;
				break;
			}
		}
		return trovato;*/
		
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()==v.getVoto())
			return true;
		else
			return false;
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
	
	
	public void ordina() {
		Comparator<Voto> comp = comparing(Voto::getNome).thenComparing(Voto::getVoto, reverseOrder());
		Collections.sort(voti, comp);
	}
	
	public Libretto remove(int p) {
		Libretto lDep = new Libretto();
		for(Voto vi : voti) {
			if(vi.getVoto()>=p) {
				lDep.add(vi);
			}
		}
		return lDep;
	}
}
