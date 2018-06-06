package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private RiversDAO dao;
	private List<River> fiumi;
	private Risultato ris;
	
	private Simulatore sim;
	
	public Model() {
		dao = new RiversDAO();
		fiumi = dao.getAllRivers();
	}

	public List<River> getFiumi() {
		return fiumi;
	}

	public Risultato getRisultato(River r) {
		ris = dao.getRisultato(r);
		return ris;
	}

	public void simula(int k) {
		float Q = k*ris.getFMed()*3600*24*30;
		sim = new Simulatore();
		sim.init(Q, ris);
		sim.run();
		
	}
	
	
	
	

}
