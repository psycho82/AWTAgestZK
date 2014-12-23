/**
 * 
 */
package it.awta.awtagest;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 * @author Tme
 *
 */
public class AddScuolaViewCtrl extends GenericForwardComposer {

	private Textbox ScNazione;
	private Textbox ScRegione;
	private Textbox ScProvincia;
	private Textbox ScComune;
	private Textbox ScIndirizzo;
	private Textbox ScNome;
	private Textbox ScNote;

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub

	}
	public void onClick$saveBtn() throws InterruptedException{
		Scuola dummyScuola = new Scuola();
		dummyScuola.setScNome(ScNome.getValue().toUpperCase());
		dummyScuola.setScIndirizzo(ScIndirizzo.getValue().toUpperCase());
		dummyScuola.setScComune(ScComune.getValue().toUpperCase());
		dummyScuola.setScProvincia(ScProvincia.getValue().toUpperCase());
		dummyScuola.setScRegione(ScRegione.getValue().toUpperCase());
		dummyScuola.setScNazione(ScNazione.getValue().toUpperCase());
		dummyScuola.setScNote(ScNote.getValue().toUpperCase());
		ScuolaHome dummyScuolaH = new ScuolaHome();
		try {
			dummyScuolaH.merge(dummyScuola);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}

}
