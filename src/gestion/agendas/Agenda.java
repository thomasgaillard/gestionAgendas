// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.agendas;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Agenda {
	//attributes
	private String nom;
	private ArrayList<Evenement> evenements;

	//constructor
	public Agenda() {
	}
	
	public Agenda(String unNom) {
		this.setNom(unNom);
		this.evenements = new ArrayList<Evenement>();
	}

	//getters
	public String getNom() {
		return this.nom;
	}
	
	public ArrayList<Evenement> getEvenements() {
		return this.evenements;
	}

	//setters
	public void setNom(String nom) {
		this.nom = nom;
	}

	//methods
	public void ajouter(Evenement unEvt) {
		this.evenements.add(unEvt);
		unEvt.setAgenda(this);
	}
	
	public void supprimer(Evenement unEvt) {
		this.evenements.remove(unEvt);
	}
	
	public String toString() {
		String ret = this.getNom() + "\n";
		for(Evenement evt: this.evenements){
			ret += evt.toString();
		}
		return ret;
	}
	
	public void exportIcs(){
		try{
			PrintWriter out  = new PrintWriter(new FileWriter(this.getNom() + ".ics"));
			out.println("BEGIN:VCALENDAR\nMETHOD:PUBLISH\nVERSION:2.0\nX-WR-CALNAME:"+this.getNom());
			for(Evenement evt: this.evenements){
				out.println("BEGIN:VEVENT");
				out.println("DTEND;TZID=Europe/Paris:"+evt.formatterDate(evt.getDateHeureFin()));
				out.println("SUMMARY:"+evt.getNom());
				if(evt.getLieu() != "")
					out.println("LOCATION:"+evt.getLieu());
				out.println("DTSTART;TZID=Europe/Paris:"+evt.formatterDate(evt.getDateHeureDebut()));
				out.println("END:VEVENT");
			}
			out.println("END:VCALENDAR");
			out.close();
		}
		catch(Exception e){
	      e.printStackTrace();
	    }
	}
}