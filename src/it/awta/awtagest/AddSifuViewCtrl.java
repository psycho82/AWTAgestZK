/**
 * 
 */
package it.awta.awtagest;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class AddSifuViewCtrl extends GenericForwardComposer {
	private Textbox SifuCognome;
	private Textbox SifuNome;

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
		Sifu i = new Sifu();
		i.setSifuNome(SifuNome.getValue().toUpperCase());
		i.setSifuCognome(SifuCognome.getValue().toUpperCase());
		try {
			new SifuHome().merge(i);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}	
}
