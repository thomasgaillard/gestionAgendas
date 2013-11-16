// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.calendrier;

import gestion.agendas.Evenement;
import java.util.Comparator;

public class ComparateurHeureFin implements Comparator<Evenement> {
	public int compare(Evenement e1, Evenement e2){
        return e1.getDateHeureFin().compareTo(e2.getDateHeureFin());
	}
}