/**
 * 
 */
package it.awta.awtagest;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

/**
 * @author Tme
 *
 */
public class DelSoggettoViewCtrl extends GenericForwardComposer {

	private Listbox lstbxStudenti;
	private Bandbox bd;

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub

	}
	public void onCreate$bd(){
		List<Soggetto> listaSoggetti = new SoggettoHome().findAllNoDeleted();
		ListModelList lml = new ListModelList(listaSoggetti);
		lstbxStudenti.setModel(lml);
	}
	public void onClick$delBtn() throws InterruptedException{
		Soggetto s = (Soggetto) lstbxStudenti.getSelectedItem().getValue();
		s.setSgDeleted(true);
		try{
			new SoggettoHome().deleteSoggetto(s);
			//new SoggettoHome().update(s);
			onCreate$bd();
			bd.setText("");
			Messagebox.show("Studente eliminato correttamente","Operazione eseguita",Messagebox.OK,Messagebox.INFORMATION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
}
