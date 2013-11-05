// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.agendas;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class Agenda implements Comparable {

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
	public void afficherAgenda(){
		System.out.println(this.getNom());
		for(Evenement evt: this.evenements){
			evt.afficherEvenement();
		}
	}
	public ArrayList<Evenement> tri(String unAttribut) {
		ArrayList<Evenement> merged = new ArrayList<Evenement>();
		for(Evenement e:this.evenements){
			//merged.addAll(e.sort(unAttribut));
			//tripardate
		}
		return merged;
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}

}
