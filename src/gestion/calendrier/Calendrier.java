// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.calendrier;

import fr.univsavoie.iae.tm.objetsGeometriques.objets.ObjetGeometrique;
import gestion.agendas.Agenda;
import gestion.agendas.Evenement;

import java.util.ArrayList;
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
		ArrayList<Evenement> merged = new ArrayList<Evenement>();
		for(Agenda a:this.agendas){
			merged.addAll(a.tri(unAttribut));
		}
		return merged;
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
	
}
