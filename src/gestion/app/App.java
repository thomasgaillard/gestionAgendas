// Maxence Mermoz - Thomas Gaillard - M1 MTI
//COUCOUUUUUUUUUUUUUUUUUUUJ

package gestion.app;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import gestion.calendrier.Calendrier;
import gestion.agendas.Agenda;
import gestion.agendas.Evenement;

public class App {

	//main method
	public static void main (String []args) {
		//calendar
		Calendrier cal = new Calendrier();
		
		//agendas
		Agenda ag1 = new Agenda("Perso");
		Agenda ag2 = new Agenda("Pro");
		
		//events
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
		e3.setLieu("Seynod");
		e3.setDateHeureDebut(new GregorianCalendar(2013,11,15,14,00));
		e3.setDateHeureFin(new GregorianCalendar(2013,11,14,10,00));
		
		Evenement e4 = new Evenement();
		e4.setNom("Courses de noel");
		e4.setLieu("Lyon");
		e4.setDateHeureFin(new GregorianCalendar(2013,11,14,10,00));
		
		Evenement e5 = new Evenement();

		//links
		cal.ajouter(ag1);
		cal.ajouter(ag2);
		
		ag1.ajouter(e1);
		ag1.ajouter(e3);
		ag1.ajouter(e4);
		
		ag2.ajouter(e2);
		ag2.ajouter(e5);
		
		System.out.println("\n----- Jeu de Tests 1 -----");
		System.out.println(ag1.toString());
		System.out.println(ag2.toString());
		
		e2.changerAgenda(ag1);
		System.out.println("\n----- Jeu de Tests 2 (DŽplacement dans agenda 1) -----");
		System.out.println(ag1.toString());
		System.out.println(ag2.toString());
		
		System.out.println("\n----- Jeu de Tests 3 (Tris sur nom) -----");
		ArrayList<Evenement> evts = new ArrayList<Evenement>();
		evts = cal.tri("nom");
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 4 (Tris sur lieu) -----");
		evts = cal.tri("lieu");
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 5 (Tris sur dateHeureDebut) -----");
		evts = cal.tri("dateHeureDebut");
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 6 (Tris sur dateHeureFin) -----");
		evts = cal.tri("dateHeureFin");
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 7 (Tris sur agenda) -----");
		evts = cal.tri("agenda");
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 8 (Filtre sur nom) -----");
		evts = cal.filtreNom("rdv");
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 9 (Filtre sur lieu) -----");
		evts = cal.filtreLieu("annecy");
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 10 (Filtre sur date) -----");
		evts = cal.filtreDate(new GregorianCalendar(2013,11,8,11,35));
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 11 (Filtre sur agenda) -----");
		evts = cal.filtreAgenda(ag2);
		for(Evenement e: evts){
			System.out.print(e.toString());
		}
		
		System.out.println("\n----- Jeu de Tests 12 (export ics) -----");
		cal.export();
	}
}