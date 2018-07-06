package model;

import java.time.LocalDateTime;

public class HeathCheckup {

	private String idDoc, idPat;
	private Measurements type;
	private LocalDateTime time;
	private float value;
	
	public HeathCheckup(String idDoc, String idPat, Measurements type, float value) {
		this.idDoc = idDoc;
		this.idPat = idPat;
		this.type = type;
		this.time = LocalDateTime.now();
		this.value = value;
	}

	public Measurements getType() {
		return type;
	}

	public String getIdPat() {
		return idPat;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public float getValue() {
		return value;
	}

	public String getIdDoc() {
		return idDoc;
	}

	public int compareTo(HeathCheckup hc) {
		
		return (hc.type == this.type) ? -1 : 0;
	}
}
