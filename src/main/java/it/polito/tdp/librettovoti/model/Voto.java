package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

// POJO - Plain Old Java Object
// Java Bean
// Semplice contenitore di dati -- non ha "logica"

/**
 * Memorizza il risultato di un esame singolo
 * @author admin
 *
 */
public class Voto implements Comparable{
	
	private String nome;
	private int voto; //30L come lo rappresento?
	private LocalDate data; //data superamento esame
	
	/**
	 * Costruttore della classe voto
	 * @param nome
	 * @param voto
	 * @param data
	 */
	public Voto(String nome, int voto, LocalDate data) {
		super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Esame "+this.getNome()+" superato con "+this.getVoto()+" il "+this.getData();
	}

	@Override
	public int compareTo(Object arg0) {
		Voto altro = (Voto) arg0;
		return this.getNome().compareTo(altro.getNome());
	}

	
	
	

}
