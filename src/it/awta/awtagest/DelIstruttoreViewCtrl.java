package it.awta.awtagest;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 * 
 */

/**
 * @author Tme
 *
 */
public class DelIstruttoreViewCtrl extends GenericForwardComposer {

	private Window winDelIstruttore;
	private Button delBtn;
	private Listbox lstbxIstruttori;
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

	public void onClick$delBtn() throws InterruptedException {
		//TODO: please check if you have use "self" or zscript functions here.
		Istruttore s = (Istruttore) lstbxIstruttori.getSelectedItem().getValue();
		try{
			new IstruttoreHome().deleteIstruttore(s);
			onCreate$bd();
			bd.setText("");
			Messagebox.show("Istruttore eliminato correttamente","Operazione eseguita",Messagebox.OK,Messagebox.INFORMATION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Messagebox.show("Non puoi cancellare questo istruttore.\nForse è associato a degli studenti!!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}		
	}

	public void onCreate$bd() {
		//TODO: please check if you have use "self" or zscript functions here.
		List<Istruttore> listaIstruttori = new IstruttoreHome().findAll();
		ListModelList lml = new ListModelList(listaIstruttori);
		lstbxIstruttori.setModel(lml);
	}

	public void onSelect$bd() {
		//TODO: please check if you have use "self" or zscript functions here.
	}

}
