// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.agendas;

import java.util.GregorianCalendar;

public class Evenement {

	//attributes
	private GregorianCalendar dateHeure;
	private String nom;
	private String lieu;
	private Agenda agenda;

	//getters
	public GregorianCalendar getDateHeure() {
		return this.dateHeure;
	}
	public String getNom() {
		return this.nom;
	}
	public String getLieu() {
		return this.lieu;
	}
	public Agenda getAgenda() {
		return this.agenda;
	}
	
	//setters
	public void setDateHeure(GregorianCalendar dateHeure) {
		this.dateHeure = dateHeure;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	//methods
	public void deplacerAgenda(Agenda agenda){
		
	}
	
}
