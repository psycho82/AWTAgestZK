package it.awta.awtagest;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;

/**
 * 
 */

/**
 * @author Tme
 *
 */
public class ModScuolaViewCtrl extends GenericForwardComposer {

	private Button findBtn,saveBtn;
	private Listbox lstbxScuole;
	private Bandbox bd;
	private Grid gridScuola;
	private Textbox ScNome,ScIndirizzo,ScComune,ScProvincia,ScRegione,ScNazione,ScNote;
	private Intbox ScId;
	private Combobox cbxScComune;

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub

	}

	public void onClick$findBtn() throws InterruptedException {
		if(!bd.getText().equals("")){
			Scuola s = (Scuola) lstbxScuole.getSelectedItem().getValue();
			s = new ScuolaHome().findById(s.getScId());
			ScId.setValue(s.getScId());
			ScNome.setValue(s.getScNome());
			ScIndirizzo.setValue(s.getScIndirizzo());
			ScComune.setValue(s.getScComune());
			ScProvincia.setValue(s.getScProvincia());
			ScRegione.setValue(s.getScRegione());
			ScNazione.setValue(s.getScNazione());
			ScNote.setValue(s.getScNote());
			gridScuola.setVisible(true);
		}else{
			Messagebox.show("Selezionare almeno una scuola dall'elenco!!","Attenzione",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onClick$saveBtn() throws InterruptedException{
		Scuola dummyScuola = new Scuola();
		dummyScuola.setScId(ScId.getValue());
		dummyScuola.setScNome(ScNome.getValue().toUpperCase());
		dummyScuola.setScIndirizzo(ScIndirizzo.getValue().toUpperCase());
		dummyScuola.setScComune(ScComune.getValue().toUpperCase());
		dummyScuola.setScProvincia(ScProvincia.getValue().toUpperCase());
		dummyScuola.setScRegione(ScRegione.getValue().toUpperCase());
		dummyScuola.setScNazione(ScNazione.getValue().toUpperCase());
		dummyScuola.setScNote(ScNote.getValue().toUpperCase());
		ScuolaHome dummyScuolaH = new ScuolaHome();
		try {
			dummyScuolaH.update(dummyScuola);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}

	}
	public void onSelect$lstbxScuole() throws InterruptedException {
		compilaCampi((Scuola) lstbxScuole.getSelectedItem().getValue());
	}

	public void onCreate$bd() {
		List<Scuola> listaScuole = new ScuolaHome().findAll();
		ListModelList lml = new ListModelList(listaScuole);
		lstbxScuole.setModel(lml);
	}
	public void onCreate$cbxScComune() {
		List<String> listaComuni = new ScuolaHome().findAllComuni();
		ListModel lm = new SimpleListModel(listaComuni);
		cbxScComune.setModel(lm);
	}
	public void onSelect$cbxScComune() throws InterruptedException {
		List<Scuola> listaScuole = new ScuolaHome().findScuoleByComune(cbxScComune.getText());
		if(listaScuole.size()==1){
			lstbxScuole.setVisible(false);
			compilaCampi(listaScuole.get(0));
		}else{
			gridScuola.setVisible(false);
			ListModelList lml = new ListModelList(listaScuole);
			lstbxScuole.setModel(lml);
			lstbxScuole.setVisible(true);
		}
	}
	public void compilaCampi(Scuola s) throws InterruptedException {
			ScId.setValue(s.getScId());
			ScNome.setValue(s.getScNome());
			ScIndirizzo.setValue(s.getScIndirizzo());
			ScComune.setValue(s.getScComune());
			ScProvincia.setValue(s.getScProvincia());
			ScRegione.setValue(s.getScRegione());
			ScNazione.setValue(s.getScNazione());
			ScNote.setValue(s.getScNote());
			gridScuola.setVisible(true);
	}
}
