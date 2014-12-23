/**
 * 
 */
package it.awta.awtagest;

import java.util.List;

import org.hibernate.ejb.CurrentEntityManagerImpl;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 * @author TmelstbxEsami1
 *
 */
public class RicercaEsameViewCtrl extends GenericForwardComposer {

	private Window winRicercaEsame;
	private Listbox lstbxEsami1,lstbxEsami2,lstbxStudenti,lstbxEsamiFromCognome;
	private Button findEsame,saveBtn,deleteBtn;
	private Datebox dbxEsame;
	private Textbox sgAttestato,sgGrado,cittaEsame,esaminatore;
	private Datebox dataEsame;
	private Intbox sgCode;
	private Groupbox gbxDettagli;
	private Radiogroup rgRicerca;
	private Label lblData,lblCognome,lblCognomeIst;
	private Combobox cbxSgStudente,cbxEsaminatore;
	private Soggetto selectedStudente = new Soggetto();
	private Listheader lhData;
	private Listcell lcData;
	private Auxheader ahTab1;
	private WtEsame currentEsame = new WtEsame();

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

	public void onSelect$lstbxEsami1() {
		WtEsame selectedEsame = (WtEsame) lstbxEsami1.getSelectedItem().getValue();
		//currentEsame = selectedEsame;
		WtEsame esame = new WtEsame();
		esame.setEsData(selectedEsame.getEsData());
		esame.setEsInsSifu(selectedEsame.getEsInsSifu());
		esame.setEsCitta(selectedEsame.getEsCitta());
		List<WtEsame> lista = new WtEsameHome().findBySelection(esame);
		lstbxEsami2.setModel(new ListModelList(lista));
		lstbxEsami2.setVisible(true);
		gbxDettagli.setVisible(false);
	}
	public void onSelect$lstbxEsami2() {
		WtEsame selectedEsame = (WtEsame) lstbxEsami2.getSelectedItem().getValue();
		currentEsame = selectedEsame;
		cittaEsame.setValue(selectedEsame.getEsCitta());
		dataEsame.setValue(selectedEsame.getEsData());
		esaminatore.setValue(selectedEsame.getEsInsSifu());
		sgCode.setValue(selectedEsame.getSoggetto().getSgCode());
		sgAttestato.setValue(selectedEsame.getEsAttestato());
		sgGrado.setValue(selectedEsame.getEsGrado());
		gbxDettagli.setVisible(true);
		saveBtn.setDisabled(false);
		deleteBtn.setDisabled(false);
	}
	public void findEsame() throws InterruptedException {
		gbxDettagli.setVisible(false);
		if(rgRicerca.getSelectedItem()!=null){
			WtEsame esame = new WtEsame();
			lstbxEsamiFromCognome.setVisible(false);
			if(rgRicerca.getSelectedItem().getLabel().equals("Data")){
				esame.setEsData(dbxEsame.getValue());
				List<WtEsame> lista = new WtEsameHome().findByData(esame);
				lcData.setVisible(false);
				lhData.setVisible(false);
				ahTab1.setColspan(2);
				lstbxEsami1.setModel(new ListModelList(lista));
				lstbxEsami2.setVisible(false);
				gbxDettagli.setVisible(false);
				lstbxEsami1.setVisible(true);
			}else if(rgRicerca.getSelectedItem().getLabel().equals("Esaminatore")){
				esame.setEsInsSifu(cbxEsaminatore.getText());
				List<WtEsame> lista = new WtEsameHome().findByEsaminatore(esame);
				lcData.setVisible(true);
				lhData.setVisible(true);
				ahTab1.setColspan(3);
				lstbxEsami1.setModel(new ListModelList(lista));
				lstbxEsami2.setVisible(false);
				gbxDettagli.setVisible(false);
				lstbxEsami1.setVisible(true);
			}else{
				List<WtEsame> listaEsami = new WtEsameHome().getEsamiFromSoggetto(selectedStudente.getSgId());
				lstbxEsamiFromCognome.setModel(new ListModelList(listaEsami));
				lstbxEsamiFromCognome.setVisible(true);
				lstbxEsami1.setVisible(false);
				lstbxEsami2.setVisible(false);
			}
		}else{
			Messagebox.show("Effettuare almeno una scelta!!","Attenzione",Messagebox.OK,Messagebox.EXCLAMATION);
		}
	}	
	public void onClick$findEsame() throws InterruptedException {
		gbxDettagli.setVisible(false);
		if(rgRicerca.getSelectedItem()!=null){
			WtEsame esame = new WtEsame();
			lstbxEsamiFromCognome.setVisible(false);
			if(rgRicerca.getSelectedItem().getLabel().equals("Data")){
				esame.setEsData(dbxEsame.getValue());
				List<WtEsame> lista = new WtEsameHome().findByData(esame);
				lcData.setVisible(false);
				lhData.setVisible(false);
				ahTab1.setColspan(2);
				lstbxEsami1.setModel(new ListModelList(lista));
				lstbxEsami2.setVisible(false);
				gbxDettagli.setVisible(false);
				lstbxEsami1.setVisible(true);
			}else if(rgRicerca.getSelectedItem().getLabel().equals("Esaminatore")){
				esame.setEsInsSifu(cbxEsaminatore.getText());
				List<WtEsame> lista = new WtEsameHome().findByEsaminatore(esame);
				lcData.setVisible(true);
				lhData.setVisible(true);
				ahTab1.setColspan(3);
				lstbxEsami1.setModel(new ListModelList(lista));
				lstbxEsami2.setVisible(false);
				gbxDettagli.setVisible(false);
				lstbxEsami1.setVisible(true);
			}else{
				List<WtEsame> listaEsami = new WtEsameHome().getEsamiFromSoggetto(selectedStudente.getSgId());
				lstbxEsamiFromCognome.setModel(new ListModelList(listaEsami));
				lstbxEsamiFromCognome.setVisible(true);
				lstbxEsami1.setVisible(false);
				lstbxEsami2.setVisible(false);
			}
		}else{
			Messagebox.show("Effettuare almeno una scelta!!","Attenzione",Messagebox.OK,Messagebox.EXCLAMATION);
		}
	}
	
