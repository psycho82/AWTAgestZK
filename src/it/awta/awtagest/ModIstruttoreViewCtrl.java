/**
 * 
 */
package it.awta.awtagest;

import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 * @author Tme
 *
 */
public class ModIstruttoreViewCtrl extends GenericForwardComposer {
	private Intbox IstId;
	private Textbox IstGrado;
	private Textbox IstCognome;
	private Textbox IstNome;
	//private Listbox lstbxIstruttori;
	//private Bandbox bd;
	private Grid gridIstruttore;
	private Combobox cbxIstruttore;

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
		if(!cbxIstruttore.getText().equals("")){
			Istruttore i = (Istruttore) cbxIstruttore.getSelectedItem().getValue();
			IstId.setValue(i.getIstId());
			IstNome.setValue(i.getIstNome());
			IstCognome.setValue(i.getIstCognome());
			IstGrado.setValue(i.getIstGrado());
			List<Scuola> listaScuole = new ScuolaHome().findAll();
			ListModelList lml = new ListModelList(listaScuole);
			gridIstruttore.setVisible(true);
		}else{
			Messagebox.show("Selezionare almeno un istruttore dall'elenco!!","Attenzione",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onClick$saveBtn() throws InterruptedException {
		//TODO: please check if you have use "self" or zscript functions here.
		Istruttore i = new Istruttore();
		i.setIstId(IstId.getValue());
		i.setIstNome(IstNome.getValue().toUpperCase());
		i.setIstCognome(IstCognome.getValue().toUpperCase());
		i.setIstGrado(IstGrado.getValue().toUpperCase());
		IstruttoreHome ih = new IstruttoreHome();
		try {
			ih.update(i);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onCreate$cbxIstruttore() {
		//TODO: please check if you have use "self" or zscript functions here.
		List<Istruttore> listaIstruttori = new IstruttoreHome().findAll();
		ListModelList lml = new ListModelList(listaIstruttori);
		cbxIstruttore.setModel(lml);
	}

}
