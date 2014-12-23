package it.awta.awtagest;

import java.util.Comparator;

public class DateComparator implements Comparator<Soggetto>{
	
	public int compare(Soggetto s1, Soggetto s2) {
		if (s1.getSgIscrizione().before(s2.getSgIscrizione())) {
			return 1;
		} else if (s1.getSgIscrizione().after(s2.getSgIscrizione())) {
			return -1;
		} else {
			return 0;
		}
	 }
}
