package gestion.ihm;

import gestion.agendas.Agenda;
import gestion.agendas.Evenement;
import gestion.calendrier.Calendrier;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class fenetrePrincipale extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenetrePrincipale frame = new fenetrePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fenetrePrincipale() {
		Calendrier cal = loadTests();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 556);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAjouter = new JMenu("Ajouter");
		menuBar.add(mnAjouter);
		
		JMenuItem mntmAgenda = new JMenuItem("Agenda");
		mnAjouter.add(mntmAgenda);
		
		JMenuItem mntmvnement = new JMenuItem("\u00C9v\u00E9nement");
		mnAjouter.add(mntmvnement);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
		
		remplirTableau(cal);
	}
	
	public void remplirTableau(Calendrier cal){
		ArrayList<Evenement> evts = new ArrayList<Evenement>();
		evts = cal.tri("agenda");
		Object[][] data = new Object[evts.size()][5];
		 
		
        
        int i = 0;
        for(Evenement e: evts){
        	data[i][0] = e.getNom();
        	data[i][1] = e.formatterDate(e.getDateHeureDebut());
        	data[i][2] = e.formatterDate(e.getDateHeureFin());
        	data[i][3] = e.getLieu();
        	data[i][4] = e.getAgenda().getNom();
        	i++;
		}
             
        String  title[] = {"Événements","Date/Heure de début","Date/Heure de fin","Lieu","Agenda"};
        table = new JTable(data, title);
         
        this.getContentPane().add(new JScrollPane(table));
		}
	
	public Calendrier loadTests(){
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
		e2.setNom("Réunion avec Jacky");
		e2.setLieu("Annecy-le-Vieux");
		e2.setDateHeureDebut(new GregorianCalendar(2013,11,12,18,30));
		e2.setDateHeureFin(new GregorianCalendar(2013,11,12,18,30));
		
		Evenement e3 = new Evenement();
		e3.setNom("Réparation voiture");
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
		
		return cal;
	}

}
