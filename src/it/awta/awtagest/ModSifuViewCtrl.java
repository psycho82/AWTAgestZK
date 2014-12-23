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
public class ModSifuViewCtrl extends GenericForwardComposer {
	private Intbox SifuId;
	private Textbox SifuGrado;
	private Textbox SifuCognome;
	private Textbox SifuNome;
	private Grid gridSifu;
	private Combobox cbxSifu;

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
		if(!cbxSifu.getText().equals("")){
			Sifu i = (Sifu) cbxSifu.getSelectedItem().getValue();
			SifuId.setValue(i.getSifuId());
			SifuNome.setValue(i.getSifuNome());
			SifuCognome.setValue(i.getSifuCognome());
			gridSifu.setVisible(true);
		}else{
			Messagebox.show("Selezionare almeno un Sifu dall'elenco!!","Attenzione",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onClick$saveBtn() throws InterruptedException {
		//TODO: please check if you have use "self" or zscript functions here.
		Sifu i = new Sifu();
		i.setSifuId(SifuId.getValue());
		i.setSifuNome(SifuNome.getValue().toUpperCase());
		i.setSifuCognome(SifuCognome.getValue().toUpperCase());
		SifuHome ih = new SifuHome();
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
	public void onCreate$cbxSifu() {
		List<Sifu> listaSifuruttori = new SifuHome().findAll();
		ListModelList lml = new ListModelList(listaSifuruttori);
		cbxSifu.setModel(lml);
	}

}
