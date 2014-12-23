/**
 * 
 */
package it.awta.awtagest;

import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
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
public class DelScuolaViewCtrl extends GenericForwardComposer {
	private Bandbox bd;
	private Listbox lstbxScuole;
	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub

	}
	public void onCreate$bd() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
		List<Scuola> listaScuole = new ScuolaHome().findAll();
		ListModelList lml = new ListModelList(listaScuole);
		lstbxScuole.setModel(lml);
	}
	public void onClick$delBtn() throws InterruptedException{
		Scuola s = (Scuola) lstbxScuole.getSelectedItem().getValue();
		try{
			new ScuolaHome().deleteScuola(s);
			onCreate$bd();
			bd.setText("");
			Messagebox.show("Scuola eliminata correttamente","Operazione eseguita",Messagebox.OK,Messagebox.INFORMATION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Messagebox.show("Impossibile eliminare la scuola, forse ci sarà un istruttore associato!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
}
