package it.polito.tdp.rivers.model;

import java.util.List;
import java.util.PriorityQueue;


public class Simulatore {
	
	//Coda degli eventi
	PriorityQueue<Event> coda;
	
	//Modello del mondo
	private float c; //quantità acqua presente nel bacino da aggiornare giorno per giorno
	private float f_out_min; //erogazione minima: f_outmin
	private List<Flow> flussi;
	
	//Parametri di simulazione
	private float cMax; //capienza totale
	
	//Variabili di output
	private float cMed; //occupazione media del bacino nella simulazione
	private int giorniOff; //giorni in cui non si è potuta garantire l'erogazione minima

	public void init(float Q, Risultato ris) {
		this.cMax = Q ;
		this.c = Q/2;
		this.f_out_min = (float) 0.8 * ris.getFMed();
		this.flussi = ris.getFlussi();
		
		//crea coda e aggiunge primo evento
		this.coda = new PriorityQueue<>();
		double flusso = c+flussi.get(0).getFlow();
		if(flusso < this.cMax) {
			coda.add(new Event(ris.getFlussi().get(0).getDay(),flusso, EventType.NORMALE));
			
		}else {
			coda.add(new Event(ris.getFlussi().get(0).getDay(),flusso, EventType.TRACIMAZIONE));
		}
			
		
		//inizializzo valori output
		this.cMed= 0;
		this.giorniOff = 0;
		
		
	}

	public void run() {
		Event e ;
		while ((e = coda.poll())!= null ) {
			processEvent(e);
		}
		
	}

	private void processEvent(Event e) {
		switch(e.getTipo()) {
		case NORMALE://c < cMax viene aggiunto al bacino: viene aggiunti tutto a c e scarico f_out_min tranne nel 5%dei casi che scarico 10*f_out_min
			cMed += e.getPortata();
			if(e.getPortata()< f_out_min) {
				giorniOff++;
			}
			break;
		case TRACIMAZIONE : //c > cMax viene scaricato: viene aggiunto a c finché possibile e il resto scaricato
			
			break;
		}
			
		
	}

}
