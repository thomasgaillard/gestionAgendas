package gestion.ihm;

import gestion.agendas.Agenda;
import gestion.agendas.Evenement;
import gestion.calendrier.Calendrier;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableauDynamique extends AbstractTableModel {

	private Calendrier cal;
	private final String[]  title = {"Événements","Date/Heure de début","Date/Heure de fin","Lieu","Agenda"};
	private ArrayList<Evenement> listeEvts = new ArrayList<Evenement>();
	
	public TableauDynamique(Calendrier cal, ArrayList<Evenement> evts){
		this.cal=cal;
		this.listeEvts = evts;	        
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
            return null;
    }
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return true; 
	}
	 
	@Override
	public void setValueAt(Object valeur, int rowIndex, int columnIndex) {
	    if(valeur != null){
	        Evenement e = listeEvts.get(rowIndex);
	 
	        switch(columnIndex){
	            case 0:
	                e.setNom((String)valeur);
	                break;
	            case 1:
	                //e.setDateHeureDebut((String)valeur);
	                break;
	            case 2:
	            	//e.setDateHeureFin((String)valeur);
	                break;
	            case 3:
	                e.setLieu((String)valeur);
	                break;
	            case 4:
	                e.changerAgenda(cal, (String)valeur);
	                break;
	        }
	    }
	}

}
