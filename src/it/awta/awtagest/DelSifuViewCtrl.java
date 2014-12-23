package it.awta.awtagest;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

public class DelSifuViewCtrl extends GenericForwardComposer {
	private Combobox cbxSifu; 
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub
	}

	public void onClick$delBtn() throws InterruptedException {
		Sifu s = (Sifu) cbxSifu.getSelectedItem().getValue();
		try{
			new SifuHome().deleteSifu(s);
			onCreate$cbxSifu();
			cbxSifu.setText("");
			Messagebox.show("Sifu eliminato correttamente","Operazione eseguita",Messagebox.OK,Messagebox.INFORMATION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Messagebox.show("Non puoi cancellare questo Sifu.\nForse è associato a degli studenti!!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}		
	}

	public void onCreate$cbxSifu() {
		List<Sifu> listaSifu = new SifuHome().findAll();
		ListModelList lml = new ListModelList(listaSifu);
		cbxSifu.setModel(lml);
	}
}
