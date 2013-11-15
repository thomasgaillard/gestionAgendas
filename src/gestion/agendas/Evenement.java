// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.agendas;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Evenement {

	//attributes
	private GregorianCalendar dateHeureDebut;
	private GregorianCalendar dateHeureFin;
	
	

	private String nom;
	private String lieu;
	private Agenda agenda;
	
	//getters
	public GregorianCalendar getDateHeureDebut() {
		return this.dateHeureDebut;
	}
	public GregorianCalendar getDateHeureFin() {
		return dateHeureFin;
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
	public void setDateHeureDebut(GregorianCalendar uneDateHeureDebut) {
		this.dateHeureDebut = uneDateHeureDebut;
	}
	public void setDateHeureFin(GregorianCalendar uneDateHeureFin) {
		if(this.getDateHeureDebut()!=null && uneDateHeureFin.after(this.getDateHeureDebut()))
			this.dateHeureFin = uneDateHeureFin;
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
	public void changerAgenda(Agenda agenda) {
		this.getAgenda().supprimer(this);
		agenda.ajouter(this);
	}
	
	public void afficherEvenement(){
		System.out.println(this.getNom()+" de l'agenda "+this.getAgenda().getNom()+" : le "+this.getDateHeureDebut().get(Calendar.DAY_OF_MONTH)+"/"+this.getDateHeureDebut().get(Calendar.MONTH)+"/"+this.getDateHeureDebut().get(Calendar.YEAR)+" "+this.getDateHeureDebut().get(Calendar.HOUR_OF_DAY)+":"+this.getDateHeureDebut().get(Calendar.MINUTE)+", ˆ "+this.getLieu());
	}

}
