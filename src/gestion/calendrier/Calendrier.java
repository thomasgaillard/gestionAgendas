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
		List<String> combined = new ArrayList<String>();
		combined.addAll(firstArrayList);
		combined.addAll(secondArrayList);
		combined.addAll(thirdArrayList);
		for(Agenda a:this.agendas){
			a.tri(unAttribut);
		}
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
