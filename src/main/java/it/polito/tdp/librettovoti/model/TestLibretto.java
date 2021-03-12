package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {
	
	public static void main(String[] args) {
	
		System.out.println("Test metodi di Libretto");
	Libretto libretto = new Libretto();
	
	Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
	
	libretto.add(voto1);
	libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)));
	libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 7, 15)));
	libretto.add(new Voto("Chimica", 18, LocalDate.of(2019, 7, 15)));
	
	System.out.println(libretto.toString());
	
	List<Voto> venticinque = libretto.listaVotiUguali(25);
	System.out.println(venticinque);
	
	Libretto lib25 = libretto.votiUguali(25);
	System.out.println(lib25);
	
	System.out.println("3) "+libretto.ricercaCorso("Informatica").toString());
	
	Voto v = new Voto("Chimica", 25, LocalDate.of(2019, 7, 15));
	System.out.println("4-5) "+libretto.esiste("Chimica", 24));
	
	System.out.println("7)\n"+libretto.toString()+"\n"+libretto.librettoMigliorato());

	libretto.ordina();
	System.out.println("8) Libretto ordinato\n"+libretto.toString()+"\n");
	
	System.out.println("9) Libretto senza voti bassi\n"+libretto.remove(24).toString()+"\n");
	}

}
