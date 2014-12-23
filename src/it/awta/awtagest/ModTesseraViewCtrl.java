package it.awta.awtagest;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
/**
 * @author Tme
 *
 */
public class ModTesseraViewCtrl extends GenericForwardComposer {
	private Intbox prevTessera,nextTessera;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	public void onClick$saveBtn() throws InterruptedException {
		Soggetto sog = new Soggetto();
		sog.setSgCode(prevTessera.getValue());
		sog = new SoggettoHome().findByCode(sog);
		sog.setSgCode(nextTessera.getValue());
		new SoggettoHome().update(sog);
		Messagebox.show("Modifica apportata correttamente.");
	}
}
