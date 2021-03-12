package it.polito.tdp.librettovoti.model;

import java.util.Comparator;

public class OrdVotoPerVoto implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Voto v1 = (Voto) arg0;
		Voto v2 = (Voto) arg1;
		if(v1.getVoto()>=v2.getVoto())
			return -1;
		else
			return 1;
	}

}
