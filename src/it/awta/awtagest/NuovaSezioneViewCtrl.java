package it.awta.awtagest;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class NuovaSezioneViewCtrl extends GenericForwardComposer {
	private Listbox lstbxStudenti;
	private Intbox sgCode;
	private Textbox cittaEsame,esaminatore,sgGrado;
	private Datebox dataEsame;
	private Combobox sgSezione;
	private Soggetto selectedSoggetto;
	//private Label lblNewGrado;
	private Button insertBtn;
	private String nextGrado;

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
		//Soggetto sg = new Soggetto();
		WsSezione sezione = new WsSezione();
/*		sg.setSgCode(sgCode.getValue());
		sg = new SoggettoHome().findByCode(sg);*/
		//selectedSoggetto = sg;
		if(selectedSoggetto!=null){
			selectedSoggetto.setSgGrado(sgGrado.getValue().toUpperCase());
			sezione.setWssezCitta(cittaEsame.getValue().toUpperCase());
			sezione.setWssezData(dataEsame.getValue());
			sezione.setWssezInsSifu(esaminatore.getValue().toUpperCase());
			sezione.setWssezAttestato(null);
			sezione.setWssezGrado(sgGrado.getValue().toUpperCase());
			sezione.setSezione(new Sezione(sgSezione.getText().toUpperCase(), sgGrado.getValue().toUpperCase(), null));
			sezione.setSoggetto(selectedSoggetto);
			try {
				new SoggettoHome().update(selectedSoggetto);
				new WsSezioneHome().insert(sezione);
				List<WsSezione> lista = new ArrayList<WsSezione>();
				if(lstbxStudenti.getItems().size()!=0){
					ListModelList lml = (ListModelList) lstbxStudenti.getListModel();
					lista = (List<WsSezione>)lml.getInnerList();
					lista.add(sezione);
					lstbxStudenti.setModel(lml);
				}else{
					lista.add(sezione);
					lstbxStudenti.setModel(new ListModelList(lista));
				}
				cittaEsame.setDisabled(true);
				esaminatore.setDisabled(true);
				dataEsame.setDisabled(true);
			} catch (Exception e) {
				e.printStackTrace();
				Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
			}
		}else{
			Messagebox.show("Numero tessera non valido!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onChange$sgGrado(){
		Sezione s = new Sezione();
		s.setSezGrado(sgGrado.getValue().toUpperCase());
		List<Sezione> lista = new SezioneHome().findByGrado(s);
		sgSezione.setModel(new ListModelList(lista));
	}
	public void onChange$sgCode(){
		Soggetto sg = new Soggetto();
		sg.setSgCode(sgCode.getValue());
		sg = new SoggettoHome().findByCode(sg);
		selectedSoggetto = sg;
		if(!selectedSoggetto.getSgGrado().substring(2).equals("GS")){
			alert("Lo studente selezionato non � un Grado Superiore");
			insertBtn.setDisabled(true);
		}else{
			insertBtn.setDisabled(false);
			calcolaGrado();
			onChange$sgGrado();
		}
	}
	public String calcolaGrado(){
		String grado = selectedSoggetto.getSgGrado();
		nextGrado = grado.toUpperCase();
		int sg_id = selectedSoggetto.getSgId();
		int size = new WsSezioneHome().findFromGrado(grado, sg_id);
		if(grado.equals("1 GS")&&size==5){
			nextGrado = "2 GS";
		}else if(grado.equals("2 GS")&&size==5){
			nextGrado = "3 GS";
		}else if(grado.equals("3 GS")&&size==10){
			nextGrado = "4 GS";
		}else if(grado.equals("4 GS")&&size==12){
			nextGrado = "5 GS";
		}else if(grado.equals("5 GS")&&size==15){
			nextGrado = "6 GS";
		}else if(grado.equals("6 GS")&&size==9){
			nextGrado = "7 GS";
		}else if(grado.equals("7 GS")&&size==9){
			nextGrado = "SIFU";
		}
		sgGrado.setValue(nextGrado);
		return nextGrado;
	}
}

