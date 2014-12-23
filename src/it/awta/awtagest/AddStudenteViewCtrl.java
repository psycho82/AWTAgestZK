/**
 * 
 */
package it.awta.awtagest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class AddStudenteViewCtrl extends GenericForwardComposer {
	private Intbox SgCode;
	private Datebox SgIscrizione;
	private Textbox SgGrado;
	private Textbox SgCognome;
	private Textbox SgNome;
	private Datebox SgNascita;
	private Textbox SgComunenasc;
	private Textbox SgIndirizzo;
	private Textbox SgComune;
	private Textbox SgProvincia;
	private Textbox SgRegione;
	private Listbox SgScuola;
	private Combobox cbxSgScuola,SgSifu;
	private Combobox SgIstruttore1,SgIstruttore2;
	private Bandbox bd;
	private Scuola selectedScuola = new Scuola();

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	public void onChage$cbxSgScuola(){
		selectedScuola = new ScuolaHome().findScuolaByComune(cbxSgScuola.getText().toUpperCase());
	}
	public void onSelect$cbxSgScuola(){
		selectedScuola = (Scuola) cbxSgScuola.getSelectedItem().getValue();
	}
	public void onClick$saveBtn() throws InterruptedException{
    	Soggetto sog = new Soggetto();
		sog.setSgCode(SgCode.getValue());
		sog.setSgIscrizione(SgIscrizione.getValue());
		sog.setSgRinnovo(null);
		sog.setSgGrado(SgGrado.getValue().toUpperCase());
		sog.setSgCognome(SgCognome.getValue().toUpperCase());
		sog.setSgNome(SgNome.getValue().toUpperCase());
		sog.setSgNascita(SgNascita.getValue());
		sog.setSgComunenasc(SgComunenasc.getValue().toUpperCase());
		sog.setSgIndirizzo(SgIndirizzo.getValue().toUpperCase());
		sog.setSgComune(SgComune.getValue().toUpperCase());
		sog.setSgProvincia(SgProvincia.getValue().toUpperCase());
		sog.setSgRegione(SgRegione.getValue().toUpperCase());
		sog.setScuola(selectedScuola);
		sog.setSifu((Sifu) SgSifu.getSelectedItem().getValue());
		if(!SgIstruttore1.getText().equals("")||!SgIstruttore2.getText().equals("")){
			Set<Istruttore> istruttori = new HashSet<Istruttore>();
			if(!SgIstruttore1.getText().equals("")){
				istruttori.add((Istruttore) SgIstruttore1.getSelectedItem().getValue());
			}
			if(!SgIstruttore2.getText().equals("")){
				istruttori.add((Istruttore) SgIstruttore2.getSelectedItem().getValue());
			}
			if(istruttori!=null){
				sog.setIstruttores(istruttori);
			}
		}
		SoggettoHome sogHome = new SoggettoHome();
		System.out.println("Id Sc: "+sog.getScuola().getScId()+"Id Sifu: "+sog.getSifu().getSifuId());
		try {
			sogHome.insert(sog);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onCreate$bd() throws InterruptedException{
		bd.setConstraint("");
		List<Scuola> listScuola = (List<Scuola>) new ScuolaHome().findAll();
		if(listScuola.size()!=0){
			List<Scuola> listaScuola = new ScuolaHome().findAll();
			ListModelList lml = new ListModelList(listaScuola);
			SgScuola.setModel(lml);
		}else{
			Messagebox.show("Nessuna Scuola trovata!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
		bd.setConstraint("no empty");
	}
	public void onCreate$cbxSgScuola() throws InterruptedException{
		cbxSgScuola.setConstraint("");
		List<Scuola> listScuola = (List<Scuola>) new ScuolaHome().findAll();
		if(listScuola.size()!=0){
			List<Scuola> listaScuola = new ScuolaHome().findAll();
			ListModelList lml = new ListModelList(listaScuola);
			cbxSgScuola.setModel(lml);
		}else{
			Messagebox.show("Nessuna Scuola trovata!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
		cbxSgScuola.setConstraint("no empty");
	}
	public void onCreate$SgSifu(){
		SgSifu.setModel(new ListModelList(new SifuHome().findAll()));
	}
	public void onCreate$SgIstruttore1(){
		SgIstruttore1.setModel(new ListModelList(new IstruttoreHome().findAll()));
	}
	public void onCreate$SgIstruttore2(){
		SgIstruttore2.setModel(new ListModelList(new IstruttoreHome().findAll()));
	}
}
