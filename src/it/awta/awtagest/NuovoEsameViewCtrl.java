package it.awta.awtagest;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class NuovoEsameViewCtrl extends GenericForwardComposer {
	private Window winNuovoEsame;
	private Listbox lstbxStudenti;
	private Intbox sgCode;
	private Textbox sgAttestato,sgGrado,cittaEsame,esaminatore;
	private Datebox dataEsame;

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO Auto-generated method stub

	}
	public void onClick$insertBtn() throws InterruptedException{
		Soggetto sg = new Soggetto();
		WtEsame esame = new WtEsame();
		sg.setSgCode(sgCode.getValue());
		sg = new SoggettoHome().findByCode(sg);
		if(sg!=null){
			sg.setSgGrado(sgGrado.getValue().toUpperCase());
			esame.setEsCitta(cittaEsame.getValue().toUpperCase());
			esame.setEsData(dataEsame.getValue());
			esame.setEsInsSifu(esaminatore.getValue().toUpperCase());
			esame.setEsAttestato(sgAttestato.getValue());
			esame.setEsGrado(sgGrado.getValue().toUpperCase());
			esame.setSoggetto(sg);
			try {
				new SoggettoHome().update(sg);
				new WtEsameHome().insert(esame);
				List<WtEsame> lista = new ArrayList<WtEsame>();
				if(lstbxStudenti.getItems().size()!=0){
					ListModelList lml = (ListModelList) lstbxStudenti.getListModel();
					lista = (List<WtEsame>)lml.getInnerList();
					lista.add(esame);
					lstbxStudenti.setModel(lml);
				}else{
					lista.add(esame);
					lstbxStudenti.setModel(new ListModelList(lista));
				}
			} catch (Exception e) {
				e.printStackTrace();
				Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
			}
		}else{
			Messagebox.show("Numero tessera non valido!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
}
