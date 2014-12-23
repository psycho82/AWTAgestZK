/**
 * 
 */
package it.awta.awtagest;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 * @author Tme
 *
 */
public class AddIstruttoreViewCtrl extends GenericForwardComposer {
	private Textbox Istgrado;
	private Textbox IstCognome;
	private Textbox IstNome;

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
		Istruttore i = new Istruttore();
		i.setIstNome(IstNome.getValue().toUpperCase());
		i.setIstCognome(IstCognome.getValue().toUpperCase());
		i.setIstGrado(Istgrado.getValue().toUpperCase());
		try {
			new IstruttoreHome().merge(i);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}	
}
