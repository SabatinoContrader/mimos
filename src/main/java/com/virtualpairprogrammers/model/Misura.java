package com.virtualpairprogrammers.model;
import java.util.Date;

public class Misura {
	
	private int id_misura;
    private int id_paziente;
    private float pressione;
    private int battiti;
    private float temperatura;
    private float glicemia;
    private Date data;
    

    public Misura() {}
    
    public Misura(int id_misura, int id_paziente, float pressione, int battiti, float temperatura, float glicemia, Date data) {
    this.setId_misura(id_misura);
    this.setId_paziente(id_paziente);
    this.setPressione(pressione);
    this.setBattiti(battiti);
    this.setTemperatura(temperatura);
    this.setGlicemia(glicemia);
    this.setData(data);
    }

	public int getId_misura() {
		return id_misura;
	}

	public void setId_misura(int id_misura) {
		this.id_misura = id_misura;
	}

	public int getId_paziente() {
		return id_paziente;
	}

	public void setId_paziente(int id_paziente) {
		this.id_paziente = id_paziente;
	}

	public float getPressione() {
		return pressione;
	}

	public void setPressione(float pressione) {
		this.pressione = pressione;
	}

	public int getBattiti() {
		return battiti;
	}

	public void setBattiti(int battiti) {
		this.battiti = battiti;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(float glicemia) {
		this.glicemia = glicemia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
