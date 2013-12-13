// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.calendrier;

import gestion.agendas.Agenda;
import gestion.agendas.Evenement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Calendrier {
	//attributes
	private ArrayList<Agenda> agendas;

	//constructor
	public Calendrier() {
		this.setAgendas(new ArrayList<Agenda>());
	}
	
	//methods
	public void ajouter(Agenda unAgenda) {
		this.getAgendas().add(unAgenda);
	}
	
	public void supprimer(Agenda unAgenda) {
		this.getAgendas().remove(unAgenda);
	}

	//sort and filter methods
	public ArrayList<Evenement> tri(String unAttribut) {
		ArrayList<Evenement> evts = new ArrayList<Evenement>();
		for(Agenda a:this.getAgendas()){
			evts.addAll(a.getEvenements());
		}
		Attr attribut = Attr.valueOf(unAttribut.toUpperCase());
		switch (attribut) {
			case DATEHEUREDEBUT: Collections.sort(evts, new ComparateurHeureDebut()); break;
			case DATEHEUREFIN: Collections.sort(evts, new ComparateurHeureFin()); break; 
			case NOM: Collections.sort(evts, new ComparateurNom()); break; 
			case LIEU: Collections.sort(evts, new ComparateurLieu()); break; 
			case AGENDA: break;
		}
		return evts;
	}
	
	public ArrayList<Evenement> filtreDate(GregorianCalendar uneDate) {
		ArrayList<Evenement> evtsFiltered = new ArrayList<Evenement>();
		for(Agenda a:this.getAgendas()){
			for(Evenement e:a.getEvenements()){
				if((e.getDateHeureDebut().before(uneDate) && e.getDateHeureFin().after(uneDate)) || e.getDateHeureDebut().equals(uneDate) || e.getDateHeureFin().equals(uneDate))
					evtsFiltered.add(e);
			}
		}
		return evtsFiltered;
	}
	
	public ArrayList<Evenement> filtreNom(String unNom) {
		ArrayList<Evenement> evtsFiltered = new ArrayList<Evenement>();
		for(Agenda a:this.getAgendas()){
			for(Evenement e:a.getEvenements()){
				if(e.getNom().toLowerCase().contains(unNom.toLowerCase()))
					evtsFiltered.add(e);
			}
		}
		return evtsFiltered;
	}
	
	public ArrayList<Evenement> filtreLieu(String unLieu) {
		ArrayList<Evenement> evtsFiltered = new ArrayList<Evenement>();
		for(Agenda a:this.getAgendas()){
			for(Evenement e:a.getEvenements()){
				if(e.getLieu().toLowerCase().contains(unLieu.toLowerCase()))
					evtsFiltered.add(e);
			}
		}
		return evtsFiltered;
	}
	
	public ArrayList<Evenement> filtreAgenda(Agenda unAgenda) {
		ArrayList<Evenement> evtsFiltered = new ArrayList<Evenement>();
		for(Agenda a:this.getAgendas()){
			if(a == unAgenda)
				evtsFiltered.addAll(a.getEvenements());
		}
		return evtsFiltered;
	}
	
	public ArrayList<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(ArrayList<Agenda> agendas) {
		this.agendas = agendas;
	}

	//enums
	public enum Attr {
		DATEHEUREDEBUT,
		DATEHEUREFIN,
		NOM,
		LIEU,
		AGENDA
	}
}