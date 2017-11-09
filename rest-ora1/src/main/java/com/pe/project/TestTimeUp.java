package com.pe.project;

import java.util.Date;

public class TestTimeUp {
	private int id;
	private Date fecha_in;
	private Date fecha_out;
	private int monitor;
	private int oci;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_in() {
		return fecha_in;
	}
	public void setFecha_in(Date fecha_in) {
		this.fecha_in = fecha_in;
	}
	public Date getFecha_out() {
		return fecha_out;
	}
	public void setFecha_out(Date fecha_out) {
		this.fecha_out = fecha_out;
	}
	public int getMonitor() {
		return monitor;
	}
	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}
	public int getOci() {
		return oci;
	}
	public void setOci(int oci) {
		this.oci = oci;
	}	
}
