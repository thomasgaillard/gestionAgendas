// Maxence Mermoz - Thomas Gaillard - M1 MTI

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
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class App extends JFrame {
	private static final long serialVersionUID = -3242724827400274900L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane jspane;
	private Calendrier cal;
	private ArrayList<Evenement> evts;
	private JTextField textField;
	private JPanel panelFiltrage;
	protected JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		
		setTitle("myCAL");
		
		cal = tests();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 556);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAjouter = new JMenu("Ajouter");
		menuBar.add(mnAjouter);
		
		JMenuItem mntmvnement = new JMenuItem("\u00C9v\u00E9nement");
		mntmvnement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evenement evNew = new Evenement();
				cal.getAgendas().get(0).ajouter(evNew);
				getContentPane().remove(jspane);
				remplirTableau(cal.tri("agenda"));
			}
		});
		mnAjouter.add(mntmvnement);
		
		JMenu mnSupprimer = new JMenu("Supprimer");
		menuBar.add(mnSupprimer);
		
		JMenuItem mntmvnement_1 = new JMenuItem("\u00C9v\u00E9nement");
		mntmvnement_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selection = table.getSelectedRows();
				
				for(Agenda a: cal.getAgendas()){
					a.getEvenements().remove(evts.get(selection[0]));
				}
				
				getContentPane().remove(jspane);
				remplirTableau(cal.tri("agenda"));
				
			}
		});
		mnSupprimer.add(mntmvnement_1);
		
		JMenu mnTrier = new JMenu("Trier");
		menuBar.add(mnTrier);
		
		JMenuItem mntmParNom = new JMenuItem("Par nom");
		mntmParNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().remove(jspane);
				remplirTableau(cal.tri("nom"));
			}
		});
		mnTrier.add(mntmParNom);
		
		JMenuItem mntmParDateDe = new JMenuItem("Par date de d\u00E9but");
		mntmParDateDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().remove(jspane);
				remplirTableau(cal.tri("dateHeureDebut"));
			}
		});
		mnTrier.add(mntmParDateDe);
		
		JMenuItem mntmParDateDe_1 = new JMenuItem("Par date de fin");
		mntmParDateDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jspane);
				remplirTableau(cal.tri("dateHeureFin"));
			}
		});
		mnTrier.add(mntmParDateDe_1);
		
		JMenuItem mntmParLieu = new JMenuItem("Par lieu");
		mntmParLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jspane);
				remplirTableau(cal.tri("lieu"));
			}
		});
		mnTrier.add(mntmParLieu);
		
		JMenuItem mntmParAgenda = new JMenuItem("Par agenda");
		mntmParAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(jspane);
				remplirTableau(cal.tri("agenda"));
			}
		});
		mnTrier.add(mntmParAgenda);
		
		JMenu mnFiltrer = new JMenu("Filtrer");
		menuBar.add(mnFiltrer);
		
		JMenuItem mntmParNom_1 = new JMenuItem("Par nom");
		mntmParNom_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				btnNewButton = new JButton("Filtrer par nom");	        
				btnNewButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		getContentPane().remove(jspane);
		        		remplirTableau(cal.filtreNom(textField.getText()));
		        	}
		        });
				affichageFormFiltrage(btnNewButton);
		        SwingUtilities.updateComponentTreeUI(contentPane);
			}
		});
		mnFiltrer.add(mntmParNom_1);
		
		JMenuItem mntmParDate = new JMenuItem("Par date");
		mntmParDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				btnNewButton = new JButton("Filtrer par date");	        
				btnNewButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		getContentPane().remove(jspane);
		        		remplirTableau(cal.filtreDate(Calendrier.deformatterDate(textField.getText())));
		        	}
		        });
				affichageFormFiltrage(btnNewButton);
				textField.setText("JJ/MM/AAAA HH:MM");
		        SwingUtilities.updateComponentTreeUI(contentPane);
			}
		});
		mnFiltrer.add(mntmParDate);
		
		JMenuItem mntmParLieu_1 = new JMenuItem("Par lieu");
		mntmParLieu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				btnNewButton = new JButton("Filtrer par lieu");	        
				btnNewButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		getContentPane().remove(jspane);
		        		remplirTableau(cal.filtreLieu(textField.getText()));
		        	}
		        });
				affichageFormFiltrage(btnNewButton);
		        SwingUtilities.updateComponentTreeUI(contentPane);
			}
		});
		mnFiltrer.add(mntmParLieu_1);
		
		JMenuItem mntmParAgenda_1 = new JMenuItem("Par agenda");
		mnFiltrer.add(mntmParAgenda_1);
		
		JMenu mnPartage = new JMenu("Partage");
		menuBar.add(mnPartage);
		
		JMenuItem mntmExporter = new JMenuItem("Exporter");
		mntmExporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cal.exportIcs();
			}
		});
		mnPartage.add(mntmExporter);
		
		JMenuItem mntmImporterics = new JMenuItem("Importer .ics");
		mnPartage.add(mntmImporterics);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        
		panelFiltrage = new JPanel();
        contentPane.add(panelFiltrage, BorderLayout.SOUTH);
        
        
        
        
        
		
        
		
		remplirTableau(cal.tri("agenda"));
		
		
	}
	
	public void remplirTableau(ArrayList<Evenement> evts){
		
		TableauDynamique td = new TableauDynamique(cal, evts);
        table =  new JTable(td); 
        jspane = new JScrollPane(table);
        this.contentPane.add(jspane);
        SwingUtilities.updateComponentTreeUI(this.getContentPane());
		}
	
	public Calendrier tests(){
		//calendar
		cal = new Calendrier();
		
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
		
		e1.changerAgenda(cal, "Pro");
		
		return cal;
	}

	public void affichageFormFiltrage(JButton btnNewButton) {
		textField = new JTextField();
		panelFiltrage.add(textField);
		textField.setColumns(20);
		panelFiltrage.add(btnNewButton);
	}
}