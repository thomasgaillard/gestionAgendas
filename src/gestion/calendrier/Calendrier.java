// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.calendrier;

import gestion.agendas.Agenda;
import gestion.agendas.Evenement;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Calendrier {

	//attributes
	private ArrayList<Agenda> agendas;
	
	//methods
	public void ajouter(Agenda unAgenda){
		this.agendas.add(unAgenda);
	}
	
	public void supprimer(Agenda unAgenda){
		this.agendas.remove(unAgenda);
	}
	
	//sort and filter methods
	public void tri(String unAttribut){
		//TODO
	}
	
	public void filtreDate(GregorianCalendar uneDate){
		//TODO
	}
	
	public void filtreNom(String unNom){
		//TODO
	}
	
	public void filtreLieu(String unLieu){
		//TODO
	}
	
	public void filtreAgenda(Agenda unAgenda){
		//TODO
	}
}
