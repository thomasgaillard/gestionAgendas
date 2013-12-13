// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.agendas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Evenement {
	//attributes
	private GregorianCalendar dateHeureDebut;
	private GregorianCalendar dateHeureFin;
	private String nom;
	private String lieu;
	private Agenda agenda;
	
	//constructors
	public Evenement(){
		this.setNom("Mon événement");
		this.setLieu("");
		this.setDateHeureDebut(new GregorianCalendar(TimeZone.getTimeZone("Europe/Paris")));
		this.setDateHeureFin(new GregorianCalendar());
	}
	
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
		if(uneDateHeureDebut.after(this.getDateHeureFin()))
			this.dateHeureFin = uneDateHeureDebut;
	}
	
	public void setDateHeureFin(GregorianCalendar uneDateHeureFin) {
		if(uneDateHeureFin.after(this.getDateHeureDebut()))
			this.dateHeureFin = uneDateHeureFin;
		else
			this.dateHeureFin = this.getDateHeureDebut();
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
	
	public String formatterDate(GregorianCalendar date){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		java.util.Date theDate = date.getTime();
		return dateFormat.format(theDate);
	}
	
	public String toString(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		java.util.Date dateDebut = this.getDateHeureDebut().getTime();
		java.util.Date dateFin = this.getDateHeureFin().getTime();
		return(this.getNom()+" de l'agenda "+this.getAgenda().getNom()+" : du "+dateFormat.format(dateDebut)+" au "+dateFormat.format(dateFin)+"  à "+this.getLieu()+"\n");
	}
}
