package  passwortmanager;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import wox.serial.Easy;

public class Controll_Main implements ActionListener {

	private String mstrPasswort;
	
	// Instanzen von Model und View
	private ArrayList<Model_Konto> mvecModel;
	private Anzeigen mguiMain;
	private Abfrage mguiAbfrage;
	private Hinzufuegen mguiHinzufuegen;

	// aes verschluesslung
	AES_verschluesselung aes;


	public void start() {

		// reinigen der variablen
		this.mstrPasswort = "";
	

		// erstellen der view instanzen
		this.mguiMain = Anzeigen.init();
		this.mguiAbfrage = Abfrage.init();
		this.mguiHinzufuegen = Hinzufuegen.init();

		// hinzufuegend der Listener
		this.mguiHinzufuegen.getGui_hinzufuegen_btnhinzufuegen().addActionListener(this);
                this.mguiAbfrage.getGui_abfrage_btnanmelden().addActionListener(this);
                this.mguiMain.getGui_anzeigen_btn_update().addActionListener(this);
                this.mguiMain.getGui_anzeigen_btnhinzufuegen().addActionListener(this);

		// starten des Hauptfensters
		this.mguiAbfrage.show();

		// aes verschluesselung
		this.aes = new AES_verschluesselung();
                this.mvecModel = new ArrayList<>();
	}

	public void actionPerformed(ActionEvent ae) {

		// auslesen des listeners
		String mstrCommand = ae.getActionCommand().toString();
		if (cmbAuswahl.getGUI_Abfrage_BtnAnmelden().equals(mstrCommand)) {
                    mstrPasswort = 
                    this.mguiAbfrage.getjPasswordField1().getText().toString();
                    this.aes.setkey(mstrPasswort);
                    this.mguiAbfrage.hide();
                    readXML();
                    print();
		} 
                else if(cmbAuswahl.getGUI_Anzeigen_BtnHinzufuegen().equals(mstrCommand))
                {
                    this.mguiHinzufuegen.show();
                }
                else if(cmbAuswahl.getGUI_Anzeigen_BtnUpdate().equals(mstrCommand))
                {
                    this.mvecModel.clear();
                    for (int i = 0; i < mguiMain.getjTable().getRowCount(); i++) {

                        
                        String dienst = mguiMain.getjTable().getValueAt(i, 0).toString();
                        String webseite = mguiMain.getjTable().getValueAt(i, 1).toString();
                        String url = mguiMain.getjTable().getValueAt(i, 2).toString();
                        String kontakt = mguiMain.getjTable().getValueAt(i, 3).toString();
                        String  Username= mguiMain.getjTable().getValueAt(i, 4).toString();
                        String Passwort = mguiMain.getjTable().getValueAt(i, 5).toString();
                        String Reset = mguiMain.getjTable().getValueAt(i, 6).toString();
                        String Email = mguiMain.getjTable().getValueAt(i, 7).toString();
                        String Erstellt = mguiMain.getjTable().getValueAt(i, 8).toString();
                        String geandert = mguiMain.getjTable().getValueAt(i, 9).toString();
                        String FrageA = mguiMain.getjTable().getValueAt(i, 10).toString();
                        String AntwortA = mguiMain.getjTable().getValueAt(i, 11).toString();
                        String FrageB = mguiMain.getjTable().getValueAt(i, 12).toString();
                        String AntwortB = mguiMain.getjTable().getValueAt(i, 13).toString();
                        String entfernen = mguiMain.getjTable().getValueAt(i, 14).toString();

                        
                        if(entfernen.equals("0")){
                        this.mvecModel.add(new Model_Konto(
                                dienst, 
                                Username, 
                                AntwortA, 
                                AntwortB,
                                Reset, 
                                Erstellt, 
                                FrageA,
                                FrageB, 
                                geandert, 
                                kontakt, 
                                Passwort, 
                                Email, 
                                url,
                                webseite));
			
			}
                    }
                    
                      writeXML();
                    
                    
                }
                else if(cmbAuswahl.getGUI_Hinzufuegen_BtnHinzufuegen().equals(mstrCommand))
                {                            
                        
        this.mvecModel.add(
        new Model_Konto(
                this.mguiHinzufuegen.getTxtDienst().getText(), 
                this.mguiHinzufuegen.getTxtUsername().getText(), 
                this.mguiHinzufuegen.getTxtantworta().getText(),
                this.mguiHinzufuegen.getTxtantwortb().getText(),
                this.mguiHinzufuegen.getTxtemail().getText(), 
                this.mguiHinzufuegen.getTxterstellt().getText(), 
                this.mguiHinzufuegen.getTxtfragea().getText(), 
                this.mguiHinzufuegen.getTxtfrageb().getText(), 
                this.mguiHinzufuegen.getTxtgeanertam().getText(), 
                this.mguiHinzufuegen.getTxtkontakt().getText(), 
                this.mguiHinzufuegen.getTxtpasswort().getText(), 
                this.mguiHinzufuegen.getTxtresetemail().getText(),
                this.mguiHinzufuegen.getTxtreseturl().getText(),
                this.mguiHinzufuegen.getTxtwebseite().getText()));

        writeXML();
        this.mguiHinzufuegen.hide();
       print();
                }

	}


	private void writeXML() {

			for(int i=0;i<this.mvecModel.size();i++)
                        {
                            this.mvecModel.get(i).encode(aes);
                        }
			
		
		Easy.save(this.mvecModel, "data.xml");

	}
        
        private void readXML() {

            		this.mvecModel = (ArrayList < Model_Konto >) Easy.load("data.xml");

			for(int i=0;i<this.mvecModel.size();i++)
                        {
                            this.mvecModel.get(i).decode(aes);
                        }	

	}



	private void print() {

            this.mguiMain.show();
			Object[][] databaseInfo = null;
			Object[] columns = { "Dienst", "Webseite", "URL", "Kontakt","Username","Passwort","Reset","Email","Erstellt am","geandert am","FrageA","AntwortA","FrageB","AntwortB","entfernen" };


			DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo, columns) {
				/**
						 * 
						 */
				private static final long serialVersionUID = 1L;

				public Class<?> getColumnClass(int column) {
					Class<?> returnValue;
					if ((column >= 0) && (column < getColumnCount())) {
						returnValue = getValueAt(0, column).getClass();
					} else {
						returnValue = Object.class;
					}
					return returnValue;
				}
			};
			for (int i = 0; i < mvecModel.size(); i++) {

					dTableModel.addRow(mvecModel.get(i).print());
				
			}
			mguiMain.setTableModel(dTableModel);

	}

}
