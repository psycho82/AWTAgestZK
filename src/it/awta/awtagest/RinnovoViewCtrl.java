/**
 * 
 */
package it.awta.awtagest;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 * @author Tme
 *
 */
public class RinnovoViewCtrl extends GenericForwardComposer {

	private Button rinnovaBtn;
	private Datebox dbxRinnovo;
	private Button ricercaBtn;
	private Intbox ibxNumeroTessera;
	private Textbox tbxCognome;
	private Textbox tbxNome;
	private Listbox lstbxSoggetti;
	private Soggetto sg = new Soggetto();

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub
	}

	public void onClick$rinnovaBtn() throws InterruptedException {
		if(lstbxSoggetti.getSelectedItem()!=null){
			sg.setSgRinnovo(dbxRinnovo.getValue());
			new SoggettoHome().update(sg);
			List<Soggetto> listaSg = new SoggettoHome().findBySog(sg);
			lstbxSoggetti.setModel(new ListModelList(listaSg));
		}else{
			Messagebox.show("Selezionare almeno una riga dalla lista!!","Errore",Messagebox.OK,Messagebox.ERROR);	
		}
	}
	public void onClick$ricercaBtn() {
		if(!tbxNome.getText().equals("")){
			sg.setSgNome(tbxNome.getText());
		}
		if(!tbxCognome.getText().equals("")){
			sg.setSgCognome(tbxCognome.getText());
		}
		if(ibxNumeroTessera.getValue()!=null){
			sg.setSgCode(ibxNumeroTessera.getValue());
		}
		List<Soggetto> listaSg = new SoggettoHome().findBySog(sg);
		lstbxSoggetti.setModel(new ListModelList(listaSg));
	}
	public void onSelect$lstbxSoggetti(){
		Soggetto s = (Soggetto)lstbxSoggetti.getSelectedItem().getValue();
		sg = s;
		tbxNome.setValue(sg.getSgNome());
		tbxCognome.setValue(sg.getSgCognome());
	}
}
