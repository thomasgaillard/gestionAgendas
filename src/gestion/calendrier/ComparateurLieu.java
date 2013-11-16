// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.calendrier;

import gestion.agendas.Evenement;
import java.util.Comparator;

public class ComparateurLieu implements Comparator<Evenement> {
	public int compare(Evenement e1, Evenement e2){
        return e1.getLieu().compareTo(e2.getLieu());
	}
}