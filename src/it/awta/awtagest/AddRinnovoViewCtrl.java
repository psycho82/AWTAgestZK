/**
 * 
 */
package it.awta.awtagest;

import java.text.SimpleDateFormat;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import org.zkoss.zul.Datebox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;


public class AddRinnovoViewCtrl extends GenericForwardComposer {
	private Intbox SgCode;
	private Datebox SgIscrizione,rinData;
	private Label sgNomeCognome,rinUltimo,sgIngresso;
	private Soggetto selectedSoggetto;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

	/**
	 *
	 *
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	public void onClick$saveBtn() throws InterruptedException{
    	Soggetto sog = selectedSoggetto;
		sog.setSgRinnovo(rinData.getValue());
		Rinnovo rin = new Rinnovo();
		rin.setDataRinnovo(rinData.getValue());
		rin.setSgCodeRinnovo(sog.getSgId());
		try {
			new SoggettoHome().update(sog);
			new RinnovoHome().insert(rin);
			Include content = (Include) page.getFellow("mainWin").getFellow("content");
			content.setSrc("/operazioneOK.zul");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Messagebox.show("Errore di inserimento generico!!","Errore",Messagebox.OK,Messagebox.ERROR);
		}
	}
	public void onClick$findBtn() throws InterruptedException{
		if(SgCode.getValue()!=null){
			
			selectedSoggetto = new Soggetto();
			selectedSoggetto.setSgCode(SgCode.getValue());
			selectedSoggetto = new SoggettoHome().findByCode(selectedSoggetto);
			if(selectedSoggetto!=null){
				sgNomeCognome.setValue(selectedSoggetto.getSgCognome()+" "+selectedSoggetto.getSgNome());
				if(selectedSoggetto.getSgIscrizione()!=null){
					sgIngresso.setValue(formatter.format(selectedSoggetto.getSgIscrizione()));
				}else{
					sgIngresso.setValue("Data di iscrizione non inserita.");
				}
				if(selectedSoggetto.getSgRinnovo()!=null){
					rinUltimo.setValue(formatter.format(selectedSoggetto.getSgRinnovo()));
				}else{
					rinUltimo.setValue("Ancora nessun rinnovo effettuato.");
				}				
			}else{
				Messagebox.show("Nessuno Studente trovato","Attenzione",Messagebox.OK,Messagebox.EXCLAMATION);
			}
			
		}else{
			Messagebox.show("Inserire il numero di tessera","Attenzione",Messagebox.OK,Messagebox.EXCLAMATION);
		}
	}
}