	public void onClick$saveBtn() throws InterruptedException{
		WtEsame esame = (WtEsame) lstbxEsami2.getSelectedItem().getValue();
		Soggetto sg = esame.getSoggetto();
		sg.setSgGrado(sgGrado.getValue().toUpperCase());
		esame.setEsCitta(cittaEsame.getValue().toUpperCase());
		esame.setEsData(dataEsame.getValue());
		esame.setEsInsSifu(esaminatore.getValue().toUpperCase());
		esame.setEsAttestato(sgAttestato.getValue());
		esame.setEsGrado(sgGrado.getValue().toUpperCase());
		esame.setSoggetto(sg);
		try {
			new SoggettoHome().update(sg);
			new WtEsameHome().update(esame);
			onSelect$lstbxEsami1();
			saveBtn.setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onCheck$rgRicerca(){
		String value = rgRicerca.getSelectedItem().getLabel();
		lstbxEsamiFromCognome.setVisible(false);
		gbxDettagli.setVisible(false);
		if(value.equals("Data")){
			findEsame.setVisible(true);
			lstbxStudenti.setVisible(false);
			lblCognome.setVisible(false);
			cbxSgStudente.setVisible(false);
			lblCognomeIst.setVisible(false);
			cbxEsaminatore.setVisible(false);
			lblData.setVisible(true);
			dbxEsame.setVisible(true);
		}else if(rgRicerca.getSelectedItem().getLabel().equals("Esaminatore")){
			lstbxStudenti.setVisible(false);
			lblCognomeIst.setVisible(true);
			cbxEsaminatore.setVisible(true);
			lblData.setVisible(false);
			dbxEsame.setVisible(false);
			lblCognome.setVisible(false);
			cbxSgStudente.setVisible(false);
		}else{
			lblCognome.setVisible(true);
			cbxSgStudente.setVisible(true);
			lblData.setVisible(false);
			dbxEsame.setVisible(false);
			lblCognomeIst.setVisible(false);
			cbxEsaminatore.setVisible(false);
		}
	}
	public void onSelect$cbxSgStudente(){
		lstbxEsamiFromCognome.setVisible(false);
		gbxDettagli.setVisible(false);
		lstbxEsami1.setVisible(false);
		lstbxEsami2.setVisible(false);
		List<Soggetto> listaSoggetti = new SoggettoHome().findByCognome(cbxSgStudente.getText());
		ListModelList lml = new ListModelList(listaSoggetti);
		lstbxStudenti.setModel(lml);
		lstbxStudenti.setVisible(true);
	}
	public void onSelect$cbxEsaminatore() throws InterruptedException{
		findEsame();
	}
	public void onCreate$cbxSgStudente(){
		List<String> cognomi = new SoggettoHome().getAllCognomi();
		ListModel dictModel= new SimpleListModel(cognomi);
		cbxSgStudente.setModel(dictModel);
	}
	public void onCreate$cbxEsaminatore(){
		List<String> cognomi = new WtEsameHome().getAllCognomiEsaminatori();
		ListModel dictModel= new SimpleListModel(cognomi);
		cbxEsaminatore.setModel(dictModel);
	}
	public void onSelect$lstbxStudenti() throws InterruptedException{
		selectedStudente = (Soggetto) lstbxStudenti.getSelectedItem().getValue();
		findEsame();
	}
	public void onSelect$lstbxEsamiFromCognome(){
		WtEsame selectedEsame = (WtEsame) lstbxEsamiFromCognome.getSelectedItem().getValue();
		currentEsame = selectedEsame;
		cittaEsame.setValue(selectedEsame.getEsCitta());
		dataEsame.setValue(selectedEsame.getEsData());
		esaminatore.setValue(selectedEsame.getEsInsSifu());
		sgCode.setValue(selectedEsame.getSoggetto().getSgCode());
		sgAttestato.setValue(selectedEsame.getEsAttestato());
		sgGrado.setValue(selectedEsame.getEsGrado());
		gbxDettagli.setVisible(true);
		saveBtn.setDisabled(false);
		deleteBtn.setDisabled(false);
		gbxDettagli.setVisible(true);
	}
	public void onClick$deleteBtn() throws InterruptedException{
		try{
			new WtEsameHome().delete(currentEsame);
			onSelect$lstbxEsami1();
			gbxDettagli.setVisible(false);
		}catch (Exception e) {
			// TODO: handle exception
			alert("Errore nella cancellazione!!");
		}
	}
}
