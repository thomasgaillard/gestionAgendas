package gestion.ihm;

import gestion.agendas.Agenda;
import gestion.agendas.Evenement;
import gestion.calendrier.Calendrier;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class fenetrePrincipale extends JFrame {

	private JPanel contentPane;

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
		
		//links
		cal.ajouter(ag1);
		cal.ajouter(ag2);
		ag1.ajouter(e1);
				
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

	}

}
