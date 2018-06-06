package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Event implements Comparable<Event>{
	
	private double portata;
	private LocalDate data;
	private EventType tipo;
	
	public Event(LocalDate data, double portata,EventType tipo) {
		super();
		this.portata = portata;
		this.data = data;
		this.tipo = tipo;
	}
	
	public double getPortata() {
		return portata;
	}
	
	public void setPortata(float portata) {
		this.portata = portata;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public EventType getTipo() {
		return tipo;
	}

	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Event [portata=" + portata + ", data=" + data + "]";
	}
	
	@Override
	public int compareTo(Event altro) {
		return this.data.compareTo(altro.data);
	}
	
	

}
