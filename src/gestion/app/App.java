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
		
		Evenement e2 = new Evenement();
		e2.setNom("RŽunion avec Jacky");
		e2.setLieu("Annecy-le-Vieux");
		e2.setDateHeure(new GregorianCalendar(2013,11,12,18,30));
		
		Evenement e3 = new Evenement();
		e3.setNom("RŽparation voiture");
		e3.setLieu("Annecy");
		e3.setDateHeure(new GregorianCalendar(2013,11,15,14,00));
		
		Evenement e4 = new Evenement();
		e4.setNom("Courses de noel");
		e4.setLieu("Annecy");
		e4.setDateHeure(new GregorianCalendar(2013,11,30,15,00));
			
		Agenda ag1 = new Agenda("Perso");
		ag1.ajouter(e1);
		ag1.ajouter(e3);
		ag1.ajouter(e4);
		
		Agenda ag2 = new Agenda("Pro");
		ag2.ajouter(e2);
		
		ag1.afficherAgenda();
		ag2.afficherAgenda();
	}

}
