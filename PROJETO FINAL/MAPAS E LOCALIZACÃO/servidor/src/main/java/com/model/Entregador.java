package com.model;


import java.io.Serializable;

public class Entregador implements Serializable {

    //posição da entrega que esta realizado

    private double lat;
    private double log;

    public Entregador() {
    	this.lat = -4.970183;
    	this.log = -39.016111;
    }

	public Entregador(double lat, double log) {
		super();
		this.lat = lat;
		this.log = log;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLog() {
		return log;
	}

	public void setLog(double log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return "Entregador [lat=" + lat + ", log=" + log + "]";
	}
	
	
    
    
}
