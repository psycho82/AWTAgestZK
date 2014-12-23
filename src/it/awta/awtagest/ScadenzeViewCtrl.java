package it.awta.awtagest;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
/**
 * @author Tme
 *
 */
public class ScadenzeViewCtrl extends GenericForwardComposer {
	private Datebox dbxStart;
	private Listbox lstbxStudenti;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	public void onClick$findBtn() throws InterruptedException {
		DateFormat dfm = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(dbxStart.getValue());
		c.add(Calendar.YEAR,-1);
		System.out.println(c.getTime());
		List<Soggetto> listaSoggetti = new SoggettoHome().findAllNoRinnovoByData(c.getTime());
		for(int i = 0;i<listaSoggetti.size();i++){
			c = Calendar.getInstance();
			c.setTime(listaSoggetti.get(i).getSgIscrizione());
			c.add(Calendar.YEAR,1);
			listaSoggetti.get(i).setSgIscrizione(c.getTime());
		}
		List<Soggetto> listaSoggetti2 = new SoggettoHome().findAllSiRinnovoByData(dbxStart.getValue());
		for(int i = 0;i<listaSoggetti2.size();i++){
			listaSoggetti2.get(i).setSgIscrizione(listaSoggetti2.get(i).getSgRinnovo());
		}		
		listaSoggetti.addAll(listaSoggetti2);
		for(int i = 0;i<listaSoggetti.size();i++){
				Date d = listaSoggetti.get(i).getSgIscrizione();
				c.setTime(d);
				c.set(Calendar.HOUR_OF_DAY, 0);  
				c.set(Calendar.MINUTE, 0);  
				c.set(Calendar.SECOND, 0);  
				c.set(Calendar.MILLISECOND, 0); 
				listaSoggetti.get(i).setSgIscrizione(c.getTime());
		}		
		Soggetto[] arraySog = listaSoggetti.toArray(new Soggetto[listaSoggetti.size()]);
		Arrays.sort(arraySog,new DateComparator());
		ListModelList lml = new ListModelList(arraySog);
		lstbxStudenti.setModel(lml);
		lstbxStudenti.setVisible(true);
	}
}
