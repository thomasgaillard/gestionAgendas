// Maxence Mermoz - Thomas Gaillard - M1 MTI
//COUCOUUUUUUUUUUUUUUUUUUUJ

package gestion.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import gestion.agendas.Agenda;
import gestion.agendas.Evenement;

public class App {

	//main method
	public static void main (String []args) {
		Evenement e1 = new Evenement();
		e1.setNom("RDV Coiffeur");
		e1.setLieu("Annecy");
		e1.setDateHeureDebut(new GregorianCalendar(2013,11,8,11,30));
		e1.setDateHeureFin(new GregorianCalendar(2013,11,8,11,40));
		
		Evenement e2 = new Evenement();
		e2.setNom("RŽunion avec Jacky");
		e2.setLieu("Annecy-le-Vieux");
		e2.setDateHeureDebut(new GregorianCalendar(2013,11,12,18,30));
		e2.setDateHeureFin(new GregorianCalendar(2013,11,12,18,30));
		
		Evenement e3 = new Evenement();
		e3.setNom("RŽparation voiture");
		e3.setLieu("Annecy");
		e3.setDateHeureDebut(new GregorianCalendar(2013,11,15,14,00));
		e3.setDateHeureFin(new GregorianCalendar(2013,11,14,10,00));
		
		Evenement e4 = new Evenement();
		e4.setNom("Courses de noel");
		e4.setLieu("Annecy");
		e4.setDateHeureFin(new GregorianCalendar(2013,11,14,10,00));
		
		Evenement e5 = new Evenement();
			
		Agenda ag1 = new Agenda("Perso");
		ag1.ajouter(e1);
		ag1.ajouter(e3);
		ag1.ajouter(e4);
		
		Agenda ag2 = new Agenda("Pro");
		ag2.ajouter(e2);
		ag2.ajouter(e5);
		
		System.out.println("\n----- Jeu de Tests 1 -----");
		ag1.afficherAgenda();
		ag2.afficherAgenda();
		
		e2.changerAgenda(ag1);
		
		System.out.println("\n----- Jeu de Tests 2 (DŽplacement dans agenda 1) -----");
		ag1.afficherAgenda();
		ag2.afficherAgenda();
	
	}

}
