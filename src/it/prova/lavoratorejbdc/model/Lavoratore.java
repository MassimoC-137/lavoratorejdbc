package it.prova.lavoratorejbdc.model;

import java.util.Date;

public class Lavoratore {

	private int idlavoratore;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private int ral;

	public Lavoratore() {

	}

	public Lavoratore(int idlavoratore, String nome, String cognome, Date dataDiNascita, int ral) {
		this.idlavoratore = idlavoratore;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.ral = ral;
	}

	public int getIdlavoratore() {
		return idlavoratore;
	}

	public void setIdlavoratore(int idlavoratore) {
		this.idlavoratore = idlavoratore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public int getRal() {
		return ral;
	}

	public void setRal(int ral) {
		this.ral = ral;
	}

	@Override
	public String toString() {
		return "Lavoratore [idlavoratore=" + idlavoratore + ", nome=" + nome + ", cognome=" + cognome
				+ ", dataDiNascita=" + dataDiNascita + ", ral=" + ral + "]";
	}
	
	
	
	
}
