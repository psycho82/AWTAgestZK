package it.awta.awtagest;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;
/**
 * @author Tme
 *
 */
public class ModSoggettoViewCtrl extends GenericForwardComposer {
	private Bandbox bd;
	private Grid gridSoggetto;
	private Textbox SgCognome,SgNome,SgComunenasc,SgIndirizzo,SgComune,SgProvincia,SgRegione,SgGrado;
	private Label SgRinnovo;
	private Datebox SgIscrizione,SgNascita;
	private Intbox SgCode,SgTessera;
	private Combobox SgScuola,SgSifu,SgIstruttore1,SgIstruttore2,cbxSgStudente;
	private Soggetto selectedStudente = new Soggetto();
	private Listbox lstbxStudenti;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	public void onSelect$cbxSgStudente(){
		Soggetto sg = new Soggetto();
		List<Soggetto> listaSoggetti = new SoggettoHome().findByCognome(cbxSgStudente.getText());
		ListModelList lml = new ListModelList(listaSoggetti);
		lstbxStudenti.setModel(lml);
		lstbxStudenti.setVisible(true);
	}
	public void onSelect$lstbxStudenti(){
		selectedStudente = (Soggetto) lstbxStudenti.getSelectedItem().getValue();
		compilaCampi(selectedStudente);
	}
	public void onCreate$cbxSgStudente(){
		List<String> cognomi = new SoggettoHome().getAllCognomi();
		ListModel lm = new SimpleListModel(cognomi);
		cbxSgStudente.setModel(lm);
	}
	public void onClick$findBtn() throws InterruptedException {
		if(SgTessera.getValue()!=null){
			Soggetto s = new Soggetto();
			SoggettoHome sh = new SoggettoHome();
			s.setSgCode(SgTessera.getValue());
			s = sh.findByCode(s);
			if(s!=null){
				compilaCampi(s);
			}else{
				Messagebox.show("Non esistono studenti con questo numero tessera!!","Attenzione",Messagebox.OK,Messagebox.ERROR);
			}
		}else{
			Messagebox.show("Inserire il numero di tessera!!","Attenzione",Messagebox.OK,Messagebox.ERROR);
		}
		/*
		if(!cbxSgStudente.getText().equals("")){
			Soggetto s = selectedStudente;
			compilaCampi(s);
		}else if(SgTessera.getValue()!=null){
			Soggetto s = new Soggetto();
			SoggettoHome sh = new SoggettoHome();
			s.setSgCode(SgTessera.getValue());
			s = sh.findByCode(s);
			if(s!=null){
				compilaCampi(s);
			}else{
				Messagebox.show("Non esistono studenti con questo numero tessera!!","Attenzione",Messagebox.OK,Messagebox.ERROR);
			}
		}else{
			Messagebox.show("Selezionare almeno una Soggetto dall'elenco!!","Attenzione",Messagebox.OK,Messagebox.ERROR);
		}
		*/
	}
	private void compilaCampi(Soggetto s) {
	// TODO Auto-generated method stub
		SgCode.setValue(s.getSgCode());
		SgIscrizione.setValue(s.getSgIscrizione());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		if(s.getSgRinnovo()!=null){
			SgRinnovo.setValue(formatter.format(s.getSgRinnovo()));
		}else{
			SgRinnovo.setValue("Ancora nessun rinnovo effettuato");
		}
		SgGrado.setValue(s.getSgGrado());
		SgCognome.setValue(s.getSgCognome());
		SgNome.setValue(s.getSgNome());
		SgNascita.setValue(s.getSgNascita());
		SgComunenasc.setValue(s.getSgComunenasc());
		SgIndirizzo.setValue(s.getSgIndirizzo());
		SgComune.setValue(s.getSgComune());
		SgProvincia.setValue(s.getSgProvincia());
		SgRegione.setValue(s.getSgRegione());
		if(s.getScuola()!=null){
			Scuola sc = s.getScuola();
			riempiSgScuola(SgScuola,sc.getScId(),sc);
		}else{
			riempiSgScuola(SgScuola,0,null);
		}		
		if(s.getSifu()!=null){
			List<Sifu> listaSifu = new SifuHome().findExcept(s.getSifu().getSifuId());
			listaSifu.add(0, s.getSifu());
			//SgSifu.setModel(new ListModelList(listaSifu));
			for(int i = 0; i<listaSifu.size();i++){
				System.out.println(listaSifu.get(i).getSifuCognome());
				Comboitem ci = new Comboitem(listaSifu.get(i).getSifuCognome());
				ci.setDescription(listaSifu.get(i).getSifuNome());
				ci.setValue(listaSifu.get(i));
				SgSifu.appendChild(ci);
			}	
			SgSifu.setSelectedIndex(0);
			/*
			Comboitem ci = new Comboitem(s.getSifu().getSifuCognome());
			ci.setDescription(s.getSifu().getSifuNome());
			ci.setValue(s.getSifu());
			SgSifu.appendChild(ci);
			SgSifu.setSelectedItem(ci);
			*/
		}else{
			List<Sifu> listaSifu = new SifuHome().findAll();
			SgSifu.setModel(new ListModelList(listaSifu));
			Comboitem ci = new Comboitem("No SIFU");
			ci.setDescription("Associare un SiFu");
			SgSifu.appendChild(ci);
			SgSifu.setSelectedItem(ci);
		}
		Set<Istruttore> istruttori = s.getIstruttores();
		if(istruttori.size()!=0){
			Iterator<Istruttore> itr = istruttori.iterator();
			Istruttore ist = itr.next();
			riempiSgIstruttore(SgIstruttore1,ist.getIstId(),ist);
			if(istruttori.size()==2){
				ist = itr.next();
				riempiSgIstruttore(SgIstruttore2,ist.getIstId(),ist);
			}else{
				SgIstruttore2.setModel(new ListModelList(new IstruttoreHome().findAll()));
			}
		}else{
			SgIstruttore1.setModel(new ListModelList(new IstruttoreHome().findAll()));
			SgIstruttore2.setModel(new ListModelList(new IstruttoreHome().findAll()));
		}
		gridSoggetto.setVisible(true);
	}
	public void onClick$saveBtn() throws InterruptedException {
		//Soggetto s = (Soggetto) cbxSgStudente.getSelectedItem().getValue();
		Soggetto s = new Soggetto();
		s.setSgCode(SgCode.getValue());
		s = new SoggettoHome().findByCode(s);
		s.setSgIscrizione(SgIscrizione.getValue());
		s.setSgGrado(SgGrado.getValue().toUpperCase());
		s.setSgCognome(SgCognome.getValue().toUpperCase());
		s.setSgNome(SgNome.getValue().toUpperCase());
		s.setSgNascita(SgNascita.getValue());
		s.setSgComunenasc(SgComunenasc.getValue().toUpperCase());
		s.setSgIndirizzo(SgIndirizzo.getValue().toUpperCase());
		s.setSgComune(SgComune.getValue().toUpperCase());
		s.setSgProvincia(SgProvincia.getValue().toUpperCase());
		s.setSgRegione(SgRegione.getValue().toUpperCase());
		Scuola sc = (Scuola)SgScuola.getSelectedItem().getValue();
		s.setScuola(sc);
		s.setSifu((Sifu) SgSifu.getSelectedItem().getValue());
		System.out.println(s.getSifu().getSifuCognome());
		if(!SgIstruttore1.getText().equals("")){
			Set<Istruttore> istruttori = new HashSet<Istruttore>();
			istruttori.add((Istruttore) SgIstruttore1.getSelectedItem().getValue());
			if(!SgIstruttore2.getText().equals("")){
				istruttori.add((Istruttore) SgIstruttore2.getSelectedItem().getValue());
			}
			s.setIstruttores(istruttori);
		}
		try {
			new SoggettoHome().update(s);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}		
	}
	/*
	public void onCreate$SgSifu(){
		Soggetto s = selectedStudente;
		if(s.getSifu()!=null){
			List<Sifu> listaSifu = new SifuHome().findExcept(s.getSifu().getSifuId());
			listaSifu.add(0, s.getSifu());
			SgSifu.setModel(new ListModelList(listaSifu));
			for(int i = 0; i<listaSifu.size();i++){
				System.out.println(listaSifu.get(i).getSifuCognome());
			}
		}else{
			List<Sifu> listaSifu = new SifuHome().findAll();
			SgSifu.setModel(new ListModelList(listaSifu));
			Comboitem ci = new Comboitem("No SIFU");
			ci.setDescription("Associare un SiFu");
			SgSifu.appendChild(ci);
			SgSifu.setSelectedItem(ci);
		}
	}
	*/
	public void riempiSgIstruttore(Combobox cbx,int no, Istruttore sist){
		List<Istruttore> lista = new IstruttoreHome().findExcept(no);
		lista.add(sist);
		Istruttore ist = new Istruttore();
		for(int i = 0;i<lista.size();i++){
			ist = lista.get(i);
			Comboitem ci = new Comboitem(ist.getIstCognome());
			ci.setDescription(ist.getIstNome());
			ci.setValue(ist);
			cbx.appendChild(ci);
		}
		cbx.setSelectedIndex(lista.size()-1);
	}
	public void riempiSgScuola(Combobox cbx,int no, Scuola sc){
		if(no != 0){
			List<Scuola> listaScuole = new ScuolaHome().findExcept(no);
			listaScuole.add(sc);
			sc = new Scuola();
			for(int i = 0;i<listaScuole.size();i++){
				sc = listaScuole.get(i);
				//Comboitem ci = new Comboitem(sc.getScComune());
				//ci.setDescription(sc.getScNome());
				Comboitem ci = new Comboitem(sc.getScNome());
				ci.setDescription(sc.getScComune());
				ci.setValue(sc);
				cbx.appendChild(ci);
			}
			cbx.setSelectedIndex(listaScuole.size()-1);
		}else{
			List<Scuola> listaScuole = new ScuolaHome().findAll();
			sc = new Scuola();
			Comboitem ci = new Comboitem("No Scuola");
			ci.setDescription("Selezionare una Scuola");
			ci.setValue(sc);
			cbx.appendChild(ci);			
			for(int i = 0;i<listaScuole.size();i++){
				sc = listaScuole.get(i);
				ci = new Comboitem(sc.getScComune());
				ci.setDescription(sc.getScNome());
				ci.setValue(sc);
				cbx.appendChild(ci);
			}
			cbx.setSelectedIndex(0);
		}
	}
	public void onClick$resetBtn() {
		onCreate$cbxSgStudente();
		cbxSgStudente.setSelectedItem(null);
		SgTessera.setValue(null);
		gridSoggetto.setVisible(false);
		lstbxStudenti.setVisible(false);
	}
	public void onSelect$SgSifu(){
		Sifu s = (Sifu)SgSifu.getSelectedItem().getValue();
		System.out.println(s.getSifuCognome());
		//selectedStudente.setSifu(sifu);
		
	}
}
