// Maxence Mermoz - Thomas Gaillard - M1 MTI

package gestion.ihm;

import gestion.agendas.Evenement;
import gestion.calendrier.Calendrier;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.table.AbstractTableModel;

public class TableauDynamique extends AbstractTableModel {
	private static final long serialVersionUID = 7439188643380297943L;
	private Calendrier cal;
	private final String[]  title = {"Événements", "Date/Heure de début", "Date/Heure de fin", "Lieu", "Agenda"};
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
	            	String all=(String)valeur;
	            	int day = Integer.parseInt(all.substring(0, 2));
	            	int month = Integer.parseInt(all.substring(3, 5));
	            	int year = Integer.parseInt(all.substring(6, 10));
	            	int hour = Integer.parseInt(all.substring(11, 13));
	            	int minute = Integer.parseInt(all.substring(14, 16));
	                e.setDateHeureDebut(new GregorianCalendar(year,month-1,day,hour,minute));
	                break;
	            case 2:
	            	String all1=(String)valeur;
	            	int day1 = Integer.parseInt(all1.substring(0, 2));
	            	int month1 = Integer.parseInt(all1.substring(3, 5));
	            	int year1 = Integer.parseInt(all1.substring(6, 10));
	            	int hour1 = Integer.parseInt(all1.substring(11, 13));
	            	int minute1 = Integer.parseInt(all1.substring(14, 16));
	                e.setDateHeureFin(new GregorianCalendar(year1,month1-1,day1,hour1,minute1));
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