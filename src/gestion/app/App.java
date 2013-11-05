// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.app;

import java.util.GregorianCalendar;

import gestion.agendas.Agenda;
import gestion.agendas.Evenement;

public class App {

	//main method
	public static void main (String []args) {
		Evenement e1 = new Evenement();
		e1.setNom("RDV Coiffeur");
		e1.setLieu("Annecy");
		e1.setDateHeure(new GregorianCalendar(2013,11,8,11,30));
		Agenda ag1 = new Agenda("Perso");
		ag1.ajouter(e1);
		System.out.println(e1.toString());
	}

}