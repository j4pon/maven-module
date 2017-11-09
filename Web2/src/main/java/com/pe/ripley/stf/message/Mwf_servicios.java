package com.pe.ripley.stf.message;

public class Mwf_servicios {

	private int id;
	private String descripcion;
	private int  log_monitor;
	private int log_journal;
	private int call_backend;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getLog_monitor() {
		return log_monitor;
	}
	public void setLog_monitor(int log_monitor) {
		this.log_monitor = log_monitor;
	}
	public int getLog_journal() {
		return log_journal;
	}
	public void setLog_journal(int log_journal) {
		this.log_journal = log_journal;
	}
	public int getCall_backend() {
		return call_backend;
	}
	public void setCall_backend(int call_backend) {
		this.call_backend = call_backend;
	}	
}
