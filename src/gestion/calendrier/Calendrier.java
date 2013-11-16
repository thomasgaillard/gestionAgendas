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

	//methods
	public void ajouter(Agenda unAgenda) {
		this.agendas.add(unAgenda);
	}
	public void supprimer(Agenda unAgenda) {
		this.agendas.remove(unAgenda);
	}

	//sort and filter methods
	public ArrayList<Evenement> tri(String unAttribut) {
		ArrayList<Evenement> evts = new ArrayList<Evenement>();
		for(Agenda a:this.agendas){
			evts.addAll(a.getEvenements());
		}
		Attr attribut = Attr.valueOf(unAttribut.toUpperCase());
		switch (attribut) {
			case DATEHEUREDEBUT: Collections.sort(evts, new ComparateurHeureDebut()); break;
			case DATEHEUREFIN: Collections.sort(evts, new ComparateurHeureFin()); break; 
			case NOM: Collections.sort(evts, new ComparateurNom()); break; 
			case LIEU: Collections.sort(evts, new ComparateurLieu()); break; 
			default: break;
		}
		return evts;
	}
	public void filtreDate(GregorianCalendar uneDate) {
		//TODO
	}
	public void filtreNom(String unNom) {
		//TODO
	}
	public void filtreLieu(String unLieu) {
		//TODO
	}
	public void filtreAgenda(Agenda unAgenda) {
		//TODO
	}
	
	//enums
	public enum Attr {
		DATEHEUREDEBUT,
		DATEHEUREFIN,
		NOM,
		LIEU
	}
}
