package gestion.ihm;

import gestion.agendas.Evenement;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableauDynamique extends AbstractTableModel {

	private final String[]  title = {"Événements","Date/Heure de début","Date/Heure de fin","Lieu","Agenda"};
	private ArrayList<Evenement> listeEvts = new ArrayList<Evenement>();
	
	public TableauDynamique(ArrayList<Evenement> evts){
		listeEvts = evts;	        
	}
	@Override
	public int getColumnCount() {
		return title.length;
	}

	@Override
	public int getRowCount() {
		return listeEvts.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
        return title[columnIndex];
    }
 

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
        case 0:
            return listeEvts.get(rowIndex).getNom();
        case 1:
            return listeEvts.get(rowIndex).formatterDate(listeEvts.get(rowIndex).getDateHeureDebut());
        case 2:
            return listeEvts.get(rowIndex).formatterDate(listeEvts.get(rowIndex).getDateHeureFin());
        case 3:
            return listeEvts.get(rowIndex).getLieu();
        case 4:
            return listeEvts.get(rowIndex).getAgenda().getNom();
        default:
            return null; //Ne devrait jamais arriver
    }
	}

}
