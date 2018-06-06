package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Risultato {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int numMeasurements;
	private float fMed;
	
	private List<Flow> flussi;
	
	public Risultato(LocalDate startDate, LocalDate endDate, int numMeasurements, float avgFlows) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.numMeasurements = numMeasurements;
		this.fMed = avgFlows;
		this.flussi = new ArrayList<Flow>();
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public int getNumMeasurements() {
		return numMeasurements;
	}
	public float getFMed() {
		return fMed;
	}
	
	
	public List<Flow> getFlussi() {
		return flussi;
	}
	public void setFlussi(List<Flow> flussi) {
		this.flussi = flussi;
	}
	@Override
	public String toString() {
		return "Risultato [startDate=" + startDate + ", endDate=" + endDate + ", numMeasurements=" + numMeasurements
				+ ", avgFlows=" + fMed + "]";
	}
	
	
	
	

}
